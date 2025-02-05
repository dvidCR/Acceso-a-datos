package ciclistas;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class TestCiclista {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Ciclista ciclista = new Ciclista();
            ciclista.setNombre("Pedro");
            ciclista.setNacionalidad("ESP");
            ciclista.setEdad(28);
            ciclista.setPulsacionesPorMinuto(150);
            ciclista.setKilometrosRecorridos(12345.678);

            session.save(ciclista);
            transaction.commit();

            System.out.println("Ciclista guardado: " + ciclista);
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