

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para gestionar la creación y configuración de la SessionFactory
 * que se utiliza para interactuar con Hibernate y la base de datos.
 * Esta clase utiliza el archivo de configuración hibernate.cfg.xml para inicializar Hibernate.
 */
public class HibernateUtil {

    // Declara una variable estática de tipo SessionFactory. Esta instancia será única para toda la clase.
    private static final SessionFactory sessionFactory;

    // Bloque estático que se ejecuta solo una vez cuando se carga la clase.
    static {
        try {
            // Crear la SessionFactory a partir de la configuración de hibernate.cfg.xml
            // El método configure() carga el archivo de configuración (hibernate.cfg.xml) que debe estar en el 
            // classpath de tu aplicación (generalmente en la carpeta src o en el directorio de recursos).
            sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();

        } catch (Throwable ex) {
            // Si ocurre un error al crear la SessionFactory, se lanza una excepción fatal.
            // Esto es crítico porque sin una SessionFactory no podremos interactuar con la base de datos.
            System.err.println("La creación de la SessionFactory falló. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Método estático que devuelve la SessionFactory previamente creada.
     * 
     * @return sessionFactory la SessionFactory de Hibernate que se utiliza para obtener sesiones de Hibernate.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
