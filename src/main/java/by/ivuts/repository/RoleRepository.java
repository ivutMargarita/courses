package by.ivuts.repository;

import by.ivuts.exception.RepositoryException;
import by.ivuts.model.Role;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class RoleRepository {

    private final SessionFactory sessionFactory;

    public Role findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Role.class, id);
        } catch (Exception e) {
            throw new RepositoryException("Role with id = " + id + " was not found");
        }
    }

    public List<Role> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From roles", Role.class).list();
        } catch (Exception e) {
            throw new RepositoryException("Role was not found");
        }
    }

    public void insert(Role role) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.persist(role);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Role was not saved");
            }
        }
    }

    public void update(Role role) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.merge(role);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Role was not updated");
            }
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                Role role = session.getReference(Role.class, id);
                session.remove(role);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Role was not deleted");
            }
        }
    }

}
