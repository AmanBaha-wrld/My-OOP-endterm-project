package kz.aitu.cinemasystem.records;

import java.sql.Time;

public class Session {
    private int film_id;
    private int hall_id;
    private int cinema_id;
    private int session_id;
    private int price;
    private Time s_time;
    private Time f_time;
    public Session(){

    }
    public Session(int film_id, int hall_id, int cinema_id, int price, Time s_time, Time f_time){
        setFilm_id(film_id);
        setHall_id(hall_id);
        setCinema_id(cinema_id);
        setPrice(price);
        setS_time(s_time);
        setF_time(f_time);
    }
    public Session(int film_id, int hall_id, int cinema_id, int session_id, int price, Time s_time, Time f_time){
        setFilm_id(film_id);
        setHall_id(hall_id);
        setCinema_id(cinema_id);
        setPrice(price);
        setS_time(s_time);
        setF_time(f_time);
        setSession_id(session_id);
    }

    public void setFilm_id(int film_id){this.film_id = film_id;}
    public void setHall_id(int hall_id){this.hall_id = hall_id;}
    public void setCinema_id(int cinema_id){this.cinema_id = cinema_id;}
    public void setSession_id(int session_id){this.session_id = session_id;}
    public void setPrice(int price){this.price = price;}
    public void setS_time(Time s_time){this.s_time=s_time;}
    public void setF_time(Time f_time){this.f_time=f_time;}


    public int getFilm_id() {
        return film_id;
    }
    public int getHall_id(){return hall_id;}
    public int getCinema_id(){return cinema_id;}
    public int getPrice(){return price;}
    public int getSession_id(){return session_id;}
    public Time getS_time(){return s_time;}
    public Time getF_time(){return  f_time;}


    @Override
    public String toString() {
        return "Sessions: {" +
                "Session ID = " + session_id + "\n" +
                "Film = '" + film_id + "'\n" +
                "Cinema = '" + cinema_id + "'\n" +
                "Hall = '" + hall_id + "'\n" +
                "Price '" + price + "'\n" +
                "Start Time = '" + s_time + "'\n" +
                "Finish Time = '" + f_time + "'\n" +
                "}";
    }
}
