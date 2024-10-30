package ejercicios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class caracteristicasFichero {

	public void properties(String archivo) throws IOException {
		File file = new File(archivo);
		FileReader fr = new FileReader(file);
		
		System.out.println(file.getFreeSpace());
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getTotalSpace());
		System.out.println(file.isHidden());

		fr.close();
	}
	
	public static void main(String[] args) throws IOException {
		caracteristicasFichero cf = new caracteristicasFichero();
		
		cf.properties("C:\\Users\\hombr\\Documents\\Nuevo Documento de texto.txt");
	}
}
