package kz.aitu.cinemasystem;

import kz.aitu.cinemasystem.connection.DConnection;
import kz.aitu.cinemasystem.connection.DInterface.DInteface;
import kz.aitu.cinemasystem.controls.*;
import kz.aitu.cinemasystem.orders.*;
import kz.aitu.cinemasystem.orders.repositories.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DInteface db = new DConnection();

        SessionRepositories sessionRepositories = new SessionOrder(db);
        SessionControls sessionControls = new SessionControls(sessionRepositories);

        CinemaRepositories cinemaRepositories = new CinemaOrders(db);
        CinemaControls cinemaControls = new CinemaControls(cinemaRepositories);

        FilmRepositories filmRepositories = new FilmOrder(db);
        FIlmControls fIlmControls = new FIlmControls(filmRepositories);

        AdminRepositories adminRepositories = new AdminOrder(db);
        AdminControls adminControls = new AdminControls(adminRepositories);

        ClientRepositories clientRepositories = new ClientOrder(db);
        ClientControls clientControls = new ClientControls(clientRepositories, fIlmControls);

        Application app = new Application(sessionControls, adminControls, fIlmControls, cinemaControls, clientControls);
        app.start();
    }
}
