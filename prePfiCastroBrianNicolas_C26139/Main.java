
import productos.Producto;
import lineaPedido.LineaPedido;
import services.ProductoService;
import services.PedidoService;
import excepciones.StockInsuficienteException;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();

        int opcion;

        do {
            System.out.println(" ");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Eliminar producto");
            System.out.println("4) Crear pedido");
            System.out.println("5) Listar pedidos");
            System.out.println("6) Salir\n");

            System.out.print("introdusca un numero: ");
            opcion = sc.nextInt();

            try {
                switch (opcion) {

                    case 1:
                        sc.nextLine();
                        System.out.print("\nNombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        System.out.print("Stock: ");
                        int stock = sc.nextInt();

                        productoService.agregar(new Producto(nombre, precio, stock));
                        break;

                    case 2:
                        productoService.listar();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        productoService.eliminar(id);
                        break;

                    case 4:
                        ArrayList<LineaPedido> lineas = new ArrayList<>();

                        System.out.print("\nCantidad de productos: ");
                        int cant = sc.nextInt();

                        for (int i = 0; i < cant; i++) {
                            System.out.print("ID producto: ");
                            int idP = sc.nextInt();

                            Producto p = productoService.buscarPorId(idP);

                            if (p != null) {
                                System.out.print("Cantidad: ");
                                int c = sc.nextInt();
                                lineas.add(new LineaPedido(p, c));
                            }
                        }

                        pedidoService.crearPedido(lineas);
                        System.out.println("Pedido creado!");
                        break;

                    case 5:
                        pedidoService.listar();
                        break;
                }
            } catch (StockInsuficienteException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error en datos ingresados");
                sc.nextLine();
            }

        } while (opcion != 6);

        sc.close();
    }
}
