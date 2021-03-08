package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.CinemaRepositories;
import kz.aitu.cinemasystem.records.Cinema;
import kz.aitu.cinemasystem.records.Film;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CinemaOrders implements CinemaRepositories {
    private final DInteface db;
    public CinemaOrders(DInteface db) {
        this.db = db;
    }

    @Override
    public boolean addCinemaTheater(Cinema cinema) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO cinema(title, addres) VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, cinema.getTitle());
            st.setString(2, cinema.getAddres());
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
    public boolean deleteCinemaTheater(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM cinema WHERE cinema_id=?";
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
    public List<Cinema> getAllMovies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cinema";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Cinema> cinemaList = new LinkedList<>();
            while(rs.next()){
                Cinema cinema = new Cinema(rs.getInt("cinema_id"),
                        rs.getString("title"),
                        rs.getString("addres")
                );

                cinemaList.add(cinema);
            }
            return cinemaList;
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
