package com.comercio.dao.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.comercio.dao.model.Cliente;
import com.comercio.dao.model.Cliente_;

public class ClienteSpecification {
	

	/**
	 * Busca los clientes que se hayan dado de alta entra las fechas informadas, 
	 * @param fromDate clientes dados de alta desde...
	 * @param toDate clientes dados de alta hasta
	 * @return
	 */
	public static Specification<Cliente> byRAngeDate(Date fromDate, Date toDate) {
		
		return new Specification<Cliente>() {

			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate predica= null;
				
//				java.sql.Date from = new java.sql.Date(fromDate.getTime());
				
				if (fromDate!= null && toDate==null){			
					
					predica = cb.greaterThan(root.get(Cliente_.fechaAlta), fromDate);
					
				}else if (fromDate== null && toDate!=null){
					
					predica = cb.lessThan(root.get(Cliente_.fechaAlta), toDate);
					
				}else if(fromDate!= null && toDate!=null){
					
					predica =  cb.and((cb.greaterThan(root.get(Cliente_.fechaAlta), fromDate)),
								cb.lessThan(root.get(Cliente_.fechaAlta), toDate));					
				}
								
				return predica;
			}
			
		};
	}

	/**
	 * Busca todos los clientes que coincidan con el listado de IDs´pasado
	 * @param listaID
	 * @return
	 */
	public static Specification<Cliente> byIds(List<Long> listaID) {
		
		return new Specification<Cliente>() {

			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate predicado = cb.and(root.get(Cliente_.idCliente).in(listaID));
				
				return predicado;
			}
		};
	}

	/**
	 * Especificación para buscar por nombres de clientes, tantos Likes como nombres vengan
	 * informados unidos por la operacion OR
	 * @param listaNombres
	 * @return
	 */
	public static Specification<Cliente> byNombres(List<String> listaNombres) {

		
		return new Specification<Cliente>() {

			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				List<Predicate> predicados = new ArrayList<Predicate>();
				
				if(listaNombres== null || listaNombres.isEmpty()){
					return null;
				}
				for( String nombre : listaNombres){
					
					predicados.add(cb.like(cb.upper(root.get(Cliente_.nombre)), 
							"%"+ nombre.toUpperCase()+ "%"));
				}
				
				return cb.or(predicados.toArray(new Predicate[]{}));
			}
		};
	}
	
	
	/**
	 * Especificación para buscar por direcciones de clientes, tantos Likes como direcciones vengan
	 * informados unidos por la operacion OR
	 * @param listaNombres
	 * @return
	 */
	public static Specification<Cliente> byDirecciones (List<String> listaDirecciones) {

		
		return new Specification<Cliente>() {

			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				List<Predicate> predicados = new ArrayList<Predicate>();
				
				if(listaDirecciones== null || listaDirecciones.isEmpty()){
					return null;
				}
				for( String direccion : listaDirecciones){
					
					predicados.add(cb.like(cb.upper(root.get(Cliente_.direccion)), 
							"%"+ direccion.toUpperCase()+ "%"));
				}
				
				return cb.and(predicados.toArray(new Predicate[]{}));
			}
		};
	}
	
	
	
	

}
