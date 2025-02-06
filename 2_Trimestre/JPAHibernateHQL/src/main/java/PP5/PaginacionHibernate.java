package PP5;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import PP5.model.Employee;
import main.HibernateUtil;

public class PaginacionHibernate {

    private static final int PAGE_SIZE = 12; // Número de registros por página

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        int currentPage = 1; // Página actual
        int totalPages = obtenerTotalPaginas(session); // Total de páginas
        boolean running = true;

        while (running) {
            // Mostrar los resultados de la página actual
            mostrarPagina(session, currentPage);

            // Mostrar la información de la página actual
            System.out.println("Página " + currentPage + " de " + totalPages);
            System.out.println("Opciones: ");
            System.out.println("<A> Anterior");
            System.out.println("<S> Siguiente");
            System.out.println("<G n> Ir a la página n");
            System.out.println("<Q> Salir");

            // Leer la opción del usuario
            String opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "A": // Anterior
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.out.println("Ya estás en la primera página.");
                    }
                    break;
                case "S": // Siguiente
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.out.println("Ya estás en la última página.");
                    }
                    break;
                case "Q": // Salir
                    running = false;
                    break;
                case "G":
                    System.out.print("Ir a la página (n): ");
                    int paginaDestino = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (paginaDestino > 0 && paginaDestino <= totalPages) {
                        currentPage = paginaDestino;
                    } else {
                        System.out.println("Página inválida.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        session.getTransaction().commit();
        session.close();
        scanner.close();
    }

    // Método para obtener el total de páginas
    private static int obtenerTotalPaginas(Session session) {
        long totalRegistros = (long) session.createQuery("SELECT COUNT(e) FROM Employee e").uniqueResult();
        return (int) Math.ceil((double) totalRegistros / PAGE_SIZE);
    }

    // Método para mostrar los registros de la página actual
    private static void mostrarPagina(Session session, int pagina) {
        // Calcular el índice de inicio de los resultados
        int startIndex = (pagina - 1) * PAGE_SIZE;

        // Crear la consulta con paginación
        Query<Employee> query = session.createQuery("FROM Employee e", Employee.class);
        query.setFirstResult(startIndex);
        query.setMaxResults(PAGE_SIZE);

        // Obtener los resultados
        List<Employee> empleados = query.getResultList();

        // Mostrar los empleados
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en esta página.");
        } else {
            for (Employee empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }
}
