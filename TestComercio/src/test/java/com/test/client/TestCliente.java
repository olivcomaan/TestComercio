package com.test.client;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comercio.dao.model.dto.ClienteDTO;
import com.comercio.dao.model.dto.FindCliente_IN;
import com.comercio.dao.model.dto.ManageCliente_IN;
import com.comercio.dao.model.dto.ManageCliente_OUT;
import com.comercio.dao.model.dto.VentaDTO;
import com.comercio.dao.model.Cliente;
import com.comercio.dao.repository.ClienteRepository;
import com.comercio.dao.repository.VentasRepository;
import com.comercio.services.ClienteService;
import com.comercio.services.VentasService;
import com.comercio.services.impl.VentasServiceImp;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/applicationContext.xml")
public class TestCliente {
	
		
	@Autowired
	VentasService ventasService;
	
	@Autowired
	ClienteService clienteService;
	
	
	
	
	@Test
	@Ignore
	public void crearCliente() {
		
		ManageCliente_IN manageCliente_in = new ManageCliente_IN();
		
		manageCliente_in.setOperationType(1);
		
		ClienteDTO cliente = new ClienteDTO();
		
		cliente.setDireccion("CAlle seguimos con las versiones");
		cliente.setNombre("Angel");		
		manageCliente_in.setCliente(cliente );
		
		try {
			ManageCliente_OUT manageClienteOut = clienteService.manageCliente(manageCliente_in );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void modificarCliente (){
		
		ManageCliente_IN manageCliente_in = new ManageCliente_IN();
		
		manageCliente_in.setOperationType(2);
		
		ClienteDTO cliente = new ClienteDTO();
		
		cliente.setIdCliente(8L);
		cliente.setDireccion("HolaYa está hecho");
		cliente.setNombre("Angel");		
		manageCliente_in.setCliente(cliente );
		
		try {
			ManageCliente_OUT manageClienteOut = clienteService.manageCliente(manageCliente_in );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void buscarCLient(){
		
		
		FindCliente_IN findCliente_IN = new FindCliente_IN();
		
//		Date fromDAte = new Date(1/24/2015);		
		Date fromDAte = new Date();
		
		findCliente_IN.setFromDate(fromDAte );
		
		try {
			
			clienteService.findCliente(findCliente_IN );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void buscarClienteByName(){
		
		FindCliente_IN findCliente_IN = new FindCliente_IN();
		
		ClienteDTO[] clientes = new ClienteDTO[2];
		clientes[0] = new ClienteDTO();
		clientes[0].setNombre("an");
		
		clientes[1] = new ClienteDTO();
		clientes[1].setNombre("Pedro");		
		
		
		findCliente_IN.setClientes(clientes );
		
		
			Date toDAte = new Date();
		
		findCliente_IN.setToDate(toDAte );
		
		
		try {
			
			
			clienteService.findCliente(findCliente_IN );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void buscaFullClient(){
		
try {
	FindCliente_IN findCliente_IN = new FindCliente_IN();
			
			clienteService.findCliente(findCliente_IN );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

//	@Test
//	public void sakarImportes(){
//		//RepositoryVentasServiceImp asdf = new RepositoryVentasServiceImp(ventas);
//		Page <VentaDTO> ventaimportes = ventasService.findBillBetween(50d, 300d);
//		List <VentaDTO> listaventas = ventaimportes.getContent();
//		System.out.println("#################################");
//		System.out.println("Listado de VENTAS entre 50 y 300");
//		System.out.println("#################################");
//		for(VentaDTO ventaDTO: listaventas){
//			System.out.println(ventaDTO.getEmpleado().getNombre()+" hizo una venta de "+ventaDTO.getImporte()+" euros a " 
//					+ventaDTO.getCliente().getNombre());			
//		}
//		System.out.println("===================================");
//		
//		
//		
//	}
//	
//	@Test
//	public void listadoVentaEmple(){
//		//RepositoryVentasServiceImp as = new RepositoryVentasServiceImp(ventas);
//		Page <VentaDTO> ventasEmple =ventasService.findBillByNameEmple("Maria");
//		List <VentaDTO> asResult= ventasEmple.getContent();
//		System.out.println("#################################");
//		System.out.println("Listado de ventas de Maria");
//		System.out.println("#################################");
//		for(VentaDTO ventaDTO: asResult){
//			System.out.println(ventaDTO.getIdVenta()+ " "+ ventaDTO.getImporte()+ " "+ ventaDTO.getCliente().getNombre());			
//		}
//		System.out.println("===================================");
//	}
//	
//	
//	@Test
//	public void listadoVentaEmpleBetweenImport(){
//		System.out.println("#################################");
//		System.out.println("TEST LISTADOVENTAEMPLEBETWEENIMPORT");
//		System.out.println("#################################");
//		//RepositoryVentasServiceImp as = new RepositoryVentasServiceImp(ventas);
//		Page <VentaDTO> ventasEmple =ventasService.findBillByNameEmpleBetweenImport("Maria", 50d, 300d);
//		List <VentaDTO> asResult= ventasEmple.getContent();
//		System.out.println("#################################");
//		System.out.println("Listado de ventas de MAria entre 50 y 100");
//		System.out.println("#################################");
//		for(VentaDTO ventaDTO: asResult){
//			System.out.println(ventaDTO.getIdVenta()+ " "+ ventaDTO.getImporte()+ " "+ ventaDTO.getCliente().getNombre());			
//		}
//		System.out.println("===================================");
//	}
//	
	

}
