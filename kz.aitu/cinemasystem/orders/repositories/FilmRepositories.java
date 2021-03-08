package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Film;

import java.sql.Time;
import java.util.List;

public interface FilmRepositories {
    boolean deleteMovie(int ID);
    boolean addMovie(String title, Time duration);
    List<Film> getAllMovies();
}
