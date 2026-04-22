
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

            int opcion = 0; 

            do {
                System.out.println("\n===== SISTEMA DE GESTIÓN =====");
                System.out.println("1) Agregar producto");
                System.out.println("2) Listar productos");
                System.out.println("3) Buscar/Actualizar producto");
                System.out.println("4) Eliminar producto");
                System.out.println("5) Crear pedido");
                System.out.println("6) Listar pedidos");
                System.out.println("7) Salir \n");
                System.out.print("Elegir opción: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion) {

                        case 1:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Precio: ");
                            double precio = Double.parseDouble(sc.nextLine());

                            System.out.print("Stock: ");
                            int stock = Integer.parseInt(sc.nextLine());

                            productoService.agregar(new Producto(nombre, precio, stock));
                            System.out.println("Producto agregado!");
                            break;

                        case 2:
                            System.out.println("==== LISTA DE PRODUCTOS ==== ");


                            productoService.listar();
                            break;

                        case 3:
                            System.out.println("Buscar por: 1) ID  2) Nombre");
                            int tipoBusqueda = Integer.parseInt(sc.nextLine());

                            Producto prod = null;

                            if (tipoBusqueda == 1) {
                                System.out.print("ID: ");
                                int id = Integer.parseInt(sc.nextLine());
                                prod = productoService.buscarPorId(id);
                            } else if (tipoBusqueda == 2) {
                                System.out.print("Nombre: ");
                                String nom = sc.nextLine();
                                prod = productoService.buscarPorNombre(nom);
                            }

                            if (prod != null) {
                                System.out.println("Encontrado: " + prod);

                                System.out.println("1) Cambiar precio");
                                System.out.println("2) Cambiar stock");
                                System.out.println("3) Salir");
                                int opAct = Integer.parseInt(sc.nextLine());

                                if (opAct == 1) {
                                    System.out.print("Nuevo precio: ");
                                    double nuevoPrecio = Double.parseDouble(sc.nextLine());
                                    prod.setPrecio(nuevoPrecio);
                                    System.out.println("Precio actualizado");
                                } else if (opAct == 2) {
                                    System.out.print("Nuevo stock: ");
                                    int nuevoStock = Integer.parseInt(sc.nextLine());
                                    prod.setStock(nuevoStock);
                                    System.out.println("Stock actualizado");
                                }

                            } else {
                                System.out.println("Producto no encontrado");
                            }
                            break;

                        case 4:
                            System.out.print("ID a eliminar: ");
                            int idEliminar = Integer.parseInt(sc.nextLine());
                            productoService.eliminar(idEliminar);
                            break;

                        case 5:
                            ArrayList<LineaPedido> lineas = new ArrayList<>();

                            System.out.print("Cantidad de productos distintos: ");
                            int cant = Integer.parseInt(sc.nextLine());

                            for (int i = 0; i < cant; i++) {
                                System.out.print("ID producto: ");
                                int idP = Integer.parseInt(sc.nextLine());

                                Producto p = productoService.buscarPorId(idP);

                                if (p != null) {
                                    System.out.print("Cantidad: ");
                                    int c = Integer.parseInt(sc.nextLine());

                                    lineas.add(new LineaPedido(p, c));
                                } else {
                                    System.out.println("Producto no encontrado, se omite.");
                                }
                            }

                            pedidoService.crearPedido(lineas);
                            System.out.println("Pedido creado!");
                            break;

                        case 6:
                            pedidoService.listar();
                            break;

                        case 7:
                            System.out.println("Saliendo...");
                            break;

                        default:
                            System.out.println("Opción inválida");
                    }

                } catch (StockInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: ingresá un número válido");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado");
                }

            } while (opcion != 7);
        sc.close();
    }
}
