package com.comercio.dao.model.dto;

import java.util.Date;

public class FindCliente_IN {

	private Date toDate;
	private Date FromDate;
	
	private ClienteDTO[] clientes;

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return FromDate;
	}

	public void setFromDate(Date fromDAte) {
		FromDate = fromDAte;
	}

	public ClienteDTO[] getClientes() {
		return clientes;
	}

	public void setClientes(ClienteDTO[] clientes) {
		this.clientes = clientes;
	}
	
	public int getClientesLength(){		
		if(clientes==null)
			return 0;
		return clientes.length;
		
	}
	
	
}
