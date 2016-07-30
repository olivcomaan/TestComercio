package com.comercio.dao.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-07-10T02:02:24.190+0200")
@StaticMetamodel(Venta.class)
public class Venta_ {
	public static volatile SingularAttribute<Venta, Long> idVenta;
	public static volatile SingularAttribute<Venta, Double> importe;
	public static volatile SingularAttribute<Venta, Date> fechaVenta;
	public static volatile SingularAttribute<Venta, Cliente> cliente;
	public static volatile SingularAttribute<Venta, Empleado> empleado;
}
