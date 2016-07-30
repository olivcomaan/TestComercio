package com.comercio.mapper.DAO_in_DTO;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.comercio.dao.model.dto.VentaDTO;
import com.comercio.dao.model.Venta;

public final class VentaMapper {
	
	
	/**
	 * 	
	 * @param entity
	 * @return
	 */
	static VentaDTO mapEntityIntoDTO (Venta entity){
		VentaDTO dto = new VentaDTO();
		
		dto.setIdVenta(entity.getIdVenta());
		dto.setImporte(entity.getImporte());		
		dto.setEmpleado(entity.getEmpleado());
		dto.setCliente(entity.getCliente());
		return dto;	
		
	}
	
	
	/**
	 * 
	 * @param entities
	 * @return
	 */
	static List <VentaDTO> mapEntitiesIntoDTOs (List <Venta> entities){
		
		return entities.stream().map(VentaMapper::mapEntityIntoDTO).collect(toList());
		
	}
	
	
	/**
	 * 
	 * @param page
	 * @param source
	 * @return
	 */
	public static Page <VentaDTO> mapEntityIntoDTOPage (Pageable page, Page <Venta> source ){
		
		List <VentaDTO> dtos = mapEntitiesIntoDTOs(source.getContent());
		return new PageImpl<VentaDTO>(dtos, page, source.getTotalElements());
	}
	
	
	
	
}
