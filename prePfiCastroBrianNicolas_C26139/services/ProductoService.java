
package services;

import productos.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
    }

    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos");
        } else {
            productos.forEach(System.out::println);
        }
    }

    public Producto buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Producto buscarPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public void actualizarProducto(int id, double precio, int stock) {
        Producto p = buscarPorId(id);

        if (p != null) {
            p.setPrecio(precio);
            p.setStock(stock);
            System.out.println("Producto actualizado");
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void eliminar(int id) {
        boolean eliminado = productos.removeIf(p -> p.getId() == id);

        if (eliminado) {
            System.out.println("Eliminado");
        } else {
            System.out.println("No encontrado");
        }
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
