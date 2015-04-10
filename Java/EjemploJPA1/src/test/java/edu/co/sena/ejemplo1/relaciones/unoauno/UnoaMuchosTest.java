/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.relaciones.unoauno;

import edu.co.sena.ejemplo1.relaciones.unoamuchos.Estudiante3;
import edu.co.sena.ejemplo1.relaciones.unoamuchos.Materia3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public class UnoaMuchosTest {

    List<Estudiante3> lisEstudiantes;
    Materia3 materia;

    public UnoaMuchosTest() {
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
        Estudiante3 estudiante1 = new Estudiante3();
        estudiante1.setIdEstudiante("20");
        estudiante1.setCorreo("Estees@gmail.com");
        estudiante1.setDireccion("Aqui vivo 11-23");
        estudiante1.setNombre("Pepito");
        estudiante1.setTelefono("5646867");

        Estudiante3 estudiante2 = new Estudiante3();
        estudiante2.setIdEstudiante("30");
        estudiante2.setCorreo("Estees@gmail.com");
        estudiante2.setDireccion("Aqui vivo 11-23");
        estudiante2.setNombre("Pepito");
        estudiante2.setTelefono("5646867");

        materia = new Materia3();
        materia.setIdMateria("1");
        materia.setNombre("Calculo");
        materia.setDescripcion("Partes del mundo");

        lisEstudiantes = new ArrayList<>();
        lisEstudiantes.add(estudiante1);
        lisEstudiantes.add(estudiante2);

        materia.setListaEstudiantes(lisEstudiantes);

        estudiante1.setMateria(materia);
        estudiante2.setMateria(materia);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena_EjemploJPA1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(materia);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    @Test
    public void consultar() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena_EjemploJPA1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Collection<Estudiante3> et = em.find(Materia3.class, "1").getListaEstudiantes();

        em.getTransaction().commit();
        em.close();
        emf.close();

        for (Estudiante3 et1 : et) {

            System.out.println(et1.toString());
        }

    }
}
