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
public class PedidoTestJPA {

    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();

    Pedido pedido;
    EntityManagerFactory emf;
    EntityManager em;

    public PedidoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        pedido = new Pedido();
        pedido.setFacturaIDFactura(2);
        pedido.setFecha(fechaActual);
        pedido.setSubtotal(420000);
        pedido.setTotal(500000);
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
    public void insertarPedido() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pedido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPedido() {

        String FacIdFac = JOptionPane.showInputDialog("Escriba el id de la factura");
        String actTotal = JOptionPane.showInputDialog("Escriba el Total");

        pedido.setFacturaIDFactura(Integer.parseInt(FacIdFac));
        pedido.setTotal(Float.valueOf(actTotal));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(pedido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnPedido() {

        String idFac = JOptionPane.showInputDialog("Inserte El id de la Factura");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Pedido ped = em.find(Pedido.class, Integer.parseInt(idFac));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(ped.toString());
    }

    @Test
    public void borrarUnPedido() {
        String idFactura = JOptionPane.showInputDialog("Escriba el id de la factura");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Pedido.class, Integer.parseInt(idFactura)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se puedo eliminar el pedido" + e.getMessage());
        }

    }
    
    

 @Test
    public void buscarPedidos() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pedido.findAll");
        List<Pedido> lis = q.getResultList();
        for (Pedido pedidoT : lis) {

            System.out.println(pedidoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
