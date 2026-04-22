package services;

import excepciones.StockInsuficienteException;
import lineaPedido.LineaPedido;
import pedidos.Pedido;
import productos.Producto;

import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Pedido crearPedido(ArrayList<LineaPedido> lineas) throws StockInsuficienteException {

        if (lineas == null || lineas.isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío");
        }

        Pedido pedido = new Pedido();

        
        for (LineaPedido l : lineas) {
            Producto p = l.getProducto();

            if (l.getCantidad() <= 0) {
                throw new IllegalArgumentException("Cantidad inválida para " + p.getNombre());
            }

            if (l.getCantidad() > p.getStock()) {
                throw new StockInsuficienteException("Stock insuficiente para " + p.getNombre());
            }
        }

        
        for (LineaPedido l : lineas) {
            Producto p = l.getProducto();
            p.setStock(p.getStock() - l.getCantidad());
            pedido.agregarLinea(l);
        }

        pedidos.add(pedido);
        return pedido;
    }

    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("\nNo hay pedidos");
        } else {
            pedidos.forEach(p -> {
                p.mostrar();
                System.out.println("-----");
            });
        }
    }
}
