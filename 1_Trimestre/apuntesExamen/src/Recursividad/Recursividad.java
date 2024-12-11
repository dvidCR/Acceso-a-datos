package Recursividad;

import java.io.File;
import java.util.Scanner;

public class Recursividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del elemento: ");
        String ruta = sc.next();

        File rutaFichero = new File(ruta); // crear objeto File para encapsular la ruta que nos ha introducido por teclado el usuario

        // Verificar si la ruta existe y si es un directorio
        if (rutaFichero.exists() && rutaFichero.isDirectory()) {
            System.out.println("El directorio " + rutaFichero + " contiene: ");
            recorrerDirectorio(rutaFichero, 0, true); // llamada al metodo recursivo recorrerDirectorio para que se meta en los distintos subdirectorios y archivos que contiene el directorio principal
        } else {
            System.out.println("El archivo o ruta no existe o no es un directorio.");
        }
        
        sc.close();

    }

    // Metodo recorrerDirectorio(): recorrer directorio principal de manera recursiva para poder mostrar la jeraarquia del directorio mediante sus subdirectorios y ficheros
    private static void recorrerDirectorio(File directorio, int nivel, boolean esRecursivo) {
        File[] archivos = directorio.listFiles(); // Listamos el directorio principal mediante sus subdirectorios y ficheros

        // Verificamos si los archivos no están vacios
        if (archivos != null) {
            for (File archivo : archivos) { // Recorremos los archivos para poder tabular los distintos subdirectorios y archivos dentrp de la jerarquia
                String jerarquiaDirectorio = "\t".repeat(nivel);

                // Verificamos si los archivos son ficheros para poder obtener su nombre
                if (archivo.isFile()) {
                    System.out.println(jerarquiaDirectorio + "fichero: " + archivo.getName());
                } else if (archivo.isDirectory()) { // Verificamos si el archivo es un directorio para poder obtener su nombre
                    System.out.println(jerarquiaDirectorio + "Directorio: " + archivo.getName());
                    
                    if (esRecursivo) { // llamamos a la funcion asi misma para poder ir recorriendo la jerarquia del directorio mediante los distintos subdirectorios y ficheros
                        recorrerDirectorio(archivo, nivel + 1, true);
                    }
                }
            }
        }
    }
}
