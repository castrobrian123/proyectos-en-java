package clase_6;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    private static int contadorProductos = 0; // variable de clase

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        setCantidadEnStock(cantidadEnStock);
        contadorProductos++;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        if (cantidadEnStock >= 0) {
            this.cantidadEnStock = cantidadEnStock;
        } else {
            System.out.println("No se puede asignar stock negativo.");
        }
    }

    public static int getContadorProductos() {
        return contadorProductos;
    }
}
