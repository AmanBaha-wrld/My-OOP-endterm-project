package kz.aitu.cinemasystem.orders;

import kz.aitu.cinemasystem.orders.repositories.SessionRepositories;
import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.records.Session;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SessionOrder implements SessionRepositories {
    private final DInteface db;
    public SessionOrder(DInteface db) {
        this.db = db;
    }

    @Override
    public boolean createSession(Session session) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO f_session(film_id, hall_id, cinema_id, price, s_time, f_time) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,session.getFilm_id());
            st.setInt(2, session.getHall_id());
            st.setInt(3, session.getCinema_id());
            st.setInt(4,  session.getPrice());
            st.setTime(5, session.getS_time());
            st.setTime(6, session.getF_time());
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
    public boolean deleteSession(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE session_id=?";
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
    public boolean decreaseOnePrice(int ID, int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE f_session SET price = price-? WHERE session_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
            st.setInt(2,ID);
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
    public boolean decreaseAllPrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE f_session SET price = price-?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
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
    public boolean increaseOnePrice(int ID, int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE f_session SET price = price+? WHERE session_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
            st.setInt(2,ID);
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
    public boolean increaseAllPrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE f_session SET price = price+?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
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
            String sql = "DELETE FROM f_session WHERE cinema_id = ?";
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
    public boolean deleteAllSessionByMovie(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE film_id = ?";
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
    public boolean deleteAllSessionByHall(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE hall_id = ?";
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
    public boolean deleteAllSessionByEqualPrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE price=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
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
    public boolean deleteAllSessionByMorePrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE price>?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
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
    public boolean deleteAllSessionByLessPrice(int price) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM f_session WHERE price<?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,price);
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
