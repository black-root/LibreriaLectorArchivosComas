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
import org.mockito.Mockito;
//librerias para hacer pruebas al REST (usando REST-assured)
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;



/**
 *
 * @author victor
 */
public class ManControlGeneralServiceTest {
    // creo los objetos para simular las dependencias de archivo, como la lista
//    private controlador.Archivo ObjArchivoValido;
//    private controlador.Archivo ObjArchivoFalso;
//    //y un objeto propio de la clase a testear
//    private service.ManControlGeneralService MCGS;
    
    
    public ManControlGeneralServiceTest() {
    }
    
    @BeforeClass
    public static void init() {
        //Se usan para testear el JSON que devuelve el REST
        RestAssured.baseURI="http//localhost";
        RestAssured.port=8080;
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
        Response expResult = instance.getMantenimientos();
        Response result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testGetMantenimiento() {
        System.out.println("getMantenimiento");
        int id = 0;
        ManControlGeneralService instance = new ManControlGeneralService();
        Response expResult = null;
        Response result = instance.getMantenimiento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testBorrarMantenimiento() {
        System.out.println("borrarMantenimiento");
        int id = 0;
        ManControlGeneralService instance = new ManControlGeneralService();
        Response expResult = null;
        Response result = instance.borrarMantenimiento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarMantenimiento method, of class ManControlGeneralService.
     */
    @Test
    public void testGuardarMantenimiento() {
        System.out.println("guardarMantenimiento");
        MantenimientoControlGeneral mantenimientoGS = null;
        ManControlGeneralService instance = new ManControlGeneralService();
        Response expResult = null;
        Response result = instance.guardarMantenimiento(mantenimientoGS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
