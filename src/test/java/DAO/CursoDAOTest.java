/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import Entities.Curso;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author braya
 */
public class CursoDAOTest {
    
    public CursoDAOTest() {
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregar method, of class CursoDAO.
     */
    @org.junit.jupiter.api.Test
    public void testAgregar() {
        System.out.println("agregar");
        Curso entidad = null;
        CursoDAO instance = new CursoDAO();
        instance.agregar(entidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class CursoDAO.
     */
    @org.junit.jupiter.api.Test
    public void testEliminar() {
        System.out.println("eliminar");
        Long id = null;
        CursoDAO instance = new CursoDAO();
        instance.eliminar(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class CursoDAO.
     */
    @org.junit.jupiter.api.Test
    public void testActualizar() {
        System.out.println("actualizar");
        Curso entidad = null;
        CursoDAO instance = new CursoDAO();
        instance.actualizar(entidad);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorId method, of class CursoDAO.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        long id = 0L;
        CursoDAO instance = new CursoDAO();
        Curso expResult = null;
     //   Curso result = instance.buscarPorId(id);
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTodas method, of class CursoDAO.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarTodas() {
        System.out.println("buscarTodas");
        CursoDAO instance = new CursoDAO();
        ArrayList<Curso> expResult = null;
        ArrayList<Curso> result = instance.buscarTodas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
