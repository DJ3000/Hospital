/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;
import modelo.Animal;
import modelo.Dono;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CC09059259980
 */
public class DAOTest {
    
    public DAOTest() {
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

//    @Test
//    public void testinserir() {
//        Administrador adm = new Administrador("talco", "Elias Talco", "1234");
//        DAO<Administrador> dao = new DAO (Administrador.class);
//        dao.inserir(adm);
//    }
    
//    @Test
//    public void testListar(){
//        List<Administrador> lista = new DAO(Administrador.class).listarTodos();
//        for(Administrador adm : lista){
//            System.out.println(adm);
//        }
//    }
    
//    @Test
//    public void testListar(){
//        List<Dono> lista = new DAO(Dono.class).listarTodos();
//        for(Dono dn : lista){
//            System.out.println(dn);
//        }
//    }
    
//    @Test
//    public void testinserir() {
//        Dono dn = new Dono("tese");
//        DAO<Dono> dao = new DAO (Dono.class);
//        dao.inserir(dn);
//    }
    
    @Test
    public void testListar(){
        List<Animal> lista = new DAO(Animal.class).listarTodos();
        for(Animal an: lista){
            System.out.println(an);
        }
    }
    
//    @Test
//    public void testinserir() {
//        Animal an = new Animal();
//        an.setDono();
//        DAO<Animal> dao = new DAO (Animal.class);
//        dao.inserir(an);
//    }
}
