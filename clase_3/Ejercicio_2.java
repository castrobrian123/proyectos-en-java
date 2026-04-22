package clase_3;

public class Ejercicio_2 {
    public static void main(String[] args) {

        String[] productos = {"Café", "Té", "Azúcar", "Leche", "Miel"};

        // Imprimir elementos
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i]);
        }

        // Intentar agregar un sexto producto
        // productos[5] = "Chocolate"; // ❌ ERROR
    }
}
