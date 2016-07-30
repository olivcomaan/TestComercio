package com.comercio.services;

import com.comercio.dao.model.dto.FindCliente_IN;
import com.comercio.dao.model.dto.FindCliente_OUT;
import com.comercio.dao.model.dto.ManageCliente_IN;
import com.comercio.dao.model.dto.ManageCliente_OUT;

public interface ClienteService {
	
	
	public ManageCliente_OUT manageCliente (ManageCliente_IN manageCliente_in) throws Exception;
	FindCliente_OUT findCliente(FindCliente_IN findCliente_IN) throws Exception;
	
	
	

}
