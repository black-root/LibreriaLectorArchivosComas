package controlador;

import modelo.Mantenimiento;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivo{
    private static List<Mantenimiento> listaMan = new ArrayList<>();

    public static boolean validarPath(final String path){
        boolean salida = false;
        //con trim eliminaremos los espacios que pueda contener el path
        if(path!=null && !path.trim().isEmpty()){
            salida = Paths.get(path).toFile().exists();
        }
        return salida;
    }
    /* se agrego un segundo parametro String Caracter, porque asi sera mas dinamico el metodo a la hora 
    de llamar*/

    //metodo para alimentar el modelo(pojo)
    public static void setCargarArchivo(final String path, String caracter){
        listaMan.clear();
        if(validarPath(path)){

        BufferedReader br = null;
        String line;
        //caracter con el que se separaran las columnas
            try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String text="";
                // use comma as separator                
                String[] country = line.split(caracter);
                for (String aCountry : country) text = text + "\t" + aCountry;
                //Alimentamos el constructor del pojo
                try {
                    Mantenimiento mantenimiento = new Mantenimiento(Integer.parseInt(country[0]), country[1],
                            country[2], country[3], country[4], country[5],country[6], country[7], country[8],
                            Boolean.parseBoolean(country[9]), country[10]);
                    listaMan.add(mantenimiento);
                }catch (Exception e){
                    System.out.println("ERROR, No se siguio el formato del archivo csv, estricamente se necesitan 11 campos o columnas \n" +
                            "Formato proporcionado en el aulavirtual, nombrepdf:Bitacora_Economía - Ciencias Económicas.pdf");
                }
                System.out.println(text);
                //textoLista.add(text);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    public static List<Mantenimiento> getCargarArchivo(){
        return listaMan;
   }

}
