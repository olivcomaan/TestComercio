package com.comercio.services;

import org.springframework.data.domain.Page;

import com.comercio.dao.model.dto.VentaDTO;

public interface VentasService {
	
	
	public Page<VentaDTO> findBillBetween (Double min, Double max);
	public Page<VentaDTO> findBillByNameEmple(String name);
	public Page<VentaDTO> findBillByNameEmpleBetweenImport(String name, Double min, Double max);

}
