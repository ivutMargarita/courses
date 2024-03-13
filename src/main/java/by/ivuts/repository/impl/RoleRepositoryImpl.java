package by.ivuts.repository.impl;

import by.ivuts.exception.RepositoryException;
import by.ivuts.model.Role;
import by.ivuts.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Role findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery("FROM Role c join fetch c.users where c.id = ?", Role.class);
            query.setParameter(1, id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RepositoryException("Role with id = " + id + " was not found");
        }
    }

    @Override
    public List<Role> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Role c join fetch c.users", Role.class).list();
        } catch (Exception e) {
            throw new RepositoryException("Role was not found");
        }
    }

    @Override
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

    @Override
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

    @Override
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
