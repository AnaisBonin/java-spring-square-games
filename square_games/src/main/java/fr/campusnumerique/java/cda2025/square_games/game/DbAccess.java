package fr.campusnumerique.java.cda2025.square_games.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
    private static DbAccess instance;
    private Connection connection;

    public static DbAccess getInstance() {
        if (instance == null) instance = new DbAccess();
        return instance;
    }

    private DbAccess() {}

    private final Logger LOGGER = LoggerFactory.getLogger(DbAccess.class);

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:6603/boardgames", "root", "helloworld");
                LOGGER.info("New connection to boardgames database");
            } catch (SQLException e) {
                LOGGER.error("Could not connect to database");
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

}
