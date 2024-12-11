package ficherosDeTexto;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO: Crear una instancia de GestionAlumnos para gestionar la lista de alumnos
		GestionAlumnos ga = new GestionAlumnos();

		// TODO: Agregar 5 alumnos a la lista
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Escribe el nombre del alumno: ");
			String nombre = sc.nextLine();
			
			System.out.print("Escribe la edad del alumno: ");
			int edad = sc.nextInt();
			
			System.out.print("Escribe el ciclo del alumno: ");
			String ciclo = sc.nextLine();
			
			System.out.print("Escribe la nota media del alumno: ");
			double notaMedia = sc.nextDouble();
			
			Alumno alumno = new Alumno(nombre, edad, ciclo, notaMedia);
			ga.agregarAlumno(alumno);
		}
		
		sc.close();

		// TODO: Llamar al método exportarAlumnosAJson de la instancia gestionAlumnos para exportar la lista a un archivo JSON llamado "Alumnos.json"
		ga.exportarAlumnosAJson("Alumnos.json");
    }
}
