package by.ivuts.repository;

import by.ivuts.exception.RepositoryException;
import by.ivuts.model.Course;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class CourseRepository {

    private final SessionFactory sessionFactory;

    public Course findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, id);
        } catch (Exception e) {
            throw new RepositoryException("Course with id = " + id + " was not found");
        }
    }

    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From courses", Course.class).list();
        } catch (Exception e) {
            throw new RepositoryException("Course was not found");
        }
    }


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
