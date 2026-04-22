package clase_6;

public class Ejercicio {
    public static void main(String[] args) {

        // Cliente
        Cliente cliente = new Cliente("Juan", "juan@email.com");
        cliente.setEmail("emailinvalido"); // prueba de validación

        // Productos
        Producto p1 = new Producto("Notebook", 1500.0, 10);
        Producto p2 = new Producto("Mouse", 25.0, 50);
        Producto p3 = new Producto("Teclado", 45.0, 30);

        // Prueba de setter con valor negativo
        p1.setCantidadEnStock(-10);

        // Carrito
        Carrito carrito = new Carrito();
        carrito.agregarProducto(p1);
        carrito.agregarProducto(p2);
        carrito.agregarProducto(p3);

        // Mostrar total
        System.out.println("Total del carrito: $" + carrito.calcularTotal());

        // Mostrar cantidad de productos creados
        System.out.println("Cantidad de productos creados: " + Producto.getContadorProductos());
    }
}
