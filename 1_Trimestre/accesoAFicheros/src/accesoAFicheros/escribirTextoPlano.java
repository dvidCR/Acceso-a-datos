package accesoAFicheros;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class escribirTextoPlano {
	
	public void escribir(String nombre, String frase) {
		
		FileWriter fichero = null;
		PrintWriter escritor = null;
		
		try {
			fichero = new FileWriter("archivo.txt");
			escritor = new PrintWriter(fichero);
			escritor.println(frase);
		} catch (IOException  ioe) {
			ioe.printStackTrace() ;
		} finally {
			if (fichero != null)
			  try {
			    fichero.close();
			  } catch (IOException  ioe) {
				  ioe.printStackTrace() ;
			  }
		}
	}
}
	
