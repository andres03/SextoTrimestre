package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.ItemsDelCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(CarritoDeCompras.class)
public class CarritoDeCompras_ { 

    public static volatile ListAttribute<CarritoDeCompras, ItemsDelCarrito> itemsDelCarritoList;
    public static volatile SingularAttribute<CarritoDeCompras, Float> total;
    public static volatile SingularAttribute<CarritoDeCompras, Float> subtotal;
    public static volatile SingularAttribute<CarritoDeCompras, String> iDCarrito;

}