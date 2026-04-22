
package pedidos;

import lineaPedido.LineaPedido;

import java.util.ArrayList;

public class Pedido {
    private static int contador = 1;

    private int id;
    private ArrayList<LineaPedido> lineas;

    public Pedido() {
        this.id = contador++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido lp) {
        lineas.add(lp);
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido l : lineas) {
            total += l.getProducto().getPrecio() * l.getCantidad();
        }
        return total;
    }

    public void mostrar() {
        System.out.println("Pedido ID: " + id);

        for (LineaPedido l : lineas) {
            System.out.println(
                l.getProducto().getNombre() + " x" + l.getCantidad() + " = $" + (l.getCantidad() * l.getProducto().getPrecio())
            );
        }

        System.out.println("Total: $" + calcularTotal());
    }

}
