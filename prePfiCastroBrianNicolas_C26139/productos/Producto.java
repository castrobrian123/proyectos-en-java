
package productos;

public class Producto {
    private static int contador = 1;

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contador++;
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + nombre + " | $" + precio + " | Stock: " + stock;
    }
}
