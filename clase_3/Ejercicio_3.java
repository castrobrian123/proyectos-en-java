package clase_3;

import java.util.ArrayList;

public class Ejercicio_3 {
    public static void main(String[] args) {

        ArrayList<String> productos = new ArrayList<>();

        // Agregar productos
        productos.add("Café");
        productos.add("Té");
        productos.add("Azúcar");
        productos.add("Leche");

        // Eliminar uno
        productos.remove("Azúcar");

        // Verificar si existe
        System.out.println("¿Existe Té? " + productos.contains("Té"));

        // Imprimir lista final
        System.out.println("Lista final:");
        for (String p : productos) {
            System.out.println(p);
        }
    }
}
