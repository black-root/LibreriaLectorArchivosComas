/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.core.Response;
import modelo.MantenimientoHistorialPreventivo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victo
 */
public class ManHistorialPreventivoServiceTest {
    
    public ManHistorialPreventivoServiceTest() {
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

    /**
     * Test of getMantenimientosPreventivoService method, of class ManHistorialPreventivoService.
     */
    @Test
    public void testGetMantenimientosPreventivoService() {
        System.out.println("getMantenimientosPreventivoService");
        ManHistorialPreventivoService instance = new ManHistorialPreventivoService();
        //Response expResult = null;
        Response result = instance.getMantenimientosPreventivoService();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertNotNull(result);
    }

    /**
     * Test of getMantenimientoPreventivoService method, of class ManHistorialPreventivoService.
     */
    @Test
    public void testGetMantenimientoPreventivoService() {
        System.out.println("getMantenimientoPreventivoService");
        int id = 0;
        ManHistorialPreventivoService instance = new ManHistorialPreventivoService();
        //Response expResult = null;
        Response result = instance.getMantenimientoPreventivoService(id);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertNotNull(result);
    }

    /**
     * Test of borrarMantenimientoPreventivoService method, of class ManHistorialPreventivoService.
     */
    @Test
    public void testBorrarMantenimientoPreventivoService() {
        System.out.println("borrarMantenimientoPreventivoService");
        int id = 0;
        ManHistorialPreventivoService instance = new ManHistorialPreventivoService();
        //Response expResult = null;
        Response result = instance.borrarMantenimientoPreventivoService(id);
        assertNotNull(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of guardarMantenimiento method, of class ManHistorialPreventivoService.
     */
    @Test
    public void testGuardarMantenimiento() {
        System.out.println("guardarMantenimiento");
        MantenimientoHistorialPreventivo mantenimientoHP = null;
        ManHistorialPreventivoService instance = new ManHistorialPreventivoService();
        //Response expResult = null;
        Response result = instance.guardarMantenimiento(mantenimientoHP);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertNotNull(result);
    }
    
}
