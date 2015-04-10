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
public class UsuarioTestJPA {

    Ususario usuario;

    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Ususario();
        usuario.setIdUsusario("1");
        usuario.setPassword("123456789");
        usuario.setRol("Cliente");
        usuario.setEstado("Activo");

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
    public void insertarUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarUsuario() {

        String idUsu = JOptionPane.showInputDialog("Escriba el id del Usuario");
        String actRol = JOptionPane.showInputDialog("Escriba El Rol");

        usuario.setIdUsusario(idUsu);
        usuario.setRol(actRol);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnUsuario() {

        String idUsuario = JOptionPane.showInputDialog("Inserte El Id A Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Ususario usu = em.find(Ususario.class, idUsuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(usu.toString());
    }

    @Test
    public void borrarUnUsuario() {
        String idUsuario = JOptionPane.showInputDialog("Escriba el id del usuario a eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Ususario.class, idUsuario));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el usuario" + e.getMessage());
        }

    }

    @Test
    public void buscarUsuarios() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Ususario.findAll");
        List<Ususario> lis = q.getResultList();
        for (Ususario usuarioT : lis) {
            System.out.println("ID Usuario " + usuarioT.getIdUsusario() + " / Password: " + usuarioT.getPassword() + " / Rol: " + usuarioT.getRol() + " / Estado: " + usuarioT.getEstado());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    


}
