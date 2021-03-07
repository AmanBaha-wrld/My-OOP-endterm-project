package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.CinemaRepositories;
import kz.aitu.cinemasystem.records.Cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
