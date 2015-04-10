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
public class PromocionesTestJPA {

    Promociones promociones;

    EntityManager em;
    EntityManagerFactory emf;

    public PromocionesTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        promociones = new Promociones();
        promociones.setIdPromocion("1");
        promociones.setDescuentos(25000);
        promociones.setNombre("20% De Descuento En cada producto Comprado ");
        promociones.setPrecio(675000);
        promociones.setProductoIDproducto(new Producto("1"));

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
    public void insertarPromociones() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(promociones);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPromociones() {

        String idPro = JOptionPane.showInputDialog("Escriba el id de la promocion");
        String actDes = JOptionPane.showInputDialog("Escriba el Descuento");
        String actNom = JOptionPane.showInputDialog("Escriba el Nombre");

        promociones.setIdPromocion(idPro);
        promociones.setDescuentos(Float.valueOf(actDes));
        promociones.setNombre(actNom);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(promociones);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPromociones() {

        String idPromo = JOptionPane.showInputDialog("Inserte El id de la Promocion");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Promociones pro = em.find(Promociones.class, idPromo);

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(pro.toString());
    }

    @Test
    public void borrarUnaPromocion() {
        String idPromocion = JOptionPane.showInputDialog("Escriba el id de la promocion");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Promociones.class, idPromocion));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la promocion" + e.getMessage());
        }

    }
    
    
     @Test
    public void buscarPromocionesTodas() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Promociones.findAll");
        List<Promociones> lis = q.getResultList();
        for (Promociones promocionT : lis) {

            System.out.println(promocionT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
