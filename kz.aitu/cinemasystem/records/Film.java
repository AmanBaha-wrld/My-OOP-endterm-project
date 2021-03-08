package kz.aitu.cinemasystem.records;

import java.sql.Time;

public class Film {
    private int film_id;
    private String title;
    private Time duration;
    public Film(){

    }
    public Film(String title, Time duration){
        setTitle(title);
        setDuration(duration);
    }
    public Film(int film_id, String title, Time duration){
        setFilm_id(film_id);
        setTitle(title);
        setDuration(duration);
    }


    public void setFilm_id(int film_id){this.film_id = film_id;}
    public void setTitle(String title){this.title = title;}
    public void setDuration(Time duration){this.duration=duration;}

    public int getFilm_id() {
        return film_id;
    }
    public Time getDuration(){return  duration;}
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Film: {" +
                "Film ID = " + film_id + "\n" +
                "Title = " + title + "\n" +
                "Duration = '" + duration + "'\n" +
                "}";
    }

}
