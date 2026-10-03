package com.iostream.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iostream.main.entity.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a user
    public void insertUser(User user) {
        try {
            String sql = "INSERT INTO users (id, name, email, city) VALUES (?, ?, ?, ?)";
            int i = jdbcTemplate.update(
                sql,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCity()
            );

            if (i > 0) {
                System.out.println("Insert Successfully");
            } else {
                System.out.println("Insert Failed");
            }

        } catch (Exception e) {
            System.out.println("Insert Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update a user by ID
    public void updateUser(User user) {
        try {
            String sql = "UPDATE users SET name = ?, email = ?, city = ? WHERE id = ?";
            int i = jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmail(),
                user.getCity(),
                user.getId()
            );

            if (i > 0) {
                System.out.println("Update Successfully");
            } else {
                System.out.println("Update Failed: No user found with id=" + user.getId());
            }

        } catch (Exception e) {
            System.out.println("Update Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //delete user
    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            int i = jdbcTemplate.update(sql, id);

            if (i > 0) {
                System.out.println("Delete Successfully");
            } else {
                System.out.println("Delete Failed: No user found with id=" + id);
            }

        } catch (Exception e) {
            System.out.println("Delete Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }



    // Select user data by email
    public User getUser(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(
                sql,
                new Object[]{email},
                new UserRowMapper()
            );
        } catch (Exception e) {
            System.out.println("Get User Failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // RowMapper implementation
    public static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setCity(rs.getString("city"));
            return user;
        }
    }
}
