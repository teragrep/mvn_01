package com.teragrep.mvn_01.tc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

public class UserDatabaseTest {

    private MariaDBContainer<?> mariadb;
    private Connection connection;

    @BeforeEach
    public void setup() {
        mariadb = Assertions
                .assertDoesNotThrow(
                        () -> new MariaDBContainer<>(DockerImageName.parse("mariadb:10.5"))
                                .withPrivilegedMode(false)
                                .withUsername("user")
                                .withPassword("p4ssw0rd")
                                .withDatabaseName("example")
                );
        mariadb.start();
        connection = Assertions
                .assertDoesNotThrow(
                        () -> DriverManager
                                .getConnection(
                                        mariadb.getJdbcUrl(),
                                        mariadb.getUsername(),
                                        mariadb.getPassword()
                                )
                );

        Assertions.assertDoesNotThrow(() -> connection.prepareStatement("CREATE TABLE users (id INT AUTO_INCREMENT NOT NULL, name varchar(255), primary key (id))").execute());
    }

    @AfterEach
    public void tearDown() {
        Assertions.assertDoesNotThrow(() -> connection.prepareStatement("DROP TABLE users").execute());
        mariadb.stop();
    }

    @Test
    public void testAddUser(){
        UserDatabase userDatabase = new UserDatabase(connection);
        // Must be empty
        Assertions.assertEquals(0, (Assertions.assertDoesNotThrow(() -> userDatabase.getUsers())).size());

        Assertions.assertDoesNotThrow(() -> userDatabase.addUser("FirstUser"));
        // Must have just one user
        Assertions.assertEquals(1, (Assertions.assertDoesNotThrow(() -> userDatabase.getUsers()).size()));

        // Must have two users in right spots as well
        Assertions.assertDoesNotThrow(() -> userDatabase.addUser("SecondUser"));
        List<String> userList = Assertions.assertDoesNotThrow(() -> userDatabase.getUsers());
        Assertions.assertEquals(2, userList.size());
        Assertions.assertEquals("FirstUser", userList.get(0));
        Assertions.assertEquals("SecondUser", userList.get(1));
    }
}
