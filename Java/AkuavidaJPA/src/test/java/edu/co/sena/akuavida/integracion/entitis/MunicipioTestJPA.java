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
public class MunicipioTestJPA {

    Municipio municipio;

    EntityManagerFactory emf;
    EntityManager em;

    public MunicipioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        municipio = new Municipio();
        municipio.setIdMunicipio("2000");
        municipio.setNombreMunicipio("El Bronx");
        municipio.setDepartamentoidDepartamento(new Departamento("50"));

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
    public void insertarMunicipio() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(municipio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void actualizarMunicipio() {

        String idMun = JOptionPane.showInputDialog("Escriba el id del municipio");
        String actNom = JOptionPane.showInputDialog("Escriba El Nombre");

        municipio.setIdMunicipio(idMun);
        municipio.setNombreMunicipio(actNom);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(municipio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnMunicipio() {

        String idMunicipio = JOptionPane.showInputDialog("Inserte El Id A Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Municipio mun = em.find(Municipio.class, idMunicipio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(mun.toString());
    }
    @Test
    public void borrarUnMunicipio() {
        String idMunicipio = JOptionPane.showInputDialog("Escriba el id del municipio a eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.remove(em.find(Categorias.class, idMunicipio));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el municipio" + e.getMessage());
        }
    }

     @Test
    public void buscarMunicipios() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Municipio.findAll");
        List<Municipio> lis = q.getResultList();
        for (Municipio municipioT : lis) {

            System.out.println(municipioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
