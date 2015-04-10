/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import edu.co.sena.akuavida.integracion.entitis.Categorias;
import edu.co.sena.akuavida.integracion.entitis.Departamento;
import edu.co.sena.akuavida.integracion.entitis.Municipio;
import edu.co.sena.akuavida.integracion.entitis.Producto;
import edu.co.sena.akuavida.integracion.jpa.util.EntityManagerHelper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class CategoriaEjercicio {

    Categorias categoria;
    Categorias categoria2;
    Producto producto4;

    List<Producto> productos;

    EntityManagerFactory emf;
    EntityManager em;

    public CategoriaEjercicio() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        categoria = new Categorias();
        categoria.setIDCategoria(1);
        categoria.setNombre("Nueva");
        categoria.setActiva(true);
        categoria.setPariente(1);
        
        categoria2 = new Categorias();        
        categoria2.setIDCategoria(2);
        categoria2.setNombre("Nueva 2");
        categoria2.setActiva(true);
        categoria2.setPariente(1);

        productos = new ArrayList<>();
        Producto producto1 = new Producto();
        producto1.setIDproducto("1");
        producto1.setNombre("Super jokin");
        producto1.setPrecio(190000);
        producto1.setDescripcion("Este es uno de los mejores");
        producto1.setCantidad(5);
        producto1.setActivo(true);
        producto1.setImpuesto(16);
        producto1.setCategoriasIDCategoria(new Categorias(1));

        Producto producto2 = new Producto();

        producto2.setIDproducto("2");
        producto2.setNombre("Super jokin Master");
        producto2.setPrecio(180000);
        producto2.setDescripcion("Este es mucho mejor");
        producto2.setCantidad(15);
        producto2.setActivo(true);
        producto2.setImpuesto(16);
        producto2.setCategoriasIDCategoria(new Categorias(1));

        Producto producto3 = new Producto();

        producto3.setIDproducto("3");
        producto3.setNombre("Super jokin SuperMaster");
        producto3.setPrecio(170000);
        producto3.setDescripcion("Este es mucho mejor que va");
        producto3.setCantidad(65);
        producto3.setActivo(true);
        producto3.setImpuesto(16);
        producto3.setCategoriasIDCategoria(new Categorias(1));
        
        producto4 = new Producto();

        producto4.setIDproducto("4");
        producto4.setNombre("Super jokin SuperMaster");
        producto4.setPrecio(170000);
        producto4.setDescripcion("Este es mucho mejor que va");
        producto4.setCantidad(65);
        producto4.setActivo(true);
        producto4.setImpuesto(16);
        producto4.setCategoriasIDCategoria(new Categorias(2));

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
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
    public void insertarCategoriasProductos() {
        categoria.setProductoList(productos);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    @Test
    public void insertarProductosCategorias(){
        producto4.setCategoriasIDCategoria(categoria2);
    
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto4);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    
    }
    
    @Test
    public void buscarDepartamentoConMunicipios(){
    
     String idDepartamento = JOptionPane.showInputDialog("Inserte El Id A Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Departamento dep = em.find(Departamento.class, idDepartamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        List<Municipio> listaMun = dep.getMunicipioList();
        for (Municipio listaMun1 : listaMun) {
            System.out.println(listaMun1.toString());
        }
    
    
    }
}
