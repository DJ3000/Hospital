package dao;

import java.util.List;
import modelo.Animal;
import modelo.Clientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


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
//    public void testInserir() {
//       Administrador adm = 
//               new Administrador("talco", "Elias Talco", "1234");
//        DAO<Administrador> dao = new DAO(Administrador.class);
//        dao.inserir(adm);    
//    }
       
   /* @Test
    public void testListar(){
        List<Administrador> lista = 
                new DAO(Administrador.class).listarTodos();
        for(Administrador adm : lista){
            System.out.println(adm);
        }
    }*/
   /* @Test
    public void testInserir(){
        Clientes cliente = new Clientes( "Kaio Fleipe");
        DAO<Clientes> dao = new DAO(Clientes.class);
        dao.inserir(cliente);
    }*/
    
      /* @Test
    public void testInserir() {
       Animal animal = new Animal("aa", "Elias Talco", "kaio", 1.2);
        DAO<Animal> dao = new DAO(Animal.class);
        dao.inserir(animal);    
    }
*/
}
