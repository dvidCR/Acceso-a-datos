package sistemaFicheros;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class FileAnalyzer {

    public static void main(String[] args) {
    	
    	// TODO: Crear un objeto Scanner para leer la entrada del usuario desde la consola
    	Scanner sc = new Scanner(System.in);
    	        
    	// TODO: Solicitar al usuario que introduzca la ruta del fichero o directorio
    	System.out.print("Intrduce la ruta del directorio: ");

    	// TODO: Leer la ruta ingresada por el usuario y guardarla en la variable 'path'
    	String path = sc.nextLine();
    	
    	// TODO: Crear un objeto File usando la ruta proporcionada por el usuario
    	File f = new File(path);

    	// TODO: Verificar si el directorio proporcionado es válido (existe y es un directorio)
    	if (isValidDirectory(f)) {
    		boolean filterByRecent = true;
    		File[] files = null;

    		// TODO: Comprobar si la lista de argumentos contiene la opción "-o" para ordenar por fecha de modificación
    		if (args.toString().equals("-o")) {
    			filterByRecent = false;
    			
    			// TODO: Obtener los archivos del directorio, con la opción de ordenarlos si 'filterByRecent' es verdadero
    			files = getFiles(f, filterByRecent);
    			
        		displayFiles(files, filterByRecent);
    			
			// TODO: Comprobar si la lista de argumentos contiene la opción "-m" para filtrar archivos recientes
    		} else if (args.toString().equals("-m")) {
    			filterByRecent = true;
    			
    			// TODO: Mostrar la información de los archivos, aplicando el filtro de archivos recientes si 'orderByDate' es verdadero
    			files = getFiles(f, filterByRecent);
    			
    			displayFiles(files, filterByRecent);
    		}

    	} else {
    		// TODO: Si el directorio no es válido, mostrar un mensaje de error y terminar el programa
    		System.out.println("La ruta del directorio no existe o esta mal escrita");
    	}
    	
    	sc.close();

    }

    /**
     * Verifica si el directorio es válido.
     *
     * @param directory Directorio a verificar
     * @return true si es un directorio válido; false en caso contrario
     */
    private static boolean isValidDirectory(File directory) {
    	// TODO: Comprobar si el directorio existe y es efectivamente un directorio, devolviendo true si ambas condiciones se cumplen
    	return (directory.isDirectory() && directory.exists());
    }

    /**
     * Obtiene los archivos del directorio, con opción de ordenarlos por fecha de modificación.
     *
     * @param directory Directorio del cual se obtendrán los archivos
     * @param orderByDate Si es true, los archivos se ordenarán por fecha de modificación
     * @return Array de archivos del directorio
     */
    private static File[] getFiles(File directory, boolean orderByDate) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No se pudo leer el contenido del directorio.");
            return new File[0];
        }

        if (orderByDate) {
            Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        }
        return files;
    }

    /**
     * Muestra los archivos en la consola, aplicando el filtro de modificación reciente si se solicita.
     *
     * @param files Array de archivos a mostrar
     * @param filterByRecent Si es true, se mostrarán solo los archivos modificados en la última semana
     */
    private static void displayFiles(File[] files, boolean filterByRecent) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        long currentTime = System.currentTimeMillis();
        long weekInMillis = 7L * 24 * 60 * 60 * 1000; // Una semana en milisegundos

        for (File file : files) {
            if (filterByRecent && !isModifiedWithinLastWeek(file, currentTime, weekInMillis)) {
                continue;
            }
            printFileInfo(file, dateFormat);
        }
    }

    /**
     * Verifica si el archivo fue modificado en la última semana.
     *
     * @param file Archivo a verificar
     * @param currentTime Tiempo actual en milisegundos
     * @param weekInMillis Milisegundos en una semana
     * @return true si el archivo fue modificado en la última semana; false en caso contrario
     */
    private static boolean isModifiedWithinLastWeek(File file, long currentTime, long weekInMillis) {
        return currentTime - file.lastModified() <= weekInMillis;
    }

    /**
     * Imprime la información de un archivo en formato legible.
     *
     * @param file Archivo del cual se mostrará la información
     * @param dateFormat Formato de fecha para la última modificación
     */
    private static void printFileInfo(File file, SimpleDateFormat dateFormat) {
    	// TODO: Determinar el tipo del archivo; si es un directorio, asignar "Directorio", de lo contrario, asignar "Fichero"
    	String tipo = null;
    	if (file.isDirectory()) {
    		tipo = "Directorio: ";
    	} else if (file.isFile()) {
    		tipo = "Fichero: ";
    	}
    	
    	// TODO: Calcular el tamaño del archivo en kilobytes dividiendo su longitud en bytes entre 1024
    	double tamaño = file.length()/1024;
    	
    	// TODO: Obtener la fecha de última modificación del archivo y formatearla según el formato especificado en 'dateFormat'
    	String lastModified = dateFormat.format(new Date(file.lastModified()));
    	
    	// TODO: Imprimir la información del archivo: tipo, nombre, tamaño en KB y fecha de última modificación en formato legible
    	System.out.println(tipo + file + "Tamaño: " + tamaño + "Fecha: " + lastModified);

    }
}