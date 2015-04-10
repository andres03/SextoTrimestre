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
public class ItemTestJPA {

    Item item;

    EntityManagerFactory emf;
    EntityManager em;

    public ItemTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        item = new Item();
        item.setItemPK(new ItemPK("1", 2));
        item.setCantidad(3);
        item.setCostoTotal(750000);
        item.setCostoUnitario(250000);
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
    public void insertarItem() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(item);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarItems() {

        String idPro = JOptionPane.showInputDialog("Escriba el id de la producto");
        String idPeFacIdFac = JOptionPane.showInputDialog("Escriba el id de la factura");
        String actCan = JOptionPane.showInputDialog("Escriba La Cantidad");
        String actCosTo = JOptionPane.showInputDialog("Escriba El Costo Total");
        String actCosUni = JOptionPane.showInputDialog("Escriba El Costo Unitario");

        item.setItemPK(new ItemPK(idPro, Integer.parseInt(idPeFacIdFac)));
        item.setCantidad(Integer.parseInt(actCan));
        item.setCostoTotal(Float.valueOf(actCosTo));
        item.setCostoUnitario(Float.valueOf(actCosUni));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(item);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarItem() {

        String idPro = JOptionPane.showInputDialog("Inserte El id del producto");
        String idPed = JOptionPane.showInputDialog("Inserte El id del pedido");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Item item = em.find(Item.class, new ItemPK(idPro, Integer.parseInt(idPed)));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(item.toString());
    }

    @Test
    public void borrarUnItem() {
        String idPro = JOptionPane.showInputDialog("Inserte El id del producto");
        String idPed = JOptionPane.showInputDialog("Inserte El id del pedido");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Item.class, new ItemPK(idPro, Integer.parseInt(idPed))));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el departamento" + e.getMessage());
        }

    }
    
    @Test
    public void buscarTodosLosItems() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findAll");
        List<Item> lis = q.getResultList();
        for (Item itemT : lis) {

            System.out.println(itemT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
