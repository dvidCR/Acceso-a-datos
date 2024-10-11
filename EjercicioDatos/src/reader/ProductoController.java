package reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos;
    private final String archivoDatos = "productos.dat";  // ruta fija del archivo

    public ProductoController() {
        productos = new ArrayList<>();
        cargarDatos();
    }

    // añadir un  producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarDatos();
    }

    // modificar un producto
    public void modificarProducto(int codigo, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                productos.set(i, nuevoProducto);
                guardarDatos();
                return;
            }
        }
    }

    // eliminar un producto
    public void eliminarProducto(int codigo) {
        productos.removeIf(producto -> producto.getCodigo() == codigo);
        guardarDatos();
    }

    // obtener un producto por codigo
    public Producto obtenerProducto(int codigo) {
        return productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    // Listar los productos
    public List<Producto> listarProductos() {
        return productos;
    }

    // guardar los datos en el fichero
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // cargar datos desde el fichero
    @SuppressWarnings({ "unchecked"})
	private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
            productos = (List<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de datos no encontrado, creando uno nuevo...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
