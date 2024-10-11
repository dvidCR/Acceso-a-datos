package reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos;
    private final String archivoDatos = "productos.dat";  // ruta fija del archivo
    
    /*@see cargarDatos() Para cargar el contenido del fichero*/
    public ProductoController() {
        productos = new ArrayList<>();
        cargarDatos();
    }

    /*
     * @see guardarDatos() Para añadir un producto
     * */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarDatos();
    }

    /*
     * @see guardarDatos En este caso es para guardar que has modificar un producto
     * */
    public void modificarProducto(int codigo, Producto nuevoProducto) {
    	for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getCodigo() == codigo) {
                productos.set(i, nuevoProducto);
                guardarDatos();
                break;
            }
        }
    }

    /*
     * @see guardarDatos() En este caso es para guardar que has eliminar un producto
     * */
    public void eliminarProducto(int codigo) {
    	 for (int i = 0; i < productos.size(); i++) {
             if (productos.get(i).getCodigo() == codigo) {
                 productos.remove(i);
                 guardarDatos();
                 break;
             }
         }
    }

    /*
     * @return obtener un producto por codigo
     */
    public Producto obtenerProducto(int codigo) {
    	for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; 
    }

    /*
     * @return Listar los productos
     */
    public List<Producto> listarProductos() {
        return productos;
    }

    // guardar los datos en el fichero
    private void guardarDatos() {
    	try {
            FileOutputStream fileOut = new FileOutputStream(archivoDatos);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(productos); // escribimos la lista de productos en el archivo
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // cargar datos desde el fichero
    @SuppressWarnings({ "unchecked"})
	private void cargarDatos() {
    	try {
            FileInputStream fileIn = new FileInputStream(archivoDatos);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            productos = (List<Producto>) objectIn.readObject();
            objectIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo. Se creará uno nuevo cuando guardes productos.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
