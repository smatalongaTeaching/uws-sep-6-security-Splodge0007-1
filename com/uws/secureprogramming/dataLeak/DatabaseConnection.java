package com.uws.secureprogramming.dataLeak;

public class DatabaseConnection {
    private UserDatabase userDatabase;

    public DatabaseConnection(UserDatabase users) {
        userDatabase = users;
    }


    public void connectToDatabase(String username, String password) {
        try {
            // Simulating database connection
            
            if (username == null || password == null) {
                throw new IllegalArgumentException("Invalid input: Please review your username and password and try again");
            }

            if (!this.userDatabase.AcceptUserLogin(username, password)) {
                throw new IllegalArgumentException("Authentication failed: Please review your username and password and try again");
            }
            System.out.println("Connected successfully to database as " + username);
        } catch (IllegalArgumentException e) {
            if (username != null && username.equals("admin")) {
                LoggerUtil.warning("Failed login attempt for admin user. " + e.getMessage());
            } else {
                LoggerUtil.info("Generic login failure for user: " + username + ". " + e.getMessage());
            }
            // Vulnerable error handling
            throw e; 
        }
    }
}
