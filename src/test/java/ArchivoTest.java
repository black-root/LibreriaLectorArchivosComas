import controlador.Archivo;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ArchivoTest {


    @Test
    public void validarPathTest() {
        System.out.println("validarPath");
        String path = null;
        path = (new File("").getAbsolutePath ()+"/src/main/resources/mantenimientoinfo.csv");
        System.out.println("" + path);
        Archivo instance = new Archivo();
        boolean expResult = true;
        boolean result = instance.validarPath(path.toString());
        assertEquals(expResult, result);
    }

    @Test
    public void cargarArchivoTest() {
        System.out.println("cargarArchivo");
        //System.out.println("PROBANDO MAIN "+new File("").getAbsolutePath ()+"/src/main/resources/tpi2018.csv");
       // System.out.println("prueba 2 "+ClassLoader.getSystemResource("tpi2018.csv").toString());
        String path = new File("").getAbsolutePath ()+"/src/main/resources/mantenimientoControlGeneral.csv";
        Archivo instance = new Archivo();
        instance.setCargarArchivo(path,",","CONTROL GENERAL");

    }


}