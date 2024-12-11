package ejercicios;

import java.io.File;

public class recuentoDeElementos {
	
	public void busqueda(String ruta) {
		File file = new File(ruta);
		
		if (file.isFile()) {
			String[] fichero = ruta.split("\\\\");
			int[] vocal = vocales(fichero[fichero.length-1]);
			System.out.println("Hay:\n"
					+ "a: " + vocal[0] + "\n"
					+ "e: " + vocal[1] + "\n"
					+ "i: " + vocal[2] + "\n"
					+ "o: " + vocal[3] + "\n"
					+ "u: " + vocal[4] + "\n");
		} else {
			System.out.println("El fichero no existe o es un directorio");
		}
		
	}
	
	public int[] vocales(String nombre) {
		String vocal[] = {"a", "e", "i", "o", "u"};
		int count[] = {0, 0, 0, 0, 0};
		
		nombre.toLowerCase();
		String fichero[] = nombre.split("");
		
		for (int i = 0; i < vocal.length; i++) {
			for (int j = 0; j < fichero.length; j++) {
				if (vocal[i].equals(fichero[j])) {
					count[i]++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		recuentoDeElementos recuento = new recuentoDeElementos();
		
		recuento.busqueda("C:\\Users\\hombr\\Documents\\Captura de pantalla 2024-09-20 163451.png");
		recuento.busqueda("C:\\Users\\hombr\\Documents");
	}
}
