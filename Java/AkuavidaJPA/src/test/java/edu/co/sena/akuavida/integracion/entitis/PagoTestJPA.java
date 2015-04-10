/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
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
public class PagoTestJPA {

    Pago pago;

    EntityManagerFactory emf;
    EntityManager em;

    public PagoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pago = new Pago();
        pago.setFacturaIDFactura(2);
        pago.setNumeroTarjeta("1234-5678-9876-5432");
        pago.setTipoPago("Tarjeta Debito");
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
    public void insertarPago() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pago);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPago() {

        String FacIdFac = JOptionPane.showInputDialog("Escriba el id de la factura");
        String numTar = JOptionPane.showInputDialog("Escriba el numero de la tarjeta");

        pago.setFacturaIDFactura(Integer.parseInt(FacIdFac));
        pago.setNumeroTarjeta(numTar);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(pago);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPago() {

        String idFac = JOptionPane.showInputDialog("Inserte El id de la Factura");
        
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Pago pago = em.find(Pago.class, Integer.parseInt(idFac));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(pago.toString());
    }
    
    
        @Test
    public void borrarUnPago() {
        String idFactura = JOptionPane.showInputDialog("Escriba el id de la factura");
        
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Pago.class, Integer.parseInt(idFactura)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se puedo eliminar el pago" + e.getMessage());
        }

    }
    
     @Test
    public void buscarTodosLosPAgos() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pago.findAll");
        List<Pago> lis = q.getResultList();
        for (Pago pagoT : lis) {

            System.out.println(pagoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
