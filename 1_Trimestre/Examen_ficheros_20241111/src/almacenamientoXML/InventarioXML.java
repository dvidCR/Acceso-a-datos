package almacenamientoXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InventarioXML {
	
	private String name;
	private int quantity;
	private double unitPrice;
	private String provider;
	private String entryDate;

    public static void main(String[] args) {
    	String rutaArchivo = "src/almacenamientoXML/inventario.xml";

	    try {
	        // TODO: Crear una instancia de DocumentBuilderFactory
	    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    	
	        // TODO: Crear un DocumentBuilder a partir de dbFactory
	    	DocumentBuilder db = dbf.newDocumentBuilder();

	    	// TODO: Cargar y analizar el archivo XML especificado por xmlFilePath
	    	Document xml = db.parse(new File(rutaArchivo));

	    	// TODO: Normalizar el contenido del documento XML
	    	xml.getDocumentElement().normalize();

	        // TODO: Obtener la lista de elementos "product" del XML
	    	NodeList inventario = xml.getElementsByTagName("inventory");

	        // TODO: Iterar sobre cada elemento "product" en resultList
	    	for (int i = 0; i < inventario.getLength(); i++) {
	    		Element el = (Element) inventario.item(i);
	    		
	    		Element producto = (Element) el.getElementsByTagName("product").item(0);

	    		InventarioXML productos = new InventarioXML(producto);

	            // TODO: Imprimir el resultado utilizando el método toString()
	    		System.out.println(productos.toString());
	    		
	    	}

	    } catch (Exception e) {
	        // TODO: Imprimir un mensaje de error si ocurre una excepción al procesar el archivo XML
	    	e.printStackTrace();
	    }
    }
    
    public InventarioXML(Element product) {
	    try {
	       Element nombre = (Element) product.getElementsByTagName("name").item(0);
	       name = nombre.getTextContent();
	       
	       Element cantidad = (Element) product.getElementsByTagName("quantity").item(0);
	       quantity = Integer.parseInt(cantidad.getTextContent());
	       
	       Element precio = (Element) product.getElementsByTagName("unitPrice").item(0);
	       unitPrice = Double.parseDouble(precio.getTextContent());
	       
	       Element proveedor = (Element) product.getElementsByTagName("provider").item(0);
	       provider = proveedor.getTextContent();
	       
	       Element fecha = (Element) product.getElementsByTagName("entryDate").item(0);
	       entryDate = fecha.getTextContent();

	    } catch (Exception e) {
	        // TODO: Imprimir la traza de la excepción si ocurre un error
	    	e.printStackTrace();
	    }
	}

	@Override
	public String toString() {
		String resul = "Nombre delproducto:\n\t" + getName() + "Cantidad disponible: " + getQuantity()
				+ "\n\tCon un precio por unidad de: " + getUnitPrice()
				+ "\n\tCon el proveedor: " + getProvider() + " \n\tQue llego el: " + getEntryDate();
		
		return resul;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public String getProvider() {
		return provider;
	}

	public String getEntryDate() {
		return entryDate;
	}
	
}

