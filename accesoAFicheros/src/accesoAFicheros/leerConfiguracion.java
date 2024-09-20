package accesoAFicheros;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class leerConfiguracion {

	public void leer(String usuario, String password, String servidor, int puerto) {
		Properties configuracion = new Properties();
		try {
		  configuracion.load(new FileInputStream("configuracion.props"));
		  usuario = configuracion.getProperty("user");
		  password = configuracion.getProperty("password");
		  servidor = configuracion.getProperty("server");
		  puerto = Integer.valueOf(configuracion.getProperty("port"));
		  
		  System.out.println("Contenido del fichero de configuración:");
          configuracion.list(System.out);
          
		} catch (FileNotFoundException fnfe ) { 
		  fnfe.printStackTrace();
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		}

	}
}
