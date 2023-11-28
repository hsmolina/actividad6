
package logica;

import pantalla.Pantalla;

public class Main {
    
    public static void main(String[] args) {
        
    /*vamos a llamar a la clase Pantalla
    */
    Pantalla panta = new Pantalla();
    panta.setVisible(true);
    panta.setLocationRelativeTo(null);
    
    ManejoArchivos.crearArchivo();
        
    }
    
}
