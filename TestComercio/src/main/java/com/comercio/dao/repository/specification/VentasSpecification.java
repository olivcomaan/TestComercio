package com.comercio.dao.repository.specification;



import org.springframework.data.jpa.domain.Specification;

import com.comercio.dao.model.Empleado_;
import com.comercio.dao.model.Venta;
import com.comercio.dao.model.Venta_;

public class VentasSpecification {
	
	private VentasSpecification(){}
	
	
/**
 * Crea un predicado donde los importes de la tabla venta deben de estar entre el min y el max
 * @param min
 * @param max
 * @return
 */
	public static Specification<Venta> billBetween(Double min, Double max) {		
		
		return (root, query, cb) -> {	
			
			return cb.between(root.<Double>get(Venta_.importe), min, max);
		};
	}
	
	
	/**
	 * Devuelve una specificacion donde las ventas deben coincidir con el empleado que las realizó
	 * @param nombre
	 * @return
	 */
	public static Specification <Venta> billForEmple (String nombre){
		
		return (root, query, cb)->{
			return cb.like(root.join(Venta_.empleado).get(Empleado_.nombre), nombre);
		};
		
		
	}
	

}
