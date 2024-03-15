package org.example;
import java.util.*;
import java.sql.*;

public class UsersRepository {

    private static final String URL = "jdbc:postgresql://localhost:5433/Phone";

    String query = "SELECT user_id, name, secname, phonenumber, username FROM users";

    private static Map<Integer, User> users = new HashMap();

    public Collection<User> listUsers() {

        List<User> userList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, "postgres", "6351");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String secname = resultSet.getString("secname");
                String phonenumber = resultSet.getString("phonenumber");
                String username = resultSet.getString("username");
                User user = new User();
                user.id = id;
                user.name = name;
                user.secName = secname;
                user.PhoneNumber = phonenumber;
                user.UserName = username;
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void addUser(User user) {

        final String SQL_INSERT = "INSERT INTO users (name, secname, phonenumber, username) VALUES (?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/Phone", "postgres", "6351");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, user.name);
            preparedStatement.setString(2, user.secName);
            preparedStatement.setString(3, user.PhoneNumber);
            preparedStatement.setString(4, user.UserName);


            int row = preparedStatement.executeUpdate();

            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User user){

        final String SQL_UPDATE = "UPDATE users SET name = ?, secname = ?, phonenumber = ?, username = ? WHERE user_id = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/Phone", "postgres", "6351");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

            preparedStatement.setString(1, user.name);
            preparedStatement.setString(2, user.secName);
            preparedStatement.setString(3, user.PhoneNumber);
            preparedStatement.setString(4, user.UserName);
            preparedStatement.setInt(5, user.id);

            int row = preparedStatement.executeUpdate();

            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public void deleteUser(int id){
        final String SQL_DELETE = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/Phone", "postgres", "6351");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();

            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}