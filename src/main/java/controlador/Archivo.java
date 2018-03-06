package controlador;

import java.io.*;

public class Archivo implements Serializable {

    public boolean validarPath(final String path){
        boolean salida = false;
        BufferedReader br = null;
        //con trim eliminaremos los espacios que pueda contener el path
        if(path!=null && !path.trim().isEmpty()){
            try{
                br = new BufferedReader(new FileReader(path));
            }catch(FileNotFoundException fe){
                System.out.println(""+fe);
            }
            salida = true;
        }
        return salida;
    }

    public void cargarArchivo(final String path){
        validarPath(path);
        String csvFile = new File("").getAbsolutePath ()+"/src/main/resources/tpi2018.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

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
