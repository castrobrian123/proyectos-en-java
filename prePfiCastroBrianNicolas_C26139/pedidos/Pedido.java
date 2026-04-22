package prePfiCastroBrianNicolas_C26139.pedidos;

import prePfiCastroBrianNicolas_C26139.lineaPedido.LineaPedido;

import java.util.ArrayList;

public class Pedido {
    private static int contador = 1;

    private int id;
    private ArrayList<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {
        this.id = contador++;
    }

    public void agregarLinea(LineaPedido lp) {
        lineas.add(lp);
    }

    public void mostrar() {
        double total = 0;

        System.out.println("Pedido #" + id);

        for (LineaPedido l : lineas) {
            double sub = l.subtotal();
            total += sub;

            System.out.println(
                l.getProducto().getNombre() +
                " x" + l.getCantidad() +
                " = $" + sub
            );
        }

        System.out.println("TOTAL: $" + total);
    }
}
