package prePfiCastroBrianNicolas_C26139.main;

import prePfiCastroBrianNicolas_C26139.productos.Producto;
import prePfiCastroBrianNicolas_C26139.pedidos.Pedido;
import prePfiCastroBrianNicolas_C26139.lineaPedido.LineaPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar / Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                // AGREGAR PRODUCTO
                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Stock: ");
                    int stock = sc.nextInt();

                    productos.add(new Producto(nombre, precio, stock));
                    break;

                // LISTAR PRODUCTOS
                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos cargados.");
                    } else {
                        for (Producto p : productos) {
                            System.out.println(p);
                        }
                    }
                    break;

                // BUSCAR / ACTUALIZAR
                case 3: {

                    System.out.println("Buscar producto por:");
                    System.out.println("1) ID");
                    System.out.println("2) Nombre");

                    int tipoBusqueda = sc.nextInt();
                    sc.nextLine();

                    Producto encontrado = null;

                    if (tipoBusqueda == 1) {

                        System.out.print("Ingrese ID: ");
                        int idBuscar = sc.nextInt();

                        for (Producto p : productos) {
                            if (p.getId() == idBuscar) {
                                encontrado = p;
                                break;
                            }
                        }

                    } else if (tipoBusqueda == 2) {

                        System.out.print("Ingrese nombre: ");
                        String nombreBuscar = sc.nextLine();

                        for (Producto p : productos) {
                            if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                                encontrado = p;
                                break;
                            }
                        }
                    }

                    if (encontrado != null) {

                        System.out.println("Producto encontrado:");
                        System.out.println(encontrado);

                        System.out.println("¿Qué desea actualizar?");
                        System.out.println("1) Precio");
                        System.out.println("2) Stock");
                        System.out.println("3) Nada");

                        int opcionAct = sc.nextInt();

                        switch (opcionAct) {

                            case 1:
                                System.out.print("Nuevo precio: ");
                                double nuevoPrecio = sc.nextDouble();

                                if (nuevoPrecio > 0) {
                                    encontrado.setPrecio(nuevoPrecio);
                                    System.out.println("Precio actualizado");
                                } else {
                                    System.out.println("Precio inválido");
                                }
                                break;

                            case 2:
                                System.out.print("Nuevo stock: ");
                                int nuevoStock = sc.nextInt();

                                if (nuevoStock >= 0) {
                                    encontrado.setStock(nuevoStock);
                                    System.out.println("Stock actualizado");
                                } else {
                                    System.out.println("Stock inválido");
                                }
                                break;

                            case 3:
                                System.out.println("Sin cambios");
                                break;
                        }

                    } else {
                        System.out.println("Producto no encontrado");
                    }

                    break;
                }

                // ELIMINAR PRODUCTO CON CONFIRMACIÓN
                case 4: {

                    System.out.print("Ingrese ID del producto a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();

                    Producto encontrado = null;

                    for (Producto p : productos) {
                        if (p.getId() == idEliminar) {
                            encontrado = p;
                            break;
                        }
                    }

                    if (encontrado != null) {

                        System.out.println("Producto encontrado:");
                        System.out.println(encontrado);

                        System.out.print("¿Está seguro que desea eliminarlo? (S/N): ");
                        String confirmacion = sc.nextLine();

                        if (confirmacion.equalsIgnoreCase("S") ||
                            confirmacion.equalsIgnoreCase("SI")) {

                            productos.remove(encontrado);
                            System.out.println("Producto eliminado correctamente");

                        } else {
                            System.out.println("Eliminación cancelada");
                        }

                    } else {
                        System.out.println("Producto no encontrado");
                    }

                    break;
                }

                // CREAR PEDIDO
                case 5: {

                    if (productos.isEmpty()) {
                        System.out.println("No hay productos disponibles.");
                        break;
                    }

                    Pedido pedido = new Pedido();

                    System.out.print("¿Cuántos productos desea agregar?: ");
                    int cantidad = sc.nextInt();

                    for (int i = 0; i < cantidad; i++) {

                        System.out.print("ID producto: ");
                        int id = sc.nextInt();

                        Producto encontrado = null;

                        for (Producto p : productos) {
                            if (p.getId() == id) {
                                encontrado = p;
                                break;
                            }
                        }

                        if (encontrado != null) {

                            System.out.print("Cantidad: ");
                            int cant = sc.nextInt();

                            if (cant <= encontrado.getStock()) {

                                encontrado.setStock(
                                    encontrado.getStock() - cant
                                );

                                pedido.agregarLinea(
                                    new LineaPedido(encontrado, cant)
                                );

                            } else {
                                System.out.println("Stock insuficiente");
                            }

                        } else {
                            System.out.println("Producto no encontrado");
                        }
                    }

                    pedidos.add(pedido);
                    System.out.println("Pedido creado correctamente");

                    break;
                }

                // LISTAR PEDIDOS
                case 6:
                    if (pedidos.isEmpty()) {
                        System.out.println("No hay pedidos realizados.");
                    } else {
                        for (Pedido p : pedidos) {
                            p.mostrar();
                            System.out.println("-----");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        sc.close();
    }
}
