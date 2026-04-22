
package lineaPedido;

import productos.Producto;

public class LineaPedido {

    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() +
            " x" + cantidad +
            " = $" + subtotal();
    }
}