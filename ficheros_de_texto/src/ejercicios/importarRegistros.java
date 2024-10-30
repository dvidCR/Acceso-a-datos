package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class importarRegistros {
	
	public static ArrayList<String[]> ejecutar() throws IOException {
		File csv = new File("C:\\Clase\\Acceso-a-datos\\clase_16102024\\src\\clase_16102024\\registros.csv");
		FileReader fr = new FileReader(csv);
		
		BufferedReader br = new BufferedReader(fr);
		
		String[] row;
		ArrayList<String[]> contenido = new ArrayList<>();
        String line;
        
        while ((line = br.readLine()) != null) {                
            row = line.split(",");
            contenido.add(row);
        }
        
        br.close();
        
        return contenido;
	}
	
	public void enviar() throws IOException {
		ArrayList<String[]> data = ejecutar();
		Alumnos a = new Alumnos(data);
	}
	
	public static void main(String[] args) throws IOException {
		importarRegistros ir = new importarRegistros();
		ir.enviar();
	}
	
}
