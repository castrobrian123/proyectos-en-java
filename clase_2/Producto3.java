package clase_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto3 {

    private String nombre;
    private double precio;

    // Constructor

    public Producto3(String nombre, double precio) {
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
            productos.add(new Producto("Teléfono", 800.00));
            productos.add(new Producto("Auriculares", 150.75));

            // Lista para guardar la compra del cliente

            List<String> ticket = new ArrayList<>();
            double totalGeneral = 0;

            boolean continuar = true;
            while (continuar) {

                // Mostrar lista de productos

                System.out.println("\nProductos disponibles:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println((i + 1) + ". " + productos.get(i));
                }

                // Cliente escoge producto

                System.out.print("Ingrese el número del producto que desea: ");
                int opcion = scanner.nextInt();

                // Cliente indica cantidad

                System.out.print("Ingrese la cantidad que desea llevar: ");
                int cantidad = scanner.nextInt();

                // Calcular subtotal

                Producto elegido = productos.get(opcion - 1);
                double subtotal = elegido.getPrecio() * cantidad;

                // Aplicar descuento si cantidad > 100
                double descuento = 0;
                if (cantidad > 100) {
                    descuento = subtotal * 0.10; // 10% de descuento
                }

                double totalConDescuento = subtotal - descuento;

                // Sumar al total general (sin usar +=)
                totalGeneral = totalGeneral + totalConDescuento;

                // Guardar en ticket
                ticket.add(
                    elegido.getNombre() + " x" + cantidad + " = $" + subtotal + (
                        descuento > 0 ? " (Descuento: -$" + descuento + ")" : ""
                    ) + " Total: $" + totalConDescuento
                );

                // Preguntar si quiere seguir comprando

                System.out.print("¿Desea agregar otro producto? (s/n): ");
                String respuesta = scanner.next();
                if (!respuesta.equalsIgnoreCase("s")) {
                    continuar = false;
                }
            }

            // Mostrar ticket final

            System.out.println("\n--- Ticket de compra ---");
            for (String linea : ticket) {
                System.out.println(linea);
            }
            System.out.println("TOTAL: $" + totalGeneral);

            // Guardar ticket en archivo de texto

            try (FileWriter writer = new FileWriter("ticket.txt")) {

                writer.write("--- Ticket de compra ---\n");
                for (String linea : ticket) {
                    writer.write(linea + "\n");
                }

                writer.write("TOTAL: $" + totalGeneral + "\n");
                System.out.println("\nEl ticket se ha guardado en 'ticket.txt'");

            } catch (IOException e) {
                System.out.println("Error al guardar el ticket: " + e.getMessage());
            }

        scanner.close();

    }
    
}

