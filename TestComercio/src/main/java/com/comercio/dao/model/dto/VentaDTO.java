package com.comercio.dao.model.dto;


import java.io.Serializable;

import com.comercio.dao.model.Cliente;
import com.comercio.dao.model.Empleado;



/**
 * The persistent class for the VENTAS database table.
 * 
 */

public class VentaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idVenta;
	private double importe;
	//bi-directional many-to-one association to Cliente	
	private Cliente cliente;
	//bi-directional many-to-one association to Empleado	
	private Empleado empleado;

	/*Constructor*/
	public VentaDTO() {
	}

	
	/**************Getters and setters*****************/
	public Long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}