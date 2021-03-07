package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Film;

import java.sql.Time;

public interface FilmRepositories {
    boolean deleteMovie(int ID);
    boolean addMovie(String title, Time duration);
}
