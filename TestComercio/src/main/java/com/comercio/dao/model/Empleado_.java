package com.comercio.dao.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-07-10T02:02:24.190+0200")
@StaticMetamodel(Empleado.class)
public class Empleado_ {
	public static volatile SingularAttribute<Empleado, Long> idEmpleado;
	public static volatile SingularAttribute<Empleado, String> descripcion;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, String> salario;
	public static volatile SingularAttribute<Empleado, Date> fechaAlta;
	public static volatile ListAttribute<Empleado, Venta> ventas;
}
