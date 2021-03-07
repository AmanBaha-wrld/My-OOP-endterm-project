package kz.aitu.cinemasystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;

public class DConnection implements DInteface {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/cinema_app"; //it is our connection
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "abc123");
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
