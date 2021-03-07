package kz.aitu.cinemasystem.connection.DInterface;

import java.sql.Connection;
import java.sql.SQLException;


public interface DInteface {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
