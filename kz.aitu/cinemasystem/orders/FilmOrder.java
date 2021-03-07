package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.FilmRepositories;
import kz.aitu.cinemasystem.records.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class FilmOrder implements FilmRepositories {
    private final DInteface db;
    public FilmOrder(DInteface db) {
        this.db = db;
    }

    @Override
    public boolean addMovie(String title, Time duration) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO film(title, addres) VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, title);
            st.setTime(2, duration);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean deleteMovie(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM film WHERE film_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,ID);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
