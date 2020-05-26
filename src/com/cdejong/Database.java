package com.cdejong;

import java.sql.*;
import java.util.List;

public class Database {
    private Connection conn;
    private boolean isConnected;

    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * Tries to connect to database.
     */
    public Database() {
        try {
            conn = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf8", DB_HOST, DB_PORT, DB_NAME), DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        setConnected(true);
    }

    /**
     * Tries to fetch data from database.
     * @param query SQL String.
     * @param params for PreparedStatements.
     * @return A ResultSet of the queried data.
     */
    public ResultSet executeQuery(String query, List<Object> params) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;

        if (!isConnected()) return null;

        try {
            preparedStatement = conn.prepareStatement(query);

            if (params != null) {

                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }

            resultSet = preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Tries to manipulate data in the database.
     * @param query SQL String.
     * @param params for PreparedStatements.
     */
    public void executeUpdate(String query, List<Object> params) {
        PreparedStatement preparedStatement;

        if (!isConnected()) return;

        try {
            preparedStatement = conn.prepareStatement(query);

            if (params != null) {

                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }

            int rowsManipulated = preparedStatement.executeUpdate();

            System.out.println("Updated rows: " + rowsManipulated);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public boolean isConnected() {
        return isConnected;
    }

    private void setConnected(boolean connected) {
        isConnected = connected;
    }


}
