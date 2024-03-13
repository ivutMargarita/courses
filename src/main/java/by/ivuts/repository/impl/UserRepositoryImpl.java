package by.ivuts.repository.impl;

import by.ivuts.exception.RepositoryException;
import by.ivuts.model.User;
import by.ivuts.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User c join fetch c.users where c.id = ?", User.class);
            query.setParameter(1, id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RepositoryException("User with id = " + id + " was not found");
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User c join fetch c.users", User.class).list();
        } catch (Exception e) {
            throw new RepositoryException("User was not found");
        }
    }

    @Override
    public void insert(User user) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("User was not saved");
            }
        }
    }

    @Override
    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.merge(user);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("User was not updated");
            }
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                User user = session.get(User.class, id);
                session.remove(user);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("User was not deleted");
            }
        }
    }

}


