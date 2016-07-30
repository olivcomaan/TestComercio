package com.comercio.dao.model.dto;

public class FindCliente_OUT {
	
	private ClienteDTO[] clientes;

	public ClienteDTO[] getClientes() {
		return clientes;
	}

	public void setClientes(ClienteDTO[] clientes) {
		this.clientes = clientes;
	}
	
	
	public ClienteDTO getCliente(int idx){
		if(this.clientes==null){
			throw new IndexOutOfBoundsException();
		}
		return clientes[idx];
		
	}
	
	public int getClientesLength(){
		if(this.clientes==null){
			return 0;
		}		
		return clientes.length;
		
	}

}
