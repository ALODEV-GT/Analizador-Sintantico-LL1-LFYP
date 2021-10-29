package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * Permite cargar archivo o guardar archivos.
 * @author midik
 */
public class Archivo {

    private ArrayList<String> listaLineasArchivo = new ArrayList();
    
    public Archivo(File archivo){
        this.listarLineasArchivo(archivo);
    }
    
    public Archivo(){
        
    }

    /**
     * Lista las de un archivo.
     * @param archivo 
     */
    private void listarLineasArchivo(File archivo) {

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
                listaLineasArchivo.add(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
    }

    /**
     * Muestra en JTextArea indicado, las lineas de un archivo.
     * @param taCodigoFuente 
     */
    public void mostrarLineas(JTextArea taCodigoFuente) {
        taCodigoFuente.setText("");
        for (String linea : listaLineasArchivo) {
            taCodigoFuente.append(linea+"\n");
        }
    }
    
    /**
     * Guarda el texto contenido en el JTexArea principal.
     * @param archivo
     * @param documento
     * @return 
     */
    public boolean guardarArchivo(File archivo, String documento){
        FileOutputStream salida;
        boolean guardado = false;
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            guardado = true;
        }catch(FileNotFoundException ex){
            //Error
        } catch (IOException ex) {
            //Error
        }
        return guardado;
    }

}
