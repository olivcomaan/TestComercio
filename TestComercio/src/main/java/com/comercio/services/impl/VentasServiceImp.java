package com.comercio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercio.dao.model.dto.VentaDTO;
import com.comercio.dao.model.Venta;
import com.comercio.dao.repository.VentasRepository;
import com.comercio.dao.repository.specification.VentasSpecification;
import com.comercio.mapper.DAO_in_DTO.VentaMapper;
import com.comercio.services.VentasService;



@Transactional(rollbackFor = { Exception.class })
@Service
public final class VentasServiceImp implements VentasService {

	@Autowired
	private VentasRepository repositoryVenta;	
	
	
	
	@Override
	public Page<VentaDTO> findBillBetween(Double min, Double max) {
		// TODO Auto-generated method stub
		Pageable pageRequest = new PageRequest (0, 10, Sort.Direction.ASC, "importe");
		Specification<Venta> ventaSpecBetweeImport = VentasSpecification.billBetween(min,max);		
		Page<Venta> resultPage = repositoryVenta.findAll(Specifications.where(ventaSpecBetweeImport), pageRequest);
		
		return VentaMapper.mapEntityIntoDTOPage(pageRequest, resultPage);
	}


	@Override
	public Page<VentaDTO> findBillByNameEmple(String name) {
		Pageable pageRequest = new PageRequest (0, 10, Sort.Direction.ASC, "importe");
		Specification<Venta> ventaSpecByNameEmple = VentasSpecification.billForEmple(name);
		Page <Venta> resultPage = repositoryVenta.findAll(ventaSpecByNameEmple, pageRequest);		
		return VentaMapper.mapEntityIntoDTOPage(pageRequest, resultPage);
	}


	
	@Override
	public Page<VentaDTO> findBillByNameEmpleBetweenImport(String name, Double min, Double max) {
		// TODO Auto-generated method stub
		Pageable pageRequest = new PageRequest (0, 10, Sort.Direction.ASC, "importe");
		Specification<Venta> ventaSpecBetweenImpot = VentasSpecification.billBetween(min,max);	
		Specification<Venta> ventaSpecByNameEmple = VentasSpecification.billForEmple(name);
		Page <Venta> resultPage = repositoryVenta.findAll(Specifications.where(ventaSpecByNameEmple).and(ventaSpecBetweenImpot),pageRequest);
		
		return VentaMapper.mapEntityIntoDTOPage(pageRequest, resultPage);
	}
	
	
	
	

}
