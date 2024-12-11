package ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Alumno implements Serializable {

    // Method to write data to the file
    public void guardar() {
        try (FileOutputStream fo = new FileOutputStream("Alumnos.dat");
             ObjectOutputStream oi = new ObjectOutputStream(fo)) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Escribe el nombre y primer apellido del alumno: ");
            String nombre = sc.nextLine();

            System.out.print("Escribe el nombre del ciclo que esta cursando: ");
            String ciclo = sc.nextLine();

            oi.writeUTF("Nombre: " + nombre);
            oi.writeUTF("Ciclo: " + ciclo);

            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrar() {
        try {
        	FileInputStream fi = new FileInputStream("Alumnos.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            String nombre = oi.readUTF();
            String ciclo = oi.readUTF();

            System.out.println(nombre);
            System.out.println(ciclo);
            
            oi.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		Alumno a = new Alumno();
		
		a.guardar();
		a.mostrar();
	}
}
