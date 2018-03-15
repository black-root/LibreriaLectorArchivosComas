
import com.jayway.restassured.RestAssured;
import controlador.Archivo;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import modelo.MantenimientoControlGeneral;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import service.ManControlGeneralService;

public class ArchivoTest {
    private  File tempfile =null;
    private  File tempfile1 =null;
    @Rule
    public TemporaryFolder DirectorioPrueba = new TemporaryFolder();

    @Before
    public void crearArchivosTemp() throws IOException {
        String contentido1 = "4, HCE4, 12040.3301. 080.0087, Dell, 22S5JL1, Optiplex 780, Licdo. Jorge Mauricio Rivera,"
                + " Windows, 7.0 Ultimate SP1, 64 bits, 0,\n"
                + "Office 2007 Original, 2GB RAM\n"
                + "Monitor N° 12040.3301.080.0091 PC no tiene UPS\n"
                + "EQUIPO NO POSEE CUENTA DE ADMIN",
                contenido2 = "2, 13/03/2017, CRR, -,\n"
                + "Restauración de fábrica de sistema Operativo\n"
                + "Instalación de programas utilitarios\n"
                + "Creación de respaldo de datos\n"
                + "Creación de cuenta de usuario standard";
        tempfile = DirectorioPrueba.newFile("controlGeneral.csv");
        tempfile1 = DirectorioPrueba.newFile("historialPreventivo.csv");
        try (FileWriter fw = new FileWriter(tempfile.getAbsolutePath()); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(contentido1);
        }
        try (FileWriter fw = new FileWriter(tempfile1.getAbsolutePath()); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(contenido2);
        }
    }
    
    @Test
    public void validarPathTest() throws IOException {
        System.out.println("validarPath");
        //FileWriter path = fw;
        System.out.println("" + tempfile.getAbsolutePath());
        Archivo instance = new Archivo();
        boolean expResult = true;
        boolean result = instance.validarPath(tempfile.getAbsolutePath());
        assertEquals(expResult, result);
    }

    //test para controlGeneral
    @Test
    public void cargarArchivoTestCG() {
        System.out.println("cargarArchivo");
        //System.out.println("PROBANDO MAIN "+new File("").getAbsolutePath ()+"/src/main/resources/tpi2018.csv");
        // System.out.println("prueba 2 "+ClassLoader.getSystemResource("tpi2018.csv").toString());
        String path = DirectorioPrueba.toString() + "/controlGeneral.csv";
        Archivo instance = new Archivo();
        instance.setCargarArchivo(path, ",", "CONTROL GENERAL");

    }

    //test para historialPreventivo
    @Test
    public void cargarArchivoTestHP() {
        System.out.println("cargarArchivo");
        //System.out.println("PROBANDO MAIN "+new File("").getAbsolutePath ()+"/src/main/resources/tpi2018.csv");
        // System.out.println("prueba 2 "+ClassLoader.getSystemResource("tpi2018.csv").toString());
        String path = DirectorioPrueba.toString() + "/historialPreventivo.csv";
        Archivo instance = new Archivo();
        instance.setCargarArchivo(path, ",", "HISTORIAL PREVENTIVO");

    }
    
}
