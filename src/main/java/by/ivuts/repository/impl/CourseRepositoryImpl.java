package by.ivuts.repository.impl;

import by.ivuts.exception.RepositoryException;
import by.ivuts.model.Course;
import by.ivuts.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Course findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Course> query = session.createQuery("FROM Course c left join fetch c.users where c.id = ?1", Course.class);
            query.setParameter(1, id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RepositoryException("Course with id = " + id + " was not found");
        }
    }

    @Override
    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Course c left join fetch c.users", Course.class).list();
        } catch (Exception e) {
            throw new RepositoryException("Course was not found");
        }
    }

    @Override
    public void insert(Course course) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.persist(course);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Course was not saved");
            }
        }
    }

    @Override
    public void update(Course course) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.merge(course);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Course was not updated");
            }
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                Course course = session.getReference(Course.class, id);
                session.remove(course);
                transaction.commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RepositoryException("Course was not deleted");
            }
        }
    }

}
