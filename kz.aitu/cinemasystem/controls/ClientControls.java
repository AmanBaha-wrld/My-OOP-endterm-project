package kz.aitu.cinemasystem.controls;

import kz.aitu.cinemasystem.orders.repositories.ClientRepositories;
import kz.aitu.cinemasystem.records.Client;
import kz.aitu.cinemasystem.controls.FIlmControls;

import java.sql.Time;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientControls {
    private Scanner scanner;
    private final ClientRepositories repo;
    private final FIlmControls fIlmControls;

    public ClientControls(ClientRepositories repo, FIlmControls fIlmControls){
        this.repo=repo;
        this.fIlmControls = fIlmControls;
        scanner = new Scanner(System.in);
    }

    public String getAllSessionByTitle(String title){
        boolean clients = repo.getAllSessionByTitle(title);
        return (clients ? "" : "Please enter the correct data!");
    }
    public boolean getAllSessionByTitleBoolean(String title){
        boolean clients = repo.getAllSessionByTitleBoolean(title);
        return clients;
    }
    public String getAllSessionByCinema(String title){
        boolean clients = repo.getAllSessionByCinema(title);
        return (clients ? "" : "Please enter the correct data!");
    }
    public String getAllSession(){
        List<Client> clients = repo.getAllSession();
        return clients.toString();
    }
    public String buyTicket() {
        String buy="buy";
        boolean prime=true;
        while(prime==true){
            System.out.println("Please select your option");
            System.out.println("1. Enter the name of the movie");
            System.out.println("2. Display a list of movies");
            int option = scanner.nextInt();
            if (option==1){
                System.out.println("Please enter a Title of Movie");
                String title = scanner.next();
                boolean response = getAllSessionByTitleBoolean(title);
                if(response==true){
                    String Time = getFromTime(title);
                    System.out.println(Time);
                }
                else {
                    System.out.println("You entered the wrong value!");
                }
            }
            else if (option==2){
                String response = fIlmControls.getAllMovies();
                System.out.println(response);
            }
        }
        return buy;
    }
    public String getFromTime(String title){
        String buy="buy";
        boolean prime=true;
        System.out.println("Please select your option");
        System.out.println("1. Enter a convenient time");
        System.out.println("2. Display the entire list of sessions of this movie");
        int option = scanner.nextInt();
        if(option ==1){
            Time s_time;
            Time f_time;
            while (prime){
                System.out.println("Enter the start time");
                s_time= Time.valueOf(scanner.next());
                System.out.println("Enter the finish time");
                f_time= Time.valueOf(scanner.next());
                if(f_time.compareTo(s_time)>0){
                    System.out.println("f_time.compareTo(s_time)>0"); // правильное
                    String getTime = getTime(s_time, f_time);
                    System.out.println(getTime);
                    prime=false;
                }
                else
                    System.out.println("Please enter a correct Time!");
            }
        }
        else if(option == 2){
            String response = getAllSessionByTitle(title);
            System.out.println(response);
            System.out.println("Please enter a Session ID"); //сделать проверку session ID
            int ID = scanner.nextInt();
            String price = getPrice(ID);
            System.out.println(price);
        }
    return buy;
    }
    public String getTime(Time s_time, Time f_time){
        String buy="buy";
        boolean prime=true;
        
        return buy;
    }
    public String getPrice(int ID){
        String buy="buy";
        boolean prime=true;
        while(prime){

        }
        return buy;
    }

}
