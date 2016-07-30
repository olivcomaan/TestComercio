package com.comercio.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.comercio.dao.model.Empleado;

@Repository (value = "com.comercio.dao.repository.EmpleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>, JpaSpecificationExecutor<Empleado>{

}
