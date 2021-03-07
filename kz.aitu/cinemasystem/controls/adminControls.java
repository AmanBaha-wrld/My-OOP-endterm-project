package kz.aitu.cinemasystem.controls;

import kz.aitu.cinemasystem.orders.repositories.AdminRepositories;
import kz.aitu.cinemasystem.records.Admin;

public class adminControls {
    private final AdminRepositories repo;

    public adminControls(AdminRepositories repo){this.repo=repo;}

    public boolean checkPassword(String login, String password){
        boolean checkPassword = repo.checkPassword(login, password);
        return checkPassword;
    }
    public String addNewAddmin(String login, String password){
        boolean addAdmin = repo.addAddmin(login, password);
        return (addAdmin ? "Successfully added!" : "Please enter the correct data!");
    }
}
