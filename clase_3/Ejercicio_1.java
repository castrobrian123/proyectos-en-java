package clase_3;

public class Ejercicio_1 {
    public static void main(String[] args) {

        String producto = " té CHAi ";

        // Limpiar espacios
        producto = producto.trim();

        // Formatear: primera letra mayúscula y resto minúsculas
        producto = producto.substring(0, 1).toUpperCase() +
                   producto.substring(1).toLowerCase();

        System.out.println("Producto formateado: " + producto);

        // Longitud
        System.out.println("Longitud: " + producto.length());

        // Primera letra
        System.out.println("Primera letra: " + producto.charAt(0));

        // Verificar si contiene "Chai"
        System.out.println("¿Contiene 'Chai'? " + producto.contains("Chai"));
    }
}
