package com.comercio.dao.model.dto;


import java.io.Serializable;

import java.util.List;



import com.comercio.dao.model.Venta;

/**
 * The persistent class for the CLIENTE database table.
 * 
 */

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idCliente;

	private String direccion;

	private String nombre;	
		
	//bi-directional many-to-one association to Venta
	
	private List<Venta> ventas;
	
	
	/*Constructor**/
	public ClienteDTO() {
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	

}