package com.svlugovoy.clientjdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {

    Properties propdb;

    public DatabaseUtil() {
        loadProperties();
        try {
            Class.forName(propdb.getProperty("database.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    propdb.getProperty("database.url"),
                    propdb.getProperty("database.username"),
                    propdb.getProperty("database.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void loadProperties() {
        InputStream is;
        try {
            is = getClass().getResourceAsStream("/db/postgres.properties");
            propdb = new Properties();
            propdb.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
