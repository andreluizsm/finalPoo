package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Veiculo;
import java.util.List;

public class VeiculoDAO {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(veiculo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    public Veiculo getVeiculoById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Veiculo.class, id);
        }
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(veiculo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    public void deletarVeiculo(Veiculo veiculo) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(veiculo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Veiculo> listarVeiculos() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Veiculo").list();
        }
    }
}
