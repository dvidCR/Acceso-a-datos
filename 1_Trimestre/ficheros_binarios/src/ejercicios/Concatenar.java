package ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Concatenar {

    public void concatenar(String archivoFuente, String archivoDestino) {
        try {
        	FileInputStream fis = new FileInputStream(archivoFuente);
            FileOutputStream fos = new FileOutputStream(archivoDestino, true);
            
            byte[] buffer = new byte[1024];  // Buffer de 1KB
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("El contenido del archivo " + archivoFuente + " ha sido concatenado al archivo " + archivoDestino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	Concatenar concac = new Concatenar();
		
		concac.concatenar("Alumnos.dat", "archivoDestino.dat");
	}
    
}

