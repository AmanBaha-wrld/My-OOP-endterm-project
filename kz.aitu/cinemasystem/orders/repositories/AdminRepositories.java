package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Admin;

public interface AdminRepositories {
    boolean checkPassword(String login, String password);
    boolean addAddmin(String login, String password);
}
