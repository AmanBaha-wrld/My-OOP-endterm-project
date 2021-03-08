package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.orders.repositories.ClientRepositories;
import kz.aitu.cinemasystem.records.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClientOrder implements ClientRepositories {
    private final DInteface db;
    public ClientOrder(DInteface db) {
        this.db = db;
    }

    @Override
    public boolean getAllSessionByTitle(String title) {
        Connection con = null;
        boolean prime=false;
        try {
            con = db.getConnection();
            String sql = "SELECT f_session.session_id, film.title, cinema.title, cinema.addres, f_session.s_time, f_session.f_time, f_session.price, f_session.hall_id\n" +
                    "FROM f_session\n" +
                    "JOIN film\n" +
                    "ON film.title=?\n" +
                    "JOIN cinema\n" +
                    "ON cinema.cinema_id=f_session.cinema_id;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,title);
            st.execute();
            ResultSet rs = st.executeQuery();
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("session_id"),
                        rs.getString("title"),
                        rs.getString("title"),
                        rs.getString("addres"),
                        rs.getTime("s_time"),
                        rs.getTime("f_time"),
                        rs.getInt("price"),
                        rs.getInt("hall_id")
                );
                prime=true;
                clients.add(client);
            }
            if(prime)
                System.out.println(clients.toString());
            return prime;
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
        return prime;
    }
    @Override
    public boolean  getAllSessionByCinema(String title) {
        Connection con = null;
        boolean prime=false;
        try {
            con = db.getConnection();
            String sql = "SELECT f_session.session_id, film.title, cinema.title, cinema.addres, f_session.s_time, f_session.f_time, f_session.price, f_session.hall_id\n" +
                    "FROM f_session\n" +
                    "JOIN cinema\n" +
                    "ON cinema.title=?\n" +
                    "JOIN film\n" +
                    "ON film.film_id=f_session.film_id;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,title);
            st.execute();
            ResultSet rs = st.executeQuery();
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("session_id"),
                        rs.getString("title"),
                        rs.getString("title"),
                        rs.getString("addres"),
                        rs.getTime("s_time"),
                        rs.getTime("f_time"),
                        rs.getInt("price"),
                        rs.getInt("hall_id")
                );
                prime=true;
                clients.add(client);
            }
            if(prime)
                System.out.println(clients.toString());
            return prime;
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
        return prime;
    }
    @Override
    public List<Client>  getAllSession() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT f_session.session_id, film.title, cinema.title, cinema.addres, f_session.s_time, f_session.f_time, f_session.price, f_session.hall_id\n" +
                    "FROM f_session \n" +
                    "JOIN cinema\n" +
                    "ON cinema.cinema_id=f_session.cinema_id\n" +
                    "JOIN film\n" +
                    "ON film.film_id=f_session.film_id;";
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            ResultSet rs = st.executeQuery();
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("session_id"),
                        rs.getString("title"),
                        rs.getString("title"),
                        rs.getString("addres"),
                        rs.getTime("s_time"),
                        rs.getTime("f_time"),
                        rs.getInt("price"),
                        rs.getInt("hall_id")
                );
                clients.add(client);
            }
            return clients;
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
    @Override
    public boolean getAllSessionByTitleBoolean(String title) {
        Connection con = null;
        boolean prime=false;
        try {
            con = db.getConnection();
            String sql = "SELECT f_session.session_id, film.title, cinema.title, cinema.addres, f_session.s_time, f_session.f_time, f_session.price, f_session.hall_id\n" +
                    "FROM f_session\n" +
                    "JOIN film\n" +
                    "ON film.title=?\n" +
                    "JOIN cinema\n" +
                    "ON cinema.cinema_id=f_session.cinema_id;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,title);
            st.execute();
            ResultSet rs = st.executeQuery();
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("session_id"),
                        rs.getString("title"),
                        rs.getString("title"),
                        rs.getString("addres"),
                        rs.getTime("s_time"),
                        rs.getTime("f_time"),
                        rs.getInt("price"),
                        rs.getInt("hall_id")
                );
                prime=true;
            }
            return prime;
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
        return prime;
    }
}
