/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.jpa.util.EntityManagerHelper;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class FacturaTestJPA {

    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();
    Factura factura;
    EntityManagerFactory emf;
    EntityManager em;

    public FacturaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        factura = new Factura();
        factura.setIDFactura(1);
        factura.setFecha(fechaActual);
        factura.setCuenta(new Cuenta("C.C", "1033790199"));

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertarFactura() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(factura);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarFactura() {

        String idTD = JOptionPane.showInputDialog("Escriba el tipo de documento");
        String idND = JOptionPane.showInputDialog("Escriba el numero de documento");

        factura.setCuenta(new Cuenta(idTD, idND));
        factura.setFecha(fechaActual);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(factura);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnaFactura() {

        String idFac = JOptionPane.showInputDialog("Inserte El id de la factura");
        //String idTd = JOptionPane.showInputDialog("Inserte El Tipo Documento");
        //String idNd = JOptionPane.showInputDialog("Inserte El NumeroDocumento");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        //Factura fac = em.find(Factura.class, new CuentaPK(idTd, idNd ) );
        Factura fac = em.find(Factura.class, Integer.parseInt(idFac));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(fac.toString());
    }

    @Test
    public void borrarUnaFactura() {
        String idCarrito = JOptionPane.showInputDialog("Escriba el id de la factura");
        
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Factura.class, Integer.parseInt(idCarrito)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se puedo eliminar la factura" + e.getMessage());
        }

    }
    
     @Test
    public void buscarFacturas() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Factura.findAll");
        List<Factura> lis = q.getResultList();
        for (Factura facturaT : lis) {

            System.out.println(facturaT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
