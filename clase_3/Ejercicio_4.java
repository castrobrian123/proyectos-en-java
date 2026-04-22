package clase_3;

import java.util.ArrayList;

public class Ejercicio_4 {
    public static void main(String[] args) {

        ArrayList<String> productos = new ArrayList<>();

        productos.add(" té CHAi ");
        productos.add("  cafe ");
        productos.add("AZUCAR");
        productos.add(" leche  ");

        System.out.println("Lista original:");
        for (String p : productos) {
            System.out.println(p);
        }

        // Formatear lista
        formatearLista(productos);

        System.out.println("\nLista formateada:");
        for (String p : productos) {
            System.out.println(p);
        }
    }

    // Método para formatear
    public static void formatearLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {

            String producto = lista.get(i).trim();

            producto = producto.substring(0, 1).toUpperCase() +
                       producto.substring(1).toLowerCase();

            lista.set(i, producto);
        }
    }
}
