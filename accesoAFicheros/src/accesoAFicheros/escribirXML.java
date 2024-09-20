package accesoAFicheros;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class escribirXML {

	public void escribir(String nombre, String precio) {
		DOMImplementation dom = null;
		
		Document documento = dom.createDocument(null, "xml", null);
		Element raiz = documento.createElement("productos");
		documento.getDocumentElement().appendChild(raiz);
		Element nodoProducto = null , nodoDatos = null ;
		Text texto = null;
		
		nodoProducto = documento.createElement("producto");
		raiz.appendChild(nodoProducto);
		nodoDatos = documento.createElement("nombre");
		nodoProducto.appendChild(nodoDatos);
		texto = documento.createTextNode(nombre);
		nodoDatos.appendChild(texto);
		nodoDatos = documento.createElement("precio");
		nodoProducto.appendChild(nodoDatos);
		texto = documento.createTextNode(precio);
		nodoDatos.appendChild(texto);

	}
}
