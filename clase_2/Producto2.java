package clase_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto2 {

    private String nombre;
    private double precio;

    // Constructor
    public Producto2(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            // Crear lista de productos
            List<Producto> productos = new ArrayList<>();
            productos.add(new Producto("Laptop", 1200.50));
            productos.add(new Producto("Telefono", 800.00));
            productos.add(new Producto("Auriculares", 150.75));

            // Mostrar lista de productos
            System.out.println("Lista de productos disponibles:");

            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }

            // Cliente escoge producto
            System.out.print("Ingrese el número del producto que desea: ");
            int opcion = scanner.nextInt();

            // Cliente indica cantidad
            System.out.print("Ingrese la cantidad que desea llevar: ");
            int cantidad = scanner.nextInt();

            // Calcular total
            Producto elegido = productos.get(opcion - 1);
            double total = elegido.getPrecio() * cantidad;

            System.out.println("\n--- Resumen de compra ---");
            System.out.println("Producto: " + elegido.getNombre());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio unitario: $" + elegido.getPrecio());
            System.out.println("Total a pagar: $" + total);

        scanner.close();

    }

}

