package monaco;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;

public class main_alumnos {
    public static void main(String[] args) {
    	// TODO: Definir la ruta del archivo JSON como un String

    	try (
    	    // TODO: Crear un FileInputStream para leer el archivo JSON
    			FileInputStream fis = new FileInputStream("monaco.json");
    	) {
    	    // TODO: Crear un JSONTokener utilizando el FileInputStream
    		JSONTokener jst = new JSONTokener(fis);

    	    // TODO: Crear un JSONObject a partir del JSONTokener
    		JSONObject jso = new JSONObject(jst);

    	    // TODO: Obtener el objeto "race" del JSON principal
    		JSONObject jsoRace = jso.getJSONObject("race");

    	    // TODO: Obtener el objeto "results" dentro de "race"
    		JSONObject jsoResults = jsoRace.getJSONObject("results");

    	    // TODO: Obtener el array "result" dentro de "results"
    		JSONArray jsarrResult = jsoResults.getJSONArray("result");

    	    // TODO: Iterar sobre cada elemento del array "result"
    	    for (int i = 0; i < jsarrResult.length(); i++) {
    	        // TODO: Obtener el objeto "result" en la posición actual del array
    	    	JSONObject jsoResult = jsarrResult.getJSONObject(i);

    	        // TODO: Obtener el valor "position" como un entero
    	    	int position = jsoResult.getInt("position");
    	    	System.out.println("Posicion: " + position);

    	        // TODO: Obtener el objeto "Driver" dentro de "result"
    	    	JSONObject jsoDriver = jsoResult.getJSONObject("Driver");

    	        // TODO: Obtener el nombre y apellido del conductor y combinarlos en una cadena
    	    	String nombre = jsoDriver.getString("GivenName");
    	    	String apellido = jsoDriver.getString("FamilyName");
    	    	System.out.println("Nombre del Piloto: " + nombre);
    	    	System.out.println("Apellido del Piloto: " + apellido);

    	        // TODO: Obtener la nacionalidad del conductor
    	    	String nacionalidad = jsoDriver.getString("Nationality");
    	    	System.out.println("Nacionalidad del Conductor: " + nacionalidad);

    	        // TODO: Obtener el objeto "Constructor" dentro de "result"
    	    	JSONObject jsoConstructor = jsoResult.getJSONObject("Constructor");

    	        // TODO: Obtener el nombre del equipo
    	    	String nombreEquipo = jsoConstructor.getString("Name");
    	    	System.out.println("Nombre del Equipo: " + nombreEquipo);

    	        // TODO: Obtener el valor "Grid" como un String
    	    	String Grid = jsoResult.getString("Grid");
    	    	System.out.println("Grid: " + Grid);

    	        // TODO: Obtener el valor "Laps" como un String
    	    	String Laps = jsoResult.getString("Laps");
    	    	System.out.println("Vueltas: " + Laps);
    	    	
    	        // TODO: Obtener el tiempo total desde el objeto "Time" en formato de texto
    	    	JSONObject jsoTime = jsoResult.getJSONObject("Time");
    	    	String tiempo = jsoTime.getString("text");
    	    	System.out.println("Tiempo: " + tiempo);

    	        // TODO: Obtener el tiempo de la vuelta más rápida desde "FastestLap"
    	    	JSONObject jsoFastLap = jsoResult.getJSONObject("FastestLap");
    	    	String vueltaRapida = jsoFastLap.getString("lapTime");
    	    	System.out.println("Vuelta Rápida: " + vueltaRapida);
    	    	
    	        // TODO: Imprimir los datos del resultado en el formato indicado
    	    	JSONObject jsoSattus = jsoResult.getJSONObject("Status");
    	    	System.out.println("Posicion: " + jsoSattus.getString("statusID"));
    	    	
    	    	System.out.println("\n");
    	    }

    	} catch (IOException e) {
    	    // TODO: Manejar la excepción si ocurre un error al leer el archivo
    		e.printStackTrace();
    	}
    }
}
