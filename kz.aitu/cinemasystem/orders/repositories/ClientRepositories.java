package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Client;

import java.util.List;

public interface ClientRepositories {
    boolean getAllSessionByTitle(String title);
    boolean getAllSessionByTitleBoolean(String title);
    boolean getAllSessionByCinema(String title);
    List<Client> getAllSession();
}
