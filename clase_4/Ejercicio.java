package clase_4;

public class Ejercicio {

    public static void main(String[] args) {

        // 1. Probar calcularImpuesto
        double precio1 = calcularImpuesto(1000, 21);
        double precio2 = calcularImpuesto(2000, 10.5);

        System.out.println("Precio con impuesto 1: " + precio1);
        System.out.println("Precio con impuesto 2: " + precio2);

        // 2. Probar calcularPrecioFinal
        calcularPrecioFinal(500, 10, 30);
        calcularPrecioFinal(500, 10, 60); // mayor a 50 → más descuento

        // 3. Paso por valor con arrays
        int[] stock = {10, 20, 30};

        System.out.println("Stock antes:");
        mostrarStock(stock);

        reponerStock(stock, 1, 15);

        System.out.println("Stock después:");
        mostrarStock(stock);

        // 4. Sobrecarga de métodos
        mostrarMensaje("Bienvenido cliente nuevo");
        mostrarMensaje("Gracias por volver", 5);
    }

    // 1. Método calcularImpuesto
    public static double calcularImpuesto(double precio, double porcentaje) {
        return precio + (precio * porcentaje / 100);
    }

    // 2. Método calcularPrecioFinal
    public static void calcularPrecioFinal(double precio, double descuento, int cantidad) {
        if (cantidad > 50) {
            descuento += 5; // aumenta descuento
        }

        double precioFinal = precio - (precio * descuento / 100);
        precioFinal = precioFinal * cantidad;

        System.out.println("Precio final: " + precioFinal);
    }

    // 3. Método reponerStock
    public static void reponerStock(int[] stock, int indice, int cantidad) {
        stock[indice] += cantidad;
    }

    public static void mostrarStock(int[] stock) {
        for (int i = 0; i < stock.length; i++) {
            System.out.println("Producto " + i + ": " + stock[i]);
        }
    }

    // 4. Sobrecarga de métodos
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarMensaje(String mensaje, int compras) {
        System.out.println(mensaje + " - Compras realizadas: " + compras);
    }
    
}
