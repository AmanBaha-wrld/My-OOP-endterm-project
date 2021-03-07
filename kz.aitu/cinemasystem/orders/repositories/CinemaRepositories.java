package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Cinema;

public interface CinemaRepositories {
    boolean addCinemaTheater(Cinema cinema);
    boolean deleteCinemaTheater(int ID);
}
