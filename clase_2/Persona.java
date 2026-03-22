package clase_2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    
    private String nombre;
    private int edad;
    
    // Constructor por defecto
    public Persona() {
        this.nombre = "Desconocido";
        this.edad = 0;
    }

    // Constructor con parametros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Creamos Getters para indicar el tipo de dato
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }

    public static void main(String[] args) {
        
        // Crear lista de personas
        List<Persona> personas = new ArrayList<>();
        
        // Usar distintos constructores
        personas.add(new Persona());        
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Luis", 30));
        personas.add(new Persona("Maria", 22));

        // "Ejecutar" la lista con forEach
        personas.forEach(System.out::println);


    }
}
