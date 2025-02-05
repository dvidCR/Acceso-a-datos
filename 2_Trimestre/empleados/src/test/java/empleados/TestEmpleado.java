package empleados;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class TestEmpleado {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Empleado empleado = new Empleado();
            empleado.setNumeroEmpleado(12345L);
            empleado.setFechaNacimiento(new java.util.Date());
            empleado.setNombre("Juan");
            empleado.setApellidos("Pérez");
            empleado.setGenero('M');
            empleado.setFechaAlta(new java.util.Date());

            session.save(empleado);
            transaction.commit();

            System.out.println("Empleado guardado: " + empleado);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.shutdown();
    }
}