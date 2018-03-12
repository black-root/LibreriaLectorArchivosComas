package controlador;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivo implements Serializable {
    
private List<String> textoLista = new ArrayList<String>();

    public boolean validarPath(final String path){
        boolean salida = false;
        //con trim eliminaremos los espacios que pueda contener el path
        if(path!=null && !path.trim().isEmpty()){
            salida = Paths.get(path).toFile().exists();
        }
        return salida;
    }
    /* se agrego un segundo parametro String Caracter, porque asi sera mas dinamico el metodo a la hora 
    de llamar*/
    public List<String> cargarArchivo(final String path, String caracter){
        
        if(validarPath(path)){
             
        textoLista.removeAll(textoLista);

        BufferedReader br = null;
        String line = "";
        //caracter con el que se separaran las columnas
        String cvsSplitBy = caracter;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String text="";
                // use comma as separator                
                String[] country = line.split(cvsSplitBy);
                for(int i=0; i<country.length;i++){
                     text = text+"\t"+country[i];
                }
                
                System.out.println(text);
                textoLista.add(text);

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
       return textoLista;   
     
    }
}
