package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.entitis.Departamento;
import edu.co.sena.akuavida.integracion.entitis.Domicilio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T09:36:28")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile ListAttribute<Municipio, Domicilio> domicilioList;
    public static volatile SingularAttribute<Municipio, String> nombreMunicipio;
    public static volatile SingularAttribute<Municipio, String> idMunicipio;
    public static volatile SingularAttribute<Municipio, Departamento> departamentoidDepartamento;

}