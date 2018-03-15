/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.core.Response;
import modelo.MantenimientoControlGeneral;
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
public class ManControlGeneralServiceTest {
    
    public ManControlGeneralServiceTest() {
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
     * Test of getMantenimientos method, of class ManControlGeneralService.
     */
    @Test
    public void testGetMantenimientos() {
        System.out.println("getMantenimientos");
        ManControlGeneralService instance = new ManControlGeneralService();
        //Response expResult = null;
        Response result = instance.getMantenimientos();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Se comprueba que no son nulos
        assertNotNull(result);
    }

    /**
     * Test of getMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testGetMantenimiento() {
        System.out.println("getMantenimiento");
        int id = 0;
        ManControlGeneralService instance = new ManControlGeneralService();
        //Response expResult = null;
        Response result = instance.getMantenimiento(id);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Se comprueba que no son nulos
        assertNotNull(result);
        
    }

    /**
     * Test of borrarMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testBorrarMantenimiento() {
        System.out.println("borrarMantenimiento");
        int id = 0;
        ManControlGeneralService instance = new ManControlGeneralService();
        //Response expResult = null;
        Response result = instance.borrarMantenimiento(id);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Se comprueba que no son nulos
        assertNotNull(result);
    }

    /**
     * Test of guardarMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testGuardarMantenimiento() {
        System.out.println("guardarMantenimiento");
        MantenimientoControlGeneral mantenimientoGS = null;
        ManControlGeneralService instance = new ManControlGeneralService();
        //Response expResult = null;
        Response result = instance.guardarMantenimiento(mantenimientoGS);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Se comprueba que no son nulos
        assertNotNull(result);
    }
    
}
