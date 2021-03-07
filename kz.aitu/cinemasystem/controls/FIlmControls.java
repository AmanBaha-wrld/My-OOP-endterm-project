package kz.aitu.cinemasystem.controls;

import kz.aitu.cinemasystem.orders.repositories.FilmRepositories;
import kz.aitu.cinemasystem.records.Film;

import java.sql.Time;

public class FIlmControls {
    private final FilmRepositories repo;

    public FIlmControls(FilmRepositories repo){this.repo=repo;}


    public String deleteMovie(int ID){
        boolean deleted = repo.deleteMovie(ID);
        return (deleted ? "Successfully deleted!" : "Please enter the correct data!");
    }
    public String addMovie(String title, Time duration){
        boolean add = repo.addMovie(title, duration);
        return (add ? "Successfully added!" : "Please enter the correct data!");
    }

}
