package by.ivuts.repository;

import by.ivuts.model.Course;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final DataSource dataSource;

    public CourseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Course findById(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM courses c where c.id=?")) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Course course = new Course();
            while (resultSet.next()) {
                course.setId(resultSet.getLong("id"));
                course.setName(resultSet.getString("name"));
                course.setHours(resultSet.getInt("hours"));
                course.setTeacherId(resultSet.getLong("teacher_id"));
            }
            return course;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find course", e);
        }
    }

    public void update(Course course) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("update courses set name = ?, hours = ?, teacher_id = ? where id= ?")) {
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getHours());
            stmt.setLong(3, course.getTeacherId());
            stmt.setLong(4, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot update course", e);
        }
    }

    public List<Course> findAll() {
        List<Course> course = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM courses")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Course course1 = new Course();
                course1.setId(resultSet.getLong("id"));
                course1.setName(resultSet.getString("name"));
                course1.setHours(resultSet.getInt("hours"));
                course1.setTeacherId(resultSet.getLong("teacher_id"));
                course.add(course1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find course", e);
        }
        return course;
    }

    public void insert(Course course) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO courses (name, hours,teacher_id) VALUES (?, ?, ?)")) {
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getHours());
            stmt.setLong(3, course.getTeacherId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find course", e);
        }
    }

    public void delete(Long id) throws SQLException {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM courses c where c.id = ?")) {
            try {
                conn.setAutoCommit(false);
                stmt.setLong(1, id);
                deleteCourseLinks(id);
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Cannot delete course", e);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    private void deleteCourseLinks(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement deleteUsersLinks = conn.prepareStatement("delete from users_courses_links where course_id = ? ")) {
            deleteUsersLinks.setLong(1, id);
            deleteUsersLinks.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete Course Links", e);
        }
    }
}
