package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.Categorias;
import edu.co.sena.akuavida.integracion.entitis.Inventario;
import edu.co.sena.akuavida.integracion.entitis.Item;
import edu.co.sena.akuavida.integracion.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.integracion.entitis.Promociones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, String> iDproducto;
    public static volatile SingularAttribute<Producto, byte[]> imagen;
    public static volatile SingularAttribute<Producto, Categorias> categoriasIDCategoria;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile ListAttribute<Producto, ItemsDelCarrito> itemsDelCarritoList;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, Float> impuesto;
    public static volatile ListAttribute<Producto, Inventario> inventarioList;
    public static volatile ListAttribute<Producto, Promociones> promocionesList;
    public static volatile ListAttribute<Producto, Item> itemList;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Boolean> activo;

}