package accesoAFicheros;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class escribirConfiguracion {
	
	public void escribir(String usuario, String contrasena, String servidor, String puerto) {
		Properties configuracion = new Properties();
		configuracion.setProperty("user", usuario);
		configuracion.setProperty("password", contrasena);
		configuracion.setProperty("server", servidor);
		configuracion.setProperty("port", puerto);
		try {
		  configuracion.store(new FileOutputStream("configuracion.props"), 
		                                           "Fichero de configuracion");
		} catch (FileNotFoundException fnfe ) { 
		  fnfe.printStackTrace(); 
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		}

	}
}
