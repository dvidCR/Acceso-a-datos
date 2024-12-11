package ficherosDeTexto;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class GestionAlumnos {
	private List<Alumno> listaAlumnos;

    public GestionAlumnos() {
        listaAlumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    // Método para exportar la lista de alumnos a un archivo JSON
    public void exportarAlumnosAJson(String nombreArchivo) {
    	try (FileInputStream fis = new FileInputStream(nombreArchivo)) {
			// TODO: Crear una nueva instancia de JSONArray para almacenar los datos de todos los alumnos en formato JSON
    		JSONArray array = new JSONArray(fis);
    		
	        // TODO: Iniciar un bucle for-each para recorrer cada objeto Alumno en la lista de alumnos
    		for (Alumno i: listaAlumnos) {
        		// TODO: Convertir cada objeto Alumno a JSON usando el método toJson y agregarlo al JSONArray
    			array.putAll(i.toJson());

    			// TODO: Crear un objeto FileWriter en un bloque try-with-resources para escribir en el archivo especificado por nombreArchivo
    			FileWriter fw = new FileWriter(nombreArchivo);
    			
    			// TODO: Escribir el contenido de jsonArray en el archivo, formateado con una indentación de 4 espacios para mayor legibilidad
    			for (int j = 0; j < array.length(); j++) {
    				fw.append(array.getString(j));
    			}
    			
    			fw.close();
    			
    			// TODO: Imprimir un mensaje de éxito en la consola indicando que el archivo JSON se generó correctamente
    			System.out.println("El archivo JSON se genero correctamente");
    		}
		// TODO: Capturar cualquier excepción IOException que ocurra durante la escritura del archivo
		} catch (IOException e) {			
			// TODO: Imprimir un mensaje de error en la consola si ocurre una excepción durante la escritura del archivo
			e.printStackTrace();
		}
        
    }
}
