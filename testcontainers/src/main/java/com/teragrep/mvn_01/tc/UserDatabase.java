package com.teragrep.mvn_01.tc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

public class UserDatabase {
    private final Connection connection;
    public UserDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<String> getUsers() throws SQLException {
        List<String> users = new LinkedList<>();
        ResultSet usersResultSet = connection.prepareStatement("SELECT * FROM users").executeQuery();
        while(usersResultSet.next()) {
            users.add(usersResultSet.getString("name"));
        }
        return users;
    }

    public void addUser(String user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name) VALUES (?)");
        preparedStatement.setString(1, user);
        preparedStatement.execute();
    }
}