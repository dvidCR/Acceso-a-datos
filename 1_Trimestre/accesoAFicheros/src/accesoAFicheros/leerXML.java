package accesoAFicheros;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class leerXML {

	public void leer() {
		DOMImplementation dom = null;
		
		Document documento = dom.createDocument(null, "xml", null);
		Element raiz = documento.createElement("productos");
		documento.getDocumentElement().appendChild(raiz);
		Element nodoProducto = null , nodoDatos = null ;
		Text texto = null;
		
		NodeList productos = documento.getElementsByTagName("producto");
		for (int i = 0; i < productos.getLength(); i++) {
		  Node producto = productos . item ( i ) ;
		  Element elemento = ( Element ) producto ;
		  System.out.println(elemento.getElementsByTagName("nombre").item(0)
		                     .getChildNodes().item(0).getNodeValue());
		  System.out.println(elemento.getElementsByTagName("precio").item(0)
		                     .getChildNodes().item(0).getNodeValue());
		}

	}
}
