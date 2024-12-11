package accesoAFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class leerTextoPlano {
	
	public void leer(String nombre) {
			
		File fichero = null;
		FileReader lector = null;
		BufferedReader buffer = null;
		
		try {
			  buffer = new BufferedReader(new FileReader(new File(nombre)));
			  String linea = null;
			  while ((linea = buffer.readLine()) != null)
			    System.out.println(linea);
		} catch (FileNotFoundException fnfe) { 
		  fnfe.printStackTrace();
		} catch (IOException ioe) { 
		  ioe.printStackTrace(); 
		} finally {
			  if (buffer != null)
				  try {
				    buffer.close();
				  } catch (IOException ioe) {
					  ioe.printStackTrace();
				  }
			}
		}

}
