package kz.aitu.cinemasystem.controls;

import kz.aitu.cinemasystem.orders.repositories.CinemaRepositories;
import kz.aitu.cinemasystem.records.Cinema;

public class CinemaControls {
    private final CinemaRepositories repo;

    public CinemaControls(CinemaRepositories repo){this.repo=repo;}

    public String addCinemaTheater(String title, String addres){
        Cinema cinema = new Cinema(title, addres);
        boolean created = repo.addCinemaTheater(cinema);
        return (created ? "The cinema created!" : "Please enter the correct data! ");
    }
    public String deleteCinemaTheater(int ID){
        boolean created = repo.deleteCinemaTheater(ID);
        return (created ? "The cinema deleted!" : "Please enter the correct data! ");
    }
}
