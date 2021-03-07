package kz.aitu.cinemasystem.records;

import java.sql.Time;

public class Admin {
    private String login;
    private String password;
    public Admin(){

    }
    public Admin(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public void setLogin(String login){this.login = login;}
    public void setPassword(String password){this.password = password;}
    public String getTitle() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
