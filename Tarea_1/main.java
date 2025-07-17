import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        EscribirArchivo archivo = new EscribirArchivo();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        try {
        archivo.Archivar(nombre);
        System.out.println("Nombre guardado en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el nombre: " + e.getMessage());
        } catch (Exception e) {
        }
        
    }
}
