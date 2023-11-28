package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class ManejoArchivos {

    private static final String nuevoarchivo = "datos.txt";

    //Creación del archivo TXT
    public static void crearArchivo() {
        File archivo = new File(nuevoarchivo);   
    }
    
    //Lectura de datos en archivo
    public static String leerArchivo() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nuevoarchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }
    
    //Limpiar todos los datos en el archivo
    public static void limpiarArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevoarchivo))) {
            // Al abrir el archivo para escribir, se eliminará su contenido existente
            System.out.println("Contenido del archivo eliminado.");
        } catch (IOException e) {
            System.out.println("Error al limpiar el archivo: " + e.getMessage());
        }
    }
    
    //Agregar datos al archivo
    public static void escribirContacto(String contacto) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nuevoarchivo, true))) {
        // Escribir el contacto en el archivo
        writer.println(contacto);
        System.out.println("Contacto agregado al archivo.");
    } catch (IOException e) {
        System.out.println("Error al escribir el contacto en el archivo: " + e.getMessage());
        }
    }
    
    //Actualizar datos en el archivo buscando si el nombre ya existe en el contenido
    public static void actualizarContacto(String nombre, String numero) {
    // Leer el contenido actual del archivo
    String contenido = leerArchivo();
    String nombreBuscado = nombre + "!";
    if (contenido.contains(nombreBuscado)) {
        // Si existe se reemplaza la línea correspondiente
        String nuevaLinea = nombre + "!" + numero;
        contenido = contenido.replaceAll(nombreBuscado + "\\d+", nuevaLinea);
        System.out.println("Contacto actualizado en el archivo.");
    } else {
        // Si no existe se agregar la nueva línea al contenido
        contenido += nombre + "!" + numero + "\n";
        System.out.println("Contacto agregado al archivo.");
    }

    // Escribir el contenido actualizado en el archivo
    try (PrintWriter writer = new PrintWriter(new FileWriter(nuevoarchivo))) {
        writer.print(contenido);
    } catch (IOException e) {
        System.out.println("Error al escribir en el archivo: " + e.getMessage());
    }
    }
    
    //Eliminar un dato del archivo
    public static void eliminarContacto(String nombre, String numero) {
    // Leer el contenido del archivo
    String contenido = leerArchivo();

    // Buscar si el nombre ya existe en el archivo
    String nombreBuscado = nombre + "!";
    if (contenido.contains(nombreBuscado)) {
        // Si existe se elimina la línea correspondiente
        contenido = contenido.replaceAll(nombreBuscado + "\\d+", "");
    } else {
        // Si no existe se muestra el mensaje
        System.out.println("El contacto no existe en el archivo.");
    }

    // Escribir el contenido actualizado en el archivo
    try (PrintWriter writer = new PrintWriter(new FileWriter(nuevoarchivo))) {
        writer.print(contenido);
    } catch (IOException e) {
        System.out.println("Error al escribir en el archivo: " + e.getMessage());
    }
    }

}
