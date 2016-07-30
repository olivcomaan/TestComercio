package com.comercio.mapper.DAO_in_DTO;

import java.util.List;

import static java.util.stream.Collectors.toList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.comercio.dao.model.dto.EmpleadoDTO;
import com.comercio.dao.model.Empleado;

public final class EmpleadoMapper {
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	static EmpleadoDTO mapEntityIntoDTO(Empleado entity){
		EmpleadoDTO dto = new EmpleadoDTO();
		
		dto.setDescripcion(entity.getDescripcion());
		dto.setIdEmpleado(entity.getIdEmpleado());
		dto.setNombre(entity.getNombre());
		dto.setSalario(entity.getSalario());
		dto.setVentas(entity.getVentas());		
		return dto;	
		
	}
	
	/**
	 * 
	 * @param entities
	 * @return
	 */
	static List <EmpleadoDTO> mapEntitiesIntoDTOs (List <Empleado> entities){
		
		return entities.stream().map(EmpleadoMapper::mapEntityIntoDTO).collect(toList());
		
	}
	
	
	/**
	 * 
	 * @param page
	 * @param source
	 * @return
	 */
	public static Page <EmpleadoDTO> mapEntityIntoDTOPage (Pageable page, Page <Empleado> source ){
		
		List <EmpleadoDTO> dtos = mapEntitiesIntoDTOs(source.getContent());
		return new PageImpl<EmpleadoDTO>(dtos, page, source.getTotalElements());
	}

}
