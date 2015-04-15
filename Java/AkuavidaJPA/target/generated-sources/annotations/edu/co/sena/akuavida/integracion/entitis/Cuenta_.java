package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.CuentaPK;
import edu.co.sena.akuavida.integracion.entitis.Domicilio;
import edu.co.sena.akuavida.integracion.entitis.Factura;
import edu.co.sena.akuavida.integracion.entitis.Ususario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> segundoNombre;
    public static volatile SingularAttribute<Cuenta, String> primerNombre;
    public static volatile SingularAttribute<Cuenta, String> primerApellido;
    public static volatile SingularAttribute<Cuenta, CuentaPK> cuentaPK;
    public static volatile SingularAttribute<Cuenta, String> direccion;
    public static volatile SingularAttribute<Cuenta, String> segundoApellido;
    public static volatile SingularAttribute<Cuenta, String> rool;
    public static volatile SingularAttribute<Cuenta, Ususario> ususarioidUsusario;
    public static volatile SingularAttribute<Cuenta, Domicilio> domicilio;
    public static volatile SingularAttribute<Cuenta, String> correo;
    public static volatile ListAttribute<Cuenta, Factura> facturaList;
    public static volatile SingularAttribute<Cuenta, String> telefono;
    public static volatile SingularAttribute<Cuenta, Boolean> activo;

}