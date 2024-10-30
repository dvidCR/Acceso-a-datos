package ejercicios;

import java.io.File;
import java.util.Scanner;

public class gestionDeDirectorios {
	
	public void listar(String ruta) {
		File archivo = new File(ruta);
		
		if (archivo.isFile()) {
			System.out.println("El archivo es un fichero y tiene " + archivo.length() / 1000 + "kb");
		}
		else if (archivo.isDirectory()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("El archivo es un directorio y tiene " + archivo.length() / 1000 + "kb");
			
			System.out.print("¿Quieres ver el contendio del directorio(s/n): ");
						
			if (sc.nextLine().toLowerCase().equals("s")) {
				String[] contenido = contenido(ruta);
				System.out.println("\nContenido del directorio:");
				for (String archivoEnDir : contenido) {
					System.out.println(archivoEnDir);
				}
			}
			
			sc.close();
		}
	}
	
	public String[] contenido(String ruta) {
		File dir = new File(ruta);
		
		return dir.list();
	}
	
	public static void main(String[] args) {
		gestionDeDirectorios contenido = new gestionDeDirectorios();
		
		contenido.listar("C:\\Users\\hombr\\Documents\\Captura de pantalla 2024-09-20 163451.png");
		contenido.listar("C:\\Users\\hombr\\Documents");
	}
}
