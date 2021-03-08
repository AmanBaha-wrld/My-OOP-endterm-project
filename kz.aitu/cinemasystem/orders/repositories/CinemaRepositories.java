package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Cinema;

import java.util.List;

public interface CinemaRepositories {
    boolean addCinemaTheater(Cinema cinema);
    boolean deleteCinemaTheater(int ID);
    List<Cinema> getAllMovies();
}
