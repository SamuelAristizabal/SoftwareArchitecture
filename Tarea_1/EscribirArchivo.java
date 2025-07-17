import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirArchivo {
    public void Archivar(String nombre) throws IOException {
        FileWriter archivo = null;
        PrintWriter escritor = null;
        
        try {
            archivo = new FileWriter("C:\\CodigosVisual\\ArquitecturaDeSoftware\\Tarea_1\\archivo.txt");
            escritor = new PrintWriter(archivo);


            escritor.println(nombre);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            if (archivo != null) {
                archivo.close();
            }
        }
        
    }
}
