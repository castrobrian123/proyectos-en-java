package clase_7;

import java.util.ArrayList;

// Interfaz
interface Descontable {
    void aplicarDescuento(double porcentaje);
}

// Clase abstracta
abstract class Producto {
    protected String nombre;
    protected double precioBase;

    // Constructor
    public Producto(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método abstracto
    public abstract double calcularPrecioFinal();

    // Método común
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio base: $" + precioBase);
    }
}

// Subclase Te
class Te extends Producto implements Descontable {

    private boolean importado;

    public Te(String nombre, double precioBase, boolean importado) {
        super(nombre, precioBase);
        this.importado = importado;
    }

    // Override
    @Override
    public double calcularPrecioFinal() {
        if (importado) {
            return precioBase * 1.20; // 20% extra
        }
        return precioBase;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        precioBase = precioBase - (precioBase * porcentaje / 100);
    }

    // Sobrescritura usando super
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Importado: " + importado);
    }
}

// Subclase Cafe
class Cafe extends Producto implements Descontable {

    private String tipo;

    // Uso de super en constructor
    public Cafe(String nombre, double precioBase, String tipo) {
        super(nombre, precioBase);
        this.tipo = tipo;
    }

    // Override
    @Override
    public double calcularPrecioFinal() {
        if (tipo.equalsIgnoreCase("premium")) {
            return precioBase * 1.30; // 30% extra
        }
        return precioBase;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        precioBase = precioBase - (precioBase * porcentaje / 100);
    }

    // Uso de super
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo de café: " + tipo);
    }
}

public class Ejercicio {
    public static void main(String[] args) {

        // Polimorfismo
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Te("Te Verde", 1500, true));
        productos.add(new Cafe("Cafe Colombiano", 3000, "premium"));
        productos.add(new Te("Te Negro", 1200, false));
        productos.add(new Cafe("Cafe Clasico", 2000, "normal"));

        // Recorrer lista
        for (Producto producto : productos) {

            producto.mostrarInfo();

            System.out.println("Precio final: $" + producto.calcularPrecioFinal());

            // Uso de interfaz
            if (producto instanceof Descontable) {
                ((Descontable) producto).aplicarDescuento(10);

                System.out.println("Precio con descuento: $" 
                        + producto.calcularPrecioFinal());
            }

            System.out.println("---------------------------");
        }
    }
}
