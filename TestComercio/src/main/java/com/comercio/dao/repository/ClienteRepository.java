package com.comercio.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.comercio.dao.model.Cliente;


@Repository (value = "com.comercio.dao.repository.ClienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>{


	

	
}
