package edu.trinity.security;

import org.h2.Driver;

import java.sql.*;

@SuppressWarnings("SqlResolve")
public class SqlInjectionExample {
    private static Connection connection;

    public SqlInjectionExample() {
        try {
            Class.forName(Driver.class.getName());
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            System.out.println(connection.getClass().getName());
            setupDatabase(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users;");
            statement.executeUpdate("CREATE TABLE users (username VARCHAR(255), password VARCHAR(255));");
            statement.executeUpdate("INSERT INTO users VALUES ('admin', 'pass123');");
        }
    }

    @SuppressWarnings("SqlSourceToSinkFlow")
    public boolean login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username='" + username +
                     "' AND password='" + password + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }

//        String sql = "SELECT * FROM users WHERE username=? AND password=?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return resultSet.next();
//        }
    }
}
