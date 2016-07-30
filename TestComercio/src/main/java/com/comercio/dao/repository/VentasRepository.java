package com.comercio.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.comercio.dao.model.Venta;


@Repository (value = "com.comercio.dao.repository.VentasRepository")
public interface VentasRepository extends JpaRepository<Venta, Long>,JpaSpecificationExecutor<Venta>{

}
