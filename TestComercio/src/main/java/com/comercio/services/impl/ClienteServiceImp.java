package com.comercio.services.impl;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.comercio.dao.model.Cliente;
import com.comercio.dao.model.dto.ClienteDTO;
import com.comercio.dao.model.dto.FindCliente_IN;
import com.comercio.dao.model.dto.FindCliente_OUT;
import com.comercio.dao.model.dto.ManageCliente_IN;
import com.comercio.dao.model.dto.ManageCliente_OUT;
import com.comercio.dao.repository.ClienteRepository;
import com.comercio.dao.repository.specification.ClienteSpecification;
import com.comercio.services.ClienteService;



@Transactional(rollbackFor = { Exception.class })
@Service
public class ClienteServiceImp implements ClienteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImp.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	/**
	 * Gestiona la creacción o modificacion de los datos de un cliente
	 * @param manageCliente_in
	 * @return
	 * @throws Exception
	 */
	@Override
	public ManageCliente_OUT manageCliente (ManageCliente_IN manageCliente_in)throws Exception{
		
		com.comercio.dao.model.dto.ManageCliente_OUT manageCliente_Out = new ManageCliente_OUT();
		
			LOGGER.debug("iniciando gestión cliente");
			
			//validamos la entrada
			this.validarEntrada(manageCliente_in);
			
			//Segun la operacion, creamos usuario o modificamos
			if(manageCliente_in.getOperationType()==1){
				
				manageCliente_Out = this.crearCliente(manageCliente_in.getCliente());
				
			}else if(manageCliente_in.getOperationType()==2){
				
				manageCliente_Out = this.modificarCliente(manageCliente_in.getCliente());
				
			}
		
		return manageCliente_Out;
		
	}
	

	/**
	 * Modifica los datos de un cliente de la BBDD con los nuevos que nos aporta los parámetros de entrada
	 * @param clienteDto
	 * @return
	 */	
	private ManageCliente_OUT modificarCliente(ClienteDTO clienteDto) throws Exception {
		
		com.comercio.dao.model.dto.ManageCliente_OUT manageCliente_Out = new ManageCliente_OUT();
		
		com.comercio.dao.model.Cliente clienteUpdate =  clienteRepository.findOne(clienteDto.getIdCliente());
		
		
		if(clienteUpdate==null){
			throw new Exception("no existe el cliente");			
		}else{
			
			//si existe modificamos los datos y lo persistimmos
			clienteUpdate.setDireccion(clienteDto.getDireccion());
			clienteUpdate.setNombre(clienteDto.getNombre());
			
			clienteRepository.saveAndFlush(clienteUpdate);
			
			LOGGER.debug("Finalizado la modificación del cliente");
			
			manageCliente_Out.setCliente(clienteDto);
			
		}
		return manageCliente_Out;
	}

	/**
	 * Crea un núevo cliente con los datos recibidos
	 * @param clienteDto
	 * @return
	 */
	private ManageCliente_OUT crearCliente(ClienteDTO clienteDto) {		
		com.comercio.dao.model.dto.ManageCliente_OUT manageCliente_Out = new ManageCliente_OUT();
		
		com.comercio.dao.model.Cliente clienteInsertar = new com.comercio.dao.model.Cliente();
		
		clienteInsertar.setDireccion(clienteDto.getDireccion());
		clienteInsertar.setNombre(clienteDto.getNombre());
		clienteInsertar.setFechaAlta(new Date());
		
		clienteRepository.saveAndFlush(clienteInsertar);
		
		clienteDto.setIdCliente(clienteInsertar.getIdCliente());	
		
		manageCliente_Out.setCliente(clienteDto);
		
		return manageCliente_Out;
	}

	/**
	 * Validamos los datos de entrada, para asegurarnos que el parámetros traiga todos los datos que necesitaremos
	 * @param manageCliente_in
	 * @throws Exception
	 */
	private void validarEntrada(ManageCliente_IN manageCliente_in)throws Exception {
		
		if (manageCliente_in == null || manageCliente_in.getCliente()==null 
				|| manageCliente_in.getCliente().getNombre()==null
				|| manageCliente_in.getOperationType()==2 && manageCliente_in.getCliente().getIdCliente()==null){
			
			throw new Exception("Fallo en los datos de entrada del manageCliente_IN");
			
		}		
		
	}
	
	@Override
	public FindCliente_OUT findCliente (FindCliente_IN findCliente_IN )throws Exception {
		
		com.comercio.dao.model.dto.FindCliente_OUT findClienteOut = new com.comercio.dao.model.dto.FindCliente_OUT();
		
		
		Specifications<Cliente> listaPredicados= this.listaSpecification (findCliente_IN);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List <ClienteDTO> cliensdto = new ArrayList<ClienteDTO>();
		
		clientes = clienteRepository.findAll(listaPredicados);
		
		for (Cliente clie : clientes){			
			ClienteDTO cli = new ClienteDTO();
			
			cli.setDireccion(clie.getDireccion());
			cli.setIdCliente(clie.getIdCliente());
			cli.setNombre(clie.getNombre());
			cli.setVentas(clie.getVentas());
			
			cliensdto.add(cli);
			
		}
		
		
		findClienteOut.setClientes(cliensdto.toArray(new ClienteDTO [cliensdto.size()]));
		
		return findClienteOut;
		
	}


	private Specifications<Cliente> listaSpecification(FindCliente_IN findCliente_IN) {

		LOGGER.debug("Comenzamos a crear los predicados");
		
		Specifications<Cliente> listpredicados = Specifications.where(null);


		if(findCliente_IN!=null){
		
		if(findCliente_IN.getToDate()!=null || findCliente_IN.getFromDate()!=null){
			listpredicados = listpredicados.and(ClienteSpecification.byRAngeDate(findCliente_IN.getFromDate(), findCliente_IN.getToDate()))	;			
			
		}
		
		//TODO: falta por construir por si vienen informado de datos de clientes
		if(findCliente_IN.getClientes()!=null && findCliente_IN.getClientesLength()>0){
			
			List <Long> listaID = new ArrayList<Long>();
			List <String> listaNombres = new ArrayList<String>();
			List <String> listDirecciones = new ArrayList<String>();						
			
			//Creamos las listas con los datos que vengan para utilizarlos como filtros en la busqueda de clientes
			for (ClienteDTO clienteAux : findCliente_IN.getClientes()){	
				if(clienteAux.getIdCliente()!=null){
					listaID.add(clienteAux.getIdCliente());
				}
				if(clienteAux.getDireccion()!=null){
					listDirecciones.add(clienteAux.getDireccion());
				}
				if(clienteAux.getNombre()!=null){
					listaNombres.add(clienteAux.getNombre());					
				}
			}
			
			//y realizamos las especificaciones segun los datos
			if(!listaID.isEmpty()){
				listpredicados = listpredicados.and(ClienteSpecification.byIds(listaID));
				
			}
			if(!listaNombres.isEmpty()){
				listpredicados = listpredicados.and(ClienteSpecification.byNombres(listaNombres));
				
			}
			if(!listDirecciones.isEmpty()){
				listpredicados = listpredicados.and(ClienteSpecification.byDirecciones (listDirecciones));
				
			}			
			
		}
		
		
		
		}
		
		return listpredicados;
	}
	
}
