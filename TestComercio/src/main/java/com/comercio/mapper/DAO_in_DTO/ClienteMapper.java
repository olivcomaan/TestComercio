package com.comercio.mapper.DAO_in_DTO;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.comercio.dao.model.dto.ClienteDTO;
import com.comercio.dao.model.Cliente;


public final class ClienteMapper {
	
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	static ClienteDTO mapEntityIntoDTO (Cliente entity){
		
		ClienteDTO dto = new ClienteDTO();
		dto.setDireccion(entity.getDireccion());
		dto.setIdCliente(entity.getIdCliente());
		dto.setNombre(entity.getNombre());
		dto.setVentas(entity.getVentas());
		
		
		return dto;
	}
	
	
	/**
	 * 
	 * @param entities
	 * @return
	 */
	static List <ClienteDTO> mapEntitiesIntoDTOs (List <Cliente> entities){
		
		return entities.stream().map(ClienteMapper::mapEntityIntoDTO).collect(toList());
		
	}
	
	
	/**
	 * Mapea los resultados proveniente de las entidades de la bbdd a una Page con los resultados en DTO
	 * @param page pagina que contiene el formato de la pagina devuelta
	 * @param source pagina que contiene los resutlados proveniente de la bbdd
	 * @return
	 */
	public static Page <ClienteDTO> mapEntityIntoDTOPage (Pageable page, Page <Cliente> source ){
		
		List <ClienteDTO> dtos = mapEntitiesIntoDTOs(source.getContent());
		return new PageImpl<ClienteDTO>(dtos, page, source.getTotalElements());
	}
	
	
	
	

}
