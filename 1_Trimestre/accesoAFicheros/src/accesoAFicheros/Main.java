package accesoAFicheros;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Escribir ficheros de texto plano\r\n"
				+ "2. Leer fichero de texto plano \r\n"
				+ "3. Escribir fichero de configuración\r\n"
				+ "4. Leer fichero de configuración\r\n"
				+ "5. Escribir fichero XML Productos\r\n"
				+ "6. Leer fichero XML Productos\r\n"
				+ "7. Salir\r\n"
				+ ": ");
		
		int op = sc.nextInt();
		
		switch (op) {
			case 1: {
				escribirTextoPlano etp = new escribirTextoPlano();
				
				System.out.println("Escribe el nombre del fichero:\n");
				String nombre = sc.nextLine();
				
				System.out.println("Escribe aqui:\n");
				String frase = sc.nextLine();
				
				etp.escribir(nombre, frase);
			}
			
			case 2: {
				leerTextoPlano ltp = new leerTextoPlano();
				
				System.out.println("Escribe el nombre del fichero:\n");
				String nombre = sc.nextLine();
				
				ltp.leer(nombre);
			}
			
			case 3: {
				escribirConfiguracion ec = new escribirConfiguracion();
				
				System.out.println("Escribe tu nombre de usuario:\n");
				String nombre = sc.nextLine();
				
				System.out.println("Escribe tu contraseña:\n");
				String passwd = sc.nextLine();
				
				System.out.println("Escribe el servidor:\n");
				String server = sc.nextLine();
				
				System.out.println("Escribe el puerto:\n");
				String puerto = sc.nextLine();
				
				ec.escribir(nombre, passwd, server, puerto);
			}
			
			case 4: {
				leerConfiguracion lc = new leerConfiguracion();
				
				System.out.println("Escribe tu nombre de usuario:\n");
				String nombre = sc.nextLine();
				
				System.out.println("Escribe tu contraseña:\n");
				String passwd = sc.nextLine();
				
				System.out.println("Escribe el servidor:\n");
				String server = sc.nextLine();
				
				System.out.println("Escribe el puerto:\n");
				int puerto = sc.nextInt();
				
				lc.leer(nombre, passwd, server, puerto);
			}
			
			case 5: {
				escribirXML ex = new escribirXML();
				
				System.out.println("Escribe el nombre del producto:\n");
				String nombre = sc.nextLine();
				
				System.out.println("Escribe el precio del producto:\n");
				String precio = sc.nextLine();
				
				ex.escribir(nombre, precio);
			}
			
			case 6: {
				leerXML lx = new leerXML();
				
				lx.leer();
			}
			
			case 7: {
				System.out.println("Que tenga un buen dia");
			}
			
		}
		
		sc.close();

	}

}
