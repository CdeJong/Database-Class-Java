package com.cdejong;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    /**
     * Get all users from the database.
     * @return A List of users
     */

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        Database database = new Database();

        ResultSet resultSet = database.executeQuery("SELECT * FROM users", null);

        try {
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("user_ID"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }

    /**
     * Create a new user.
     * @param user from User class.
     */
    public static void createUser(User user) {
        Database database = new Database();

        List<Object> params = new ArrayList<>();
        params.add(user.getFirstname());
        params.add(user.getLastname());
        params.add(user.getEmail());

        database.executeUpdate("INSERT INTO users (firstname, lastname, email) VALUES ( ?, ?, ?)", params);

    }

}
