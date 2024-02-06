package by.ivuts.repository;

import by.ivuts.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users u where u.id=?")) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
                user.setActive(resultSet.getBoolean("active"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find user", e);
        }
    }

    public void update(User user) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("update users set username = ?, password = ?, active = ? where id= ?")) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setBoolean(3, user.isActive());
            stmt.setLong(4, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Cannot update user", e);
        }

    }

    public List<User> findAll() {
        List<User> user = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                User user1 = new User();
                user1.setId(resultSet.getLong("id"));
                user1.setUsername(resultSet.getString("username"));
                user1.setPassword(resultSet.getString("password"));
                user1.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
                user1.setActive(resultSet.getBoolean("active"));
                user.add(user1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find user", e);
        }
        return user;
    }

    public Long insert(User user) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password, created_date, active) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setDate(3, Date.valueOf(LocalDate.now()));
            stmt.setBoolean(4, user.isActive());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            Long id = 0L;
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find user", e);
        }
    }

    public void delete(Long id) throws SQLException {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM users u where u.id = ?")) {
            try {
                conn.setAutoCommit(false);
                stmt.setLong(1, id);
                deleteUserLinks(id);
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Cannot delete user", e);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    private void deleteUserLinks(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement updateCoursesLinks = conn.prepareStatement("update courses c set teacher_id = null where c.teacher_id = ?");
             PreparedStatement deleteCoursesLinks = conn.prepareStatement("delete from users_courses_links where user_id = ?");
             PreparedStatement deleteRolesLinks = conn.prepareStatement("delete from users_roles_links where user_id = ?")) {
            updateCoursesLinks.setLong(1, id);
            deleteCoursesLinks.setLong(1, id);
            deleteRolesLinks.setLong(1, id);

            updateCoursesLinks.executeUpdate();
            deleteCoursesLinks.executeUpdate();
            deleteRolesLinks.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot update user", e);
        }
    }

}

//    Long id, String username, String password, LocalDate createdDate,Boolean active
