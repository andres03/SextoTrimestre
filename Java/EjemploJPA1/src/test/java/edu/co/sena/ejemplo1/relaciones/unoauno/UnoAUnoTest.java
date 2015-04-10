/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.relaciones.unoauno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class UnoAUnoTest {
    
    Estudiante2 estudiante;
    Materia2 materia;
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public UnoAUnoTest() {
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
    public void insertarMateriaPorEstudiante() {        
        
        estudiante = new Estudiante2();
        estudiante.setIdEstudiante("20");
        estudiante.setCorreo("Estees@gmail.com");
        estudiante.setDireccion("Aqui vivo 11-23");
        estudiante.setNombre("Pepito");
        estudiante.setTelefono("5646867");
        
        materia = new Materia2();
        materia.setIdMateria("1");
        materia.setNombre("Calculo");
        materia.setDescripcion("Partes del mundo");
        estudiante.setMateria(materia);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena_EjemploJPA1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estudiante);
        
       
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }
    
    @Test
    public void consulta(){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena_EjemploJPA1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudiante2 estudianteT = em.find(Materia2.class, "1").getEstudiante();
        Materia2 materiaT = em.find(Estudiante2.class, "20").getMateria();
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println(estudianteT.toString());
        System.out.println(materiaT.toString());
        
    
    
    }
}
