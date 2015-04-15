package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.Cuenta;
import edu.co.sena.akuavida.integracion.entitis.DomicilioPK;
import edu.co.sena.akuavida.integracion.entitis.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ { 

    public static volatile SingularAttribute<Domicilio, Municipio> municipioidMunicipio;
    public static volatile SingularAttribute<Domicilio, DomicilioPK> domicilioPK;
    public static volatile SingularAttribute<Domicilio, String> ciudad;
    public static volatile SingularAttribute<Domicilio, String> direccion;
    public static volatile SingularAttribute<Domicilio, Cuenta> cuenta;
    public static volatile SingularAttribute<Domicilio, String> telefono;

}