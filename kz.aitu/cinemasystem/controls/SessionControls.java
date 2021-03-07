package kz.aitu.cinemasystem.controls;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import kz.aitu.cinemasystem.orders.repositories.SessionRepositories;
import kz.aitu.cinemasystem.records.Session;

public class SessionControls {
    private final SessionRepositories repo;

    public SessionControls(SessionRepositories repo){this.repo=repo;}

    public String increaseOnePrice(int ID, int price){
        boolean increasePrice = repo.increaseOnePrice(ID, price);
        return (increasePrice ? "Successfully increase!" : "Please enter the correct data!");
    }
    public String decreaseOnePrice(int ID, int price){
        boolean decreasePrice = repo.decreaseOnePrice(ID, price);
        return (decreasePrice ? "Successfully decrease!" : "Please enter the correct data!");
    }
    public String increaseAllPrice(int price){
        boolean increasePrice = repo.increaseAllPrice(price);
        return (increasePrice ? "Successfully increase!" : "Please enter the correct data!");
    }
    public String decreaseAllPrice(int price){
        boolean increasePrice = repo.decreaseAllPrice(price);
        return (increasePrice ? "Successfully decrease!" : "Please enter the correct data!");
    }
    public String deleteAllSessionByHall(int ID){
        boolean deleteSessionByHall = repo.deleteAllSessionByHall(ID);
        return (deleteSessionByHall ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String deleteAllSessionByMovie(int ID){
        boolean deleteSessionByMovie = repo.deleteAllSessionByMovie(ID);
        return (deleteSessionByMovie ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public boolean deleteCinemaTheater(int ID){
        boolean deleteCinemaTheater = repo.deleteCinemaTheater(ID);
        return deleteCinemaTheater;
    }
    public String deleteSession(int ID){
        boolean deleteSession = repo.deleteSession(ID);
        return (deleteSession ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String createSession(int film_id, int hall_id, int cinema_id, int price, Time s_time, Time f_time){
        Session session = new Session(film_id, hall_id, cinema_id, price, s_time, f_time);
        boolean created = repo.createSession(session);

        return (created ? "The session created!" : "Please enter the correct data! ");
    }
    public String deleteAllSessionByEqualPrice(int price){
        boolean deleteSessionByHall = repo.deleteAllSessionByEqualPrice(price);
        return (deleteSessionByHall ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String deleteAllSessionByMorePrice(int price){
        boolean deleteSessionByHall = repo.deleteAllSessionByMorePrice(price);
        return (deleteSessionByHall ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String deleteAllSessionByLessPrice(int price){
        boolean deleteSessionByHall = repo.deleteAllSessionByLessPrice(price);
        return (deleteSessionByHall ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String deleteAllSessionByCinemaTheater(int ID){
        boolean deleteCinemaTheater = repo.deleteCinemaTheater(ID);
        return (deleteCinemaTheater ? "Successfully deleted!" : "Please enter the correct data!");
    }

}
