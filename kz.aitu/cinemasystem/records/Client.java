package kz.aitu.cinemasystem.records;

import java.sql.Time;
import kz.aitu.cinemasystem.records.Cinema;
import kz.aitu.cinemasystem.records.Session;
import kz.aitu.cinemasystem.records.Film;
import kz.aitu.cinemasystem.records.Admin;
import kz.aitu.cinemasystem.records.Hall;

public class Client {
    private int session_id;
    private String film_title;
    private String cinema_title;
    private String addres;
    private Time s_time;
    private Time f_time;
    private int price;
    private int hall_id;
    public Client() {

    }

    public Client(int session_id, String film_title, String cinema_title, String addres, Time s_time, Time f_time, int price, int hall_id) {
        setSession_id(session_id);
        setFilm_title(film_title);
        setCinema_title(cinema_title);
        setAddres(addres);
        setS_time(s_time);
        setF_time(f_time);
        setPrice(price);
        setHall_id(hall_id);

    }

    public void setFilm_title(String film_title){this.film_title = film_title;}
    public void setCinema_title(String cinema_title){this.cinema_title = cinema_title;}
    public void setAddres(String addres){this.addres = addres;}

    public void setHall_id(int hall_id){this.hall_id = hall_id;}
    public void setSession_id(int session_id){this.session_id = session_id;}
    public void setPrice(int price){this.price = price;}
    public void setS_time(Time s_time){this.s_time=s_time;}
    public void setF_time(Time f_time){this.f_time=f_time;}


    public String getFilm_title(){return  film_title;}
    public String getCinema_title(){return  cinema_title;}
    public String getAddres(){return  addres;}
    public int getHall_id(){return hall_id;}
    public int getPrice(){return price;}
    public int getSession_id(){return session_id;}
    public Time getS_time(){return s_time;}
    public Time getF_time(){return  f_time;}

    @Override
    public String toString() {
        return "Film: {" +
                "Session ID = " + session_id + "\n" +
                "Title of Movie = " + film_title + "\n" +
                "Title of Cinema Theater  = " + cinema_title + "\n" +
                "Addres of Cinema Theater  = " + addres + "\n" +
                "Start Time  = '" + s_time + "'\n" +
                "Finish Time  = '" + f_time + "'\n" +
                "Price  = " + price + "\n" +
                "Hall ID  = " + hall_id + "\n" +
                "}";
    }
}
