package kz.aitu.cinemasystem.orders.repositories;

import kz.aitu.cinemasystem.records.Session;

import java.util.List;

public interface SessionRepositories {
    boolean createSession(Session session);
    boolean deleteSession(int ID);

    boolean deleteCinemaTheater(int ID);
    boolean deleteAllSessionByMovie(int ID);
    boolean deleteAllSessionByHall(int ID);

    boolean decreaseAllPrice(int ID);
    boolean increaseAllPrice(int ID);
    boolean decreaseOnePrice(int ID, int price);
    boolean increaseOnePrice(int ID, int price);

    boolean deleteAllSessionByEqualPrice(int price);
    boolean deleteAllSessionByMorePrice(int price);
    boolean deleteAllSessionByLessPrice(int price);
}
