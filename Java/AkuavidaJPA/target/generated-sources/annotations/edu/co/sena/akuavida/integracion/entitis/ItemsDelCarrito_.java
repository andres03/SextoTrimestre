package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.integracion.entitis.ItemsDelCarritoPK;
import edu.co.sena.akuavida.integracion.entitis.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(ItemsDelCarrito.class)
public class ItemsDelCarrito_ { 

    public static volatile SingularAttribute<ItemsDelCarrito, ItemsDelCarritoPK> itemsDelCarritoPK;
    public static volatile SingularAttribute<ItemsDelCarrito, Float> costoTotal;
    public static volatile SingularAttribute<ItemsDelCarrito, Integer> cantidad;
    public static volatile SingularAttribute<ItemsDelCarrito, Producto> producto;
    public static volatile SingularAttribute<ItemsDelCarrito, CarritoDeCompras> carritoDeCompras;
    public static volatile SingularAttribute<ItemsDelCarrito, Float> costoUnitario;

}