package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.AdminRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminOrder implements AdminRepositories {

    private final DInteface db;
    public AdminOrder(DInteface db) {
        this.db = db;
    }
    @Override
    public boolean checkPassword(String login, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM admins WHERE login=? AND password=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,login);
            st.setString(1,password);
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
    public boolean addAddmin(String login, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO admins(login, password) VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,login);
            st.setString(1,password);
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
