package ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class gestionDeDirectorios {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Introduce la ruta del fichero: ");
		String rutaFichero = in.next();
		
		
		bucle(rutaFichero);
	}
	
	public static void bucle(String rutaFichero) {
		File f = new File(rutaFichero);
		
		if (f.exists()) {
			System.out.println("El directorio " + rutaFichero + " contiene:");
			String[] archivosList = f.list();
			
			for (String archivo : archivosList) {
				File fileAux = new File(rutaFichero+"\\"+archivo);
				if (fileAux.isFile()) {
					System.out.println("\t fichero: " + archivo + " " + archivo.length() + " KB");
				} else if (fileAux.isDirectory()) {
					System.out.println("\t directorio: " + archivo + " " + archivo.length() + " KB");
					bucle(fileAux.toString());
				} 
			}
		} else {
			System.out.println("El archivo o ruta no existe");
			System.exit(1);
		}
	}
}
