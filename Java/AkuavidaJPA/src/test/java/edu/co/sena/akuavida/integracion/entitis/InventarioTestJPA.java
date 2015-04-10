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
public class InventarioTestJPA {

    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();

    Inventario inventario;

    EntityManagerFactory emf;
    EntityManager em;

    public InventarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        inventario = new Inventario();
        inventario.setInventarioPK(new InventarioPK(1, "1"));
        inventario.setCantidad(6);
        inventario.setCantidadProductoComprado(3);
        inventario.setFechaDeCompra(fechaActual);
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
    public void insertarInventario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(inventario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarInventario() {

        String idInv = JOptionPane.showInputDialog("Escriba el id del inventario");
        String idPro = JOptionPane.showInputDialog("Escriba el id del producto");
        String actCan = JOptionPane.showInputDialog("Escriba el Nombre");

        inventario.setInventarioPK(new InventarioPK(Integer.parseInt(idInv), idPro));
        inventario.setCantidad(Integer.parseInt(actCan));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(inventario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarInventario() {

        String idInv = JOptionPane.showInputDialog("Inserte El id del inventario");
        String idPro = JOptionPane.showInputDialog("Inserte El id del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Inventario inv = em.find(Inventario.class, new InventarioPK(Integer.parseInt(idInv), idPro));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(inv.toString());
    }

    @Test
    public void borrarUnaInventario() {
        String idInv = JOptionPane.showInputDialog("Inserte El id del inventario");
        String idPro = JOptionPane.showInputDialog("Inserte El id del producto");
        
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Inventario.class, new InventarioPK(Integer.parseInt(idInv), idPro)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el inventario" + e.getMessage());
        }
    }
    
    
    


 @Test
    public void buscarInventarios() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findAll");
        List<Inventario> lis = q.getResultList();
        for (Inventario inventatioT : lis) {

            System.out.println(inventatioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
