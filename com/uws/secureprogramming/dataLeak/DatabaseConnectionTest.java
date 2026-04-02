package com.uws.secureprogramming.dataLeak;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

    private UserDatabase userDatabase;
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        userDatabase = new UserDatabase();
        // Add example users (Disney characters)
        userDatabase.addUser(new User("mickey", "mm@disney.com",	 "mouse123"));
        userDatabase.addUser(new User("donald", "dd@disney.com", "duck456"));
        userDatabase.addUser(new User("goofy", "goof@disney.com", "good123"));
        userDatabase.addUser(new User("minnie", "mm01@disney.com", "minnie321"));
        userDatabase.addUser(new User("admin", "admin@disney.com", "secr3tP@ss"));
        dbConnection = new DatabaseConnection(userDatabase);
    }

    
    @Test
    void testConnectWithNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            dbConnection.connectToDatabase(null, "password");
        });
    }

    @Test
    void testConnectWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            dbConnection.connectToDatabase("mickey", null);
        });
    }

    @Test
    void testUserNotFoundOrIncorrectPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            dbConnection.connectToDatabase("pluto", "dog123");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dbConnection.connectToDatabase("donald", "wrongpass");
        });
    }

    @Test
    void testSuccessfulConnection() {
        assertDoesNotThrow(() -> {
            dbConnection.connectToDatabase("goofy", "good123");
        });
        assertDoesNotThrow(() -> {
            dbConnection.connectToDatabase("minnie", "minnie321");
        });
    }

    @Test
    void testAdminConnectionWithIncorrectPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            dbConnection.connectToDatabase("admin", "wrongpass");
        });
    }

    @Test
    void testAdminConnectionWithCorrectPassword() {
        assertDoesNotThrow(() -> {
            dbConnection.connectToDatabase("admin", "secr3tP@ss");
        });
    }

}