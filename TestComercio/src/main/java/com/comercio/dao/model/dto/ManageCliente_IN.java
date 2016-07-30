package com.comercio.dao.model.dto;

public class ManageCliente_IN {

	
	private ClienteDTO cliente;
	
	private int operationType;

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public int getOperationType() {
		return operationType;
	}

	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}
	
}
