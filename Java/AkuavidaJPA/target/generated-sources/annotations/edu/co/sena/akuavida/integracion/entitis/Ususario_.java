package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.Cuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(Ususario.class)
public class Ususario_ { 

    public static volatile SingularAttribute<Ususario, String> password;
    public static volatile SingularAttribute<Ususario, String> estado;
    public static volatile ListAttribute<Ususario, Cuenta> cuentaList;
    public static volatile SingularAttribute<Ususario, String> idUsusario;
    public static volatile SingularAttribute<Ususario, String> rol;

}