package clase_2;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Método para mostrar datos
    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }

    public static void main(String[] args) {
        // Crear lista de productos
        List<Producto> productos = new ArrayList<>();

        // Agregar productos a la lista
        productos.add(new Producto("Laptop", 1200.50));
        productos.add(new Producto("Teléfono", 800.00));
        productos.add(new Producto("Auriculares", 150.75));

        // Ejecutar la lista con forEach
        productos.forEach(System.out::println);

        // Ejemplo: calcular el total de precios
        double total = productos.stream()
                                .mapToDouble(Producto::getPrecio)
                                .sum();
        System.out.println("Precio total: " + total);
    }
}

