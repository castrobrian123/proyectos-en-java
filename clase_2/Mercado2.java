package clase_2;

import java.util.Scanner;

public class Mercado2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //abre sc

            System.out.print("Ingrese el precio del producto: ");    //envia un dato por consola

            int precioDelProducto = sc.nextInt();                      //recibe un dato de tipo entero (int) y lo almacena en una variable de tipo entero

            System.out.print("Ingrese la cantidad deseada del producto: ");

            int cantidadDelProducto = sc.nextInt();

            System.out.println("el precio es: " + precioDelProducto); //devuelve impreso por consola el dato de tipo entero de la variable de tipo entero

            System.out.println("el cantidad deseada del producto es: " + cantidadDelProducto);

            int precioTotal = precioDelProducto * cantidadDelProducto;

            System.out.println("el precio total es: " + precioTotal);

        sc.close(); //cierra sc

    }
}
