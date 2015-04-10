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

/**
 *
 * @author ColsutecR
 */
public class DepartamentoTestJPA {

    Departamento departamento;

    EntityManagerFactory emf;
    EntityManager em;

    public DepartamentoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        departamento = new Departamento();
        departamento.setIdDepartamento("50");
        departamento.setNombreDepartamento("Guanchope");
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
    public void insertarDepartamento() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(departamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDepartamento() {

        String idDepar = JOptionPane.showInputDialog("insertar El Id Del Departamento");
        String actNombre = JOptionPane.showInputDialog("Digite El Nombre");

        departamento.setIdDepartamento(idDepar);
        departamento.setNombreDepartamento(actNombre);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(departamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnDepartamento() {

        String idDepartamento = JOptionPane.showInputDialog("Inserte El Id A Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Departamento dep = em.find(Departamento.class, idDepartamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(dep.toString());
    }

    @Test
    public void borrarUnDepartemento() {
        String idDepartamento = JOptionPane.showInputDialog("Escriba el id del departamento a eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Departamento.class, idDepartamento));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el departamento" + e.getMessage());
        }

    }
    
    @Test
    public void buscarDepartamentos() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Departamento.findAll");
        List<Departamento> lis = q.getResultList();
        for (Departamento departamentoT : lis) {
            
            System.out.println("Id Del departamento: "+departamentoT.getIdDepartamento()+ " / Nombre del Departamento: "+ departamentoT.getNombreDepartamento());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
