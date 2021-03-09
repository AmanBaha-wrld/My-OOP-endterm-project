package kz.aitu.cinemasystem.controls;

import kz.aitu.cinemasystem.orders.repositories.ClientRepositories;
import kz.aitu.cinemasystem.records.Client;

import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class ClientControls {
    private Scanner scanner;
    private final ClientRepositories repo;
    private final FIlmControls fIlmControls;
    private final SessionControls sessionControls;

    public ClientControls(ClientRepositories repo, FIlmControls fIlmControls, SessionControls sessionControls){
        this.repo=repo;
        this.fIlmControls = fIlmControls;
        this.sessionControls = sessionControls;
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

    public String titleOrList(){
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
                    return title;
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
        return null;
    }
    public String buyTicket() {
        String title = titleOrList();
        timeOrList(title);
        System.out.println("Please enter a Session ID");
        int ID = scanner.nextInt();
        int price = getPrice(ID);
        String select = ("You have selected a session: \n" + selectSession(ID));
        int generalPrice = getGeneralPrice(price);
        String stPrice = ("Total price: " + generalPrice);
        String total = (select + "\n" + stPrice);
        return total;
    }
    public String selectSession(int ID){
        String session = repo.selectSession(ID);
        return session.toString();
    }
    public void timeOrList(String title){
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
                    String getTime = getTime(title, s_time, f_time);
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
        }
    }
    public int getPrice(int ID){
        int price = sessionControls.getPrice(ID);
        return  price;
    }
    public String getTime(String title, Time s_time, Time f_time){
        List<Client> clients = repo.getTime(title, s_time, f_time);
        return clients.toString();
    }
    public int getGeneralPrice(int price){
        int generalPrice=0;
        System.out.println("How many of you are there?");
        int people = scanner.nextInt();
        if(people==1)
            System.out.println("Don't worry, you'll find someone to watch a movie with!");
        System.out.println("Choose discount: \n 1 - Without the discount \n 2 - Child (40%) \n 3 - Student (20%) \n 4 - Older person (20%)");
        for(int i=1; i<=people; i++){
            System.out.println("Choose discount for " + i);
            int discount = scanner.nextInt();
            if(discount==1){
                generalPrice+=price;
            }
            else if(discount==2){
                generalPrice+=price*0.6;
            }
            else if(discount==3){
                generalPrice+=price*0.8;
            }
            else if(discount==4){
                generalPrice+=price*0.8;
            }
            else if(discount>4){
                System.out.println("You have selected the wrong number, please enter it again.");
            }
        }
        return generalPrice;
    }

}
