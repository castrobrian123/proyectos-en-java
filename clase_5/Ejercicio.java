package clase_5;

// Clase Cliente
class Cliente {
    String nombre;
    String email;

    // 4. Constructor
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Método para mostrar datos
    public void mostrarCliente() {
        System.out.println("Cliente: " + nombre + " | Email: " + email);
    }
}

// Clase Producto
class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // 2. Método de instancia
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre +
                " | Precio: $" + precio +
                " | Stock: " + stock);
    }

    // 3. Método para descuento del 10%
    public double calcularDescuento() {
        return precio * 0.9;
    }
}

public class Ejercicio {
    public static void main(String[] args) {

        // 1. Creación de objeto Cliente
        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");
        cliente1.mostrarCliente();

        Cliente cliente2 = new Cliente("Ana Gómez", "ana@email.com");
        cliente2.mostrarCliente();

        // 2. Productos y uso de métodos
        Producto p1 = new Producto("Notebook", 1500, 10);
        Producto p2 = new Producto("Mouse", 25, 50);

        p1.mostrarInformacion();
        p2.mostrarInformacion();

        // 3. Probar descuento
        System.out.println("Precio con descuento Notebook: $" + p1.calcularDescuento());
        System.out.println("Precio con descuento Mouse: $" + p2.calcularDescuento());
    }
}
