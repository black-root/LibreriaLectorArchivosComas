package controlador;

import modelo.MantenimientoControlGeneral;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.MantenimientoHistorialPreventivo;

public class Archivo {

    private static List<MantenimientoControlGeneral> listaManCG = new ArrayList<>();
    private static List<MantenimientoHistorialPreventivo> listaManHP = new ArrayList<>();

    public static boolean validarPath(final String path) {
       boolean salida = false;
        //con trim eliminaremos los espacios que pueda contener el path
        if(path!=null && !path.trim().isEmpty()){
            salida = Paths.get(path).toFile().exists();
        }
        return salida;
    }
     

    /* se agrego un segundo parametro String Caracter, porque asi sera mas dinamico el metodo a la hora 
    de llamar*/

 /*metodo para alimentar el modelo(pojo)
        
        PARAMETROS DEL METODO setCargarArchivo
        path: direccion del archivo 
        caracter: pueden ser ", . + - _ "
        estructuraArchivo: los dos tipo de estructura proporcionados en la materia*/
    public static void setCargarArchivo(final String path, String caracter, String estructuraArchivo) {
        //limpiamos la lista cada vez que llamemos el metodo
        listaManCG.clear();
        listaManHP.clear();
        if (validarPath(path)) {

            BufferedReader br = null;
            String line;
            String[] country;
            int cont = 0;
            //caracter con el que se separaran las columnas
            try {
                br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    StringBuilder text = new StringBuilder();                    
                    //nos saltamos la primera linea que es usualmente la cabezera
                    if (cont != 0) {
                        //lineas.addElement(linea);//AGREGAR LINEASS A UN VECTOR

                        //linea de codigo estrictamente para MantenimientoControGeneral, la posicion 12 son las observaciones
                        if (estructuraArchivo.equals("CONTROL GENERAL")) {
                            country = line.split(caracter,12);

                            for (String aCountry : country) {
                                text.append("\t").append(aCountry);
                            }
                            System.out.println(country.length);
                            //Alimentamos el constructor del pojo
                            try {
                                MantenimientoControlGeneral mantenimientoCG = new MantenimientoControlGeneral(Integer.parseInt(country[0]), country[1],
                                        country[2], country[3], country[4], country[5], country[6], country[7], country[8], country[9],
                                        Boolean.parseBoolean(country[10]), country[11]);
                                listaManCG.add(mantenimientoCG);
                            } catch (Exception e) {
                                System.out.println("ERROR, No se siguio el formato del archivo csv, estricamente se necesitan 12 campos o columnas \n"
                                        + "Formato proporcionado en el aulavirtual, nombrepdf:Bitacora_Economía - Ciencias Económicas.pdf");
                            }
                        } else if(estructuraArchivo.equals("HISTORIAL DE MANTENIMIENTO")){
                            country = line.split(caracter);

                            for (String aCountry : country) {
                                text.append("\t").append(aCountry);
                            }
                            System.out.println(country.length);
                            //Alimentamos el constructor del pojo
                            try {
                                MantenimientoHistorialPreventivo mantenimientoHP = new MantenimientoHistorialPreventivo(Integer.parseInt(country[0]), String.valueOf(country[1]),
                                        country[2], country[3], country[4]);
                                listaManHP.add(mantenimientoHP);
                            } catch (Exception e) {
                                System.out.println("Error "+e);
                                System.out.println("ERROR, No se siguio el formato del archivo csv, estricamente se necesitan 5 campos o columnas \n"
                                        + "Formato proporcionado en el aulavirtual, nombrepdf:HISTORIAL DE MANTENIMIENTO PREVENTIVO");
                            }
                            
                        }else{
                            System.out.println("No selecciono ningun tipo de estructura");
                        }
                        System.out.println(text);
                    }
                    cont++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    //metodo muy necesario para el MantenimientoService
    public static List<MantenimientoControlGeneral> getCargarArchivoCG() {
        return listaManCG;
    }
    
    public static List<MantenimientoHistorialPreventivo> getCargarArchivoHP() {
        return listaManHP;
    }

}
