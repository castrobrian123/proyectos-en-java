
package services;

import productos.Producto;
import java.util.ArrayList;

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

    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        if (p != null) {
            productos.remove(p);
            System.out.println("Eliminado");
        } else {
            System.out.println("No encontrado");
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
