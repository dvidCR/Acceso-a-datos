package EjemploCompleto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import EjemploCompleto.model.Alumno;
import EjemploCompleto.model.Curso;
import EjemploCompleto.model.Direccion;
import utils.HibernateUtil;

public class EjemploCRUD {

    // Método para crear un nuevo alumno
    public static void crearAlumno(Session session, String nombre, int edad, String curso) {
        Alumno nuevoAlumno = new Alumno(nombre, edad, curso);
        session.save(nuevoAlumno);  // Guardamos el alumno en la base de datos
        System.out.println("Alumno creado con éxito: " + nuevoAlumno);
    }

    // Método para obtener un alumno por su ID
    public static Alumno obtenerAlumno(Session session, int id) {
        return session.get(Alumno.class, id);  // Recuperamos un alumno usando su ID
    }

    // Método para actualizar un alumno
    public static void actualizarAlumno(Session session, int id, String nuevoNombre, int nuevaEdad, String nuevoCurso) {
        Alumno alumno = session.get(Alumno.class, id);  // Recuperamos el alumno a actualizar
        if (alumno != null) {
            alumno.setNombre(nuevoNombre);  // Actualizamos los valores del alumno
            alumno.setEdad(nuevaEdad);
            alumno.setCurso(nuevoCurso);
            session.update(alumno);  // Guardamos los cambios
            System.out.println("Alumno actualizado: " + alumno);
        } else {
            System.out.println("Alumno con ID " + id + " no encontrado.");
        }
    }

    // Método para eliminar un alumno
    public static void eliminarAlumno(Session session, int id) {
        Alumno alumno = session.get(Alumno.class, id);  // Recuperamos el alumno a eliminar
        if (alumno != null) {
            session.delete(alumno);  // Eliminamos el alumno de la base de datos
            System.out.println("Alumno eliminado: " + alumno);
        } else {
            System.out.println("Alumno con ID " + id + " no encontrado.");
        }
    }

    // Método para obtener todos los nombres de los alumnos mayores de 18
    public static void obtenerAlumnosMayoresDe18(Session session) {
        Query<String> query = session.createQuery("SELECT a.nombre FROM Alumno a WHERE a.edad > 18", String.class);
        List<String> nombres = query.getResultList();  // Ejecutamos la consulta

        System.out.println("Alumnos mayores de 18:");
        for (String nombre : nombres) {
            System.out.println(nombre);  // Imprimimos el nombre de cada alumno
        }
    }

    // Método para obtener todos los alumnos de un curso específico
    public static void obtenerAlumnosPorCurso(Session session, String curso) {
        Query<Alumno> query = session.createQuery("FROM Alumno a WHERE a.curso = :curso", Alumno.class);
        query.setParameter("curso", curso);  // Establecemos el parámetro del curso
        List<Alumno> alumnos = query.getResultList();  // Ejecutamos la consulta

        System.out.println("Alumnos del curso " + curso + ":");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);  // Imprimimos cada alumno encontrado
        }
    }

    // Ejemplo de relación Uno a Uno: Un alumno tiene una dirección
    public static void crearAlumnoConDireccion(Session session, String nombre, int edad, String curso, String calle, String ciudad) {
        Alumno alumno = new Alumno(nombre, edad, curso);
        Direccion direccion = new Direccion(calle, ciudad);
        
        alumno.setDireccion(direccion);  // Asignamos la dirección al alumno
        direccion.setAlumno(alumno);  // Establecemos la relación inversa
        
        session.save(alumno);  // Guardamos el alumno, y la dirección se guardará automáticamente
        System.out.println("Alumno con dirección creado: " + alumno);
    }

    // Ejemplo de relación Uno a Muchos: Un curso tiene muchos alumnos
    public static void crearCursoConAlumnos(Session session, String nombreCurso) {
        Curso curso = new Curso(nombreCurso);

        Alumno alumno1 = new Alumno("Juan Pérez", 20, nombreCurso);
        Alumno alumno2 = new Alumno("Ana Gómez", 22, nombreCurso);
        
        curso.getAlumnos().add(alumno1);  // Añadimos los alumnos al curso
        curso.getAlumnos().add(alumno2);

        session.save(curso);  // Guardamos el curso y los alumnos se guardarán automáticamente
        System.out.println("Curso con alumnos creado: " + curso);
    }

    // Ejemplo de relación Muchos a Muchos: Un alumno puede estar en muchos cursos
    public static void asignarCursosAMuchosAlumnos(Session session) {
        Alumno alumno = new Alumno("Luis Martínez", 19, "Matemáticas");
        Curso curso1 = new Curso("Física");
        Curso curso2 = new Curso("Química");

        alumno.getCursos().add(curso1);  // El alumno se matricula en Física
        alumno.getCursos().add(curso2);  // El alumno también se matricula en Química
        
        session.save(alumno);  // Guardamos el alumno y los cursos se guardarán automáticamente
        
        System.out.println("Alumno asignado a múltiples cursos: " + alumno);
    }

    // Método principal que realiza todas las operaciones
    public static void main(String[] args) {
        // Crear la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        // Iniciar la transacción
        session.beginTransaction();

        // Crear algunos alumnos
        crearAlumno(session, "Juan Pérez", 20, "Matemáticas");
        crearAlumno(session, "Ana Gómez", 17, "Física");
        crearAlumno(session, "Luis Martín", 19, "Historia");

        // Crear un alumno con dirección (relación uno a uno)
        crearAlumnoConDireccion(session, "Carlos López", 22, "Literatura", "Calle Falsa 123", "Madrid");

        // Crear un curso con varios alumnos (relación uno a muchos)
        crearCursoConAlumnos(session, "Filosofía");

        // Asignar un alumno a varios cursos (relación muchos a muchos)
        asignarCursosAMuchosAlumnos(session);

        // Obtener un alumno por ID
        Alumno alumno = obtenerAlumno(session, 1);  // Suponiendo que el ID 1 existe
        System.out.println("Alumno recuperado: " + alumno);

        // Actualizar un alumno
        actualizarAlumno(session, 2, "Ana Gómez", 18, "Física Avanzada");

        // Eliminar un alumno
        eliminarAlumno(session, 3);

        // Obtener alumnos mayores de 18
        obtenerAlumnosMayoresDe18(session);

        // Obtener alumnos de un curso específico
        obtenerAlumnosPorCurso(session, "Física");

        // Confirmar la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();
    }
}
