/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.anotaciones;

import edu.co.sena.anotaciones.Estudiante;
import edu.co.sena.anotaciones.Materia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class EstudianteAPP {

    public EstudianteAPP() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void insertarEstudiante() {
        Estudiante e1 = new Estudiante();
        e1.setIdEstudiante("123");
        e1.setNombre("COSO");
        e1.setCorreo("el de siempre");
        e1.setTelefono("123456");
        e1.setDireccion("el chavo del ocho");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena_EjemploJPA1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e1);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    
}
