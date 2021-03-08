package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.FilmRepositories;
import kz.aitu.cinemasystem.records.Client;
import kz.aitu.cinemasystem.records.Film;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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
            String sql = "INSERT INTO film(title, duration) VALUES(?,?)";
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
    @Override
    public List<Film> getAllMovies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM film";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Film> filmList = new LinkedList<>();
            while(rs.next()){
                Film film = new Film(rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getTime("duration")
                );

                filmList.add(film);
            }
            return filmList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
