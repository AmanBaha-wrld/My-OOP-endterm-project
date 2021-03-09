package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Client;

import java.sql.Time;
import java.util.List;

public interface ClientRepositories {
    boolean getAllSessionByTitle(String title);
    boolean getAllSessionByTitleBoolean(String title);
    boolean getAllSessionByCinema(String title);
    List<Client> getAllSession();
    List<Client> getTime(String title, Time s_time, Time f_time);
    String selectSession(int ID);
}
