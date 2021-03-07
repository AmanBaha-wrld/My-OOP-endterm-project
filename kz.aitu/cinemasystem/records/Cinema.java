package kz.aitu.cinemasystem.records;

import java.sql.Time;

public class Cinema {
    private int cinema_id;
    private String title;
    private String addres;
    public Cinema(){

    }
    public Cinema(String title, String addres){
        setTitle(title);
        setAddres(addres);
    }
    public Cinema(int cinema_id, String title, String addres){
        setCinema_id(cinema_id);
        setTitle(title);
        setAddres(addres);
    }

    public void setCinema_id(int cinema_id){this.cinema_id = cinema_id;}
    public void setTitle(String title){this.title = title;}
    public void setAddres(String addres){this.addres=addres;}



    public int getCinema_id() {
        return cinema_id;
    }
    public String getAddres(){return  addres;}
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Cinema: {" +
                "Cinema ID = " + cinema_id + "\n" +
                "Title = '" + title + "'\n" +
                "Addres = '" + addres + "'\n" +
                "}";
    }
}
