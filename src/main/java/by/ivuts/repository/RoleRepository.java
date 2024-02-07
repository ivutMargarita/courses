package by.ivuts.repository;

import by.ivuts.model.Role;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private final DataSource dataSource;

    public RoleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Role findById(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM roles c where c.id=?")) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Role role = new Role();
            while (resultSet.next()) {
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
            }
            return role;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find role", e);
        }
    }

    public void update(Role role) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("update roles set name = ? where id= ?")) {
            stmt.setString(1, role.getName());
            stmt.setLong(2, role.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot update user", e);
        }
    }

    public List<Role> findAll() {
        List<Role> role = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM roles")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Role role1 = new Role();
                role1.setId(resultSet.getLong("id"));
                role1.setName(resultSet.getString("name"));
                role.add(role1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find role", e);
        }
        return role;
    }

    public Long insert(Role role) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO roles (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, role.getName());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            Long id = 0L;
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot insert role", e);
        }
    }

    public void delete(Long id) throws SQLException {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM roles r where r.id = ?")) {
            try {
                conn.setAutoCommit(false);
                stmt.setLong(1, id);
                deleteRoleLinks(id);
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Cannot delete role", e);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    private void deleteRoleLinks(Long id) {
        try (Connection conn = dataSource.getConnection();//ресурсы для запроса
             PreparedStatement deleteRolesLinks = conn.prepareStatement("delete from users_roles_links where role_id = ?")) {
            deleteRolesLinks.setLong(1, id);
            deleteRolesLinks.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete role", e);
        }
    }

}
