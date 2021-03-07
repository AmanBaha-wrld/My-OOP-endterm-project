package kz.aitu.cinemasystem;

import kz.aitu.cinemasystem.connection.DConnection;
import kz.aitu.cinemasystem.connection.DInterface.DInteface;

public class main {
    public static void main(String[] args) {
        DInteface db = new DConnection();
    }
}
