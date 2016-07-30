package com.comercio.dao.model.dto;


import java.io.Serializable;
import java.util.List;

import com.comercio.dao.model.Venta;




/**
 * The persistent class for the EMPLEADO database table.
 * 
 */

public class EmpleadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idEmpleado;

	private String descripcion;

	private String nombre;

	private String salario;
	
	private List<Venta> ventas;

	
	public EmpleadoDTO() {
	}

	public Long getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	

}