package kz.aitu.cinemasystem;

import kz.aitu.cinemasystem.controls.FIlmControls;
import kz.aitu.cinemasystem.controls.CinemaControls;
import kz.aitu.cinemasystem.controls.SessionControls;
import kz.aitu.cinemasystem.controls.AdminControls;
import kz.aitu.cinemasystem.controls.ClientControls;

import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private final SessionControls sessionControls;
    private final AdminControls adminControls;
    private final FIlmControls filmControls;
    private final CinemaControls cinemaControls;
    private final ClientControls clientControls;

    private final Scanner scanner;



    public Application(SessionControls sessionControls, AdminControls adminControls, FIlmControls filmControls, CinemaControls cinemaControls, ClientControls clientControls){ //it is concructor with controls
        this.sessionControls = sessionControls;
        this.adminControls = adminControls;
        this.filmControls = filmControls;
        this.cinemaControls = cinemaControls;
        this.clientControls = clientControls;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println("Welcome to Cinema system application");
            System.out.println("Select option: ");
            System.out.println("1. I am the Client");
            System.out.println("2. I am the Administrator");
            System.out.println("0. Exit");
            System.out.println();
            try { // it is for select option, and i wont repeat it
                System.out.println("Enter the option: (1-2)");
                int option = scanner.nextInt();
                // we input integer, and it is our option
                if(option == 1){
                    System.out.println("Select option: ");
                    System.out.println("1. Buy a ticket");
                    System.out.println("2. View all sessions");
                    System.out.println("3. View all sessions by movie");
                    System.out.println("4. View all sessions at the Movie theaters");
                    System.out.println("5. View the list of Movies");
                    System.out.println("6. View the list of Movie theaters");
                    System.out.println("0. Exit");
                    try {
                        System.out.println("Enter the option: (1-5)");
                        int option_for_m = scanner.nextInt();
                        if(option_for_m==1){
                            buyTicket(); // calling the method and i wont to repeat
                        }
                        else if(option_for_m ==2){
                            getAllSession();
                        }
                        else if(option_for_m == 3){
                            getAllSessionByTitle();
                        }
                        else if(option_for_m == 4){
                            getAllSessionByCinema();
                        }
                        else if(option_for_m == 5){
                            getAllMovies();
                        }
                        else if(option_for_m == 6){
                            getAllTheater();
                        }
                        else if(option_for_m == 0){
                            System.exit(0);
                        }
                        else{
                            break; // if our input data isnt 1-5 and 0, we just break
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be integer"); // if our input data isnt integer, we go out
                        scanner.nextLine();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(option ==2){
                    checkPassword();
                    while(checkPassword()==false){

                        checkPassword();
                    }
                    System.out.println("Welcome to the system.");

                    System.out.println("Select option: ");
                    System.out.println("1. Add session");
                    System.out.println("2. Delete session");
                    System.out.println("3. Add Cinema Theater");
                    System.out.println("4. Delete Cinema Theater");
                    System.out.println("5. Delete all session by Cinema Theater");
                    System.out.println("6. Add Movie");
                    System.out.println("7. Delete Movie");
                    System.out.println("8. Delete all session by Movie");
                    System.out.println("9. Delete all session by Price");
                    System.out.println("10. Increase the price for a single session");
                    System.out.println("11. Increase the price for a all session");
                    System.out.println("12. Reduce the price for a single session");
                    System.out.println("13. Reduce the price for a all session");
                    System.out.println("14. Delete all session by Hall");
                    System.out.println("15. Add a new admin");
                    System.out.println("0. Exit");
                    try {
                        System.out.println("Enter the option: (1-15)");
                        int option_for_manager = scanner.nextInt();
                        if(option_for_manager==1){
                            addSession();
                        }
                        else if(option_for_manager ==2){
                            deleteSession();
                        }
                        else if(option_for_manager == 3){
                            addCinemaTheater();
                        }
                        else if(option_for_manager == 4){
                            deleteCinemaTheater();
                        }
                        else if(option_for_manager == 5){
                            deleteAllSessionByCinemaTheater();
                        }
                        else if(option_for_manager == 6){
                            addMovie();
                        }
                        else if(option_for_manager == 7){
                            deleteMovie();
                        }
                        else if(option_for_manager == 8){
                            deleteAllSessionByMovie();
                        }
                        else if(option_for_manager == 9){
                            deleteAllSessionByPrice();
                        }
                        else if(option_for_manager == 10){
                            increaseOnePrice();
                        }
                        else if(option_for_manager == 11){
                            increaseAllPrice();
                        }
                        else if(option_for_manager == 12){
                            decreaseOnePrice();
                        }
                        else if(option_for_manager == 13) {
                            decreaseAllPrice();
                        }
                        else if(option_for_manager == 14){
                            deleteAllSessionByHall();
                        }
                        else if(option_for_manager == 15) {
                            addNewAdmin();
                        }
                        else if(option_for_manager == 0){
                            System. exit(0);
                        }
                        else{
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be integer");
                        scanner.nextLine();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(option == 0) { // if we input zero, we go out
                    System.exit(0);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkPassword(){
        System.out.println("Enter login");
        String login = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        boolean response = adminControls.checkPassword(login, password);
        if(response==false){
            System.out.println("You entered the wrong data!");
        }
        return response;
    }
    public void addNewAdmin(){
        System.out.println("Enter login");
        String login = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        String response = adminControls.addNewAddmin(login, password);
        System.out.println(response);
    }

    private void increaseOnePrice() {
        System.out.println("Please enter a session ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter how much you want to increase");
        int price = scanner.nextInt();
        String response = sessionControls.increaseOnePrice(ID, price);
        System.out.println(response);
    }
    private void increaseAllPrice() {
        System.out.println("Please enter how much you want to increase");
        int price = scanner.nextInt();
        String response = sessionControls.increaseAllPrice(price);
        System.out.println(response);
    }
    private void decreaseAllPrice() {
        System.out.println("Please enter how much you want to decrease");
        int price = scanner.nextInt();
        String response = sessionControls.decreaseAllPrice(price);
        System.out.println(response);
    }
    private void decreaseOnePrice() {
        System.out.println("Please enter a session ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter how much you want to decrease");
        int price = scanner.nextInt();
        String response = sessionControls.decreaseOnePrice(ID, price);;
        System.out.println(response);
    }
    private void deleteAllSessionByHall() {
        System.out.println("Please enter a Hall ID");
        int ID = scanner.nextInt();
        String response = sessionControls.deleteAllSessionByHall(ID);;
        System.out.println(response);
    }
    private void deleteAllSessionByMovie() {
        System.out.println("Please enter a Movie ID");
        int ID = scanner.nextInt();
        String response = sessionControls.deleteAllSessionByMovie(ID);;
        System.out.println(response);
    }
    private void deleteSession() {
        System.out.println("Enter a Session ID");
        int ID = scanner.nextInt();
        String response = sessionControls.deleteSession(ID);;
        System.out.println(response);
    }
    private void addSession() {
        System.out.println("Enter a film ID");
        int film_ID = scanner.nextInt();
        System.out.println("Enter a cinema ID");
        int cinema_ID = scanner.nextInt();
        System.out.println("Enter a hall ID");
        int hall_ID = scanner.nextInt();
        System.out.println("Enter a price");
        int price = scanner.nextInt();
        System.out.println("Enter a Start Time");
        Time s_time = Time.valueOf(scanner.next());
        System.out.println("Enter a Finish Time");
        Time f_time = Time.valueOf(scanner.next());
        String response = sessionControls.createSession(film_ID, hall_ID, cinema_ID, price, s_time, f_time);
        System.out.println(response);
    }

    private void deleteAllSessionByPrice() {
        while(true){
            System.out.println("Select option: ");
            System.out.println("1. Delete all sessions that are equal to the value ");
            System.out.println("2. Delete all sessions that are greater than the value");
            System.out.println("3. Delete all sessions that are less than the value");
            System.out.println("0. Exit");
            System.out.println();
            try { // it is for select option, and i wont repeat it
                System.out.println("Enter the option: (1-3)");
                int option = scanner.nextInt();
                // we input integer, and it is our option
                if(option == 1){
                    deleteAllSessionByEqualPrice();
                }
                else if(option == 3){
                    deleteAllSessionByMorePrice();
                }
                else if(option == 3){
                    deleteAllSessionByLessPrice();
                }
                else if(option == 0) { // if we input zero, we go out
                    System.exit(0);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    private void deleteAllSessionByEqualPrice(){
        System.out.println("Enter the price");
        int price = scanner.nextInt();
        String response_for_deleted = sessionControls.deleteAllSessionByEqualPrice(price); //cinemaTheatercontrols
        System.out.println(response_for_deleted);
    }
    private void deleteAllSessionByMorePrice(){
        System.out.println("Enter the price");
        int price = scanner.nextInt();
        String response_for_deleted = sessionControls.deleteAllSessionByMorePrice(price); //cinemaTheatercontrols
        System.out.println(response_for_deleted);
    }
    private void deleteAllSessionByLessPrice(){
        System.out.println("Enter the price");
        int price = scanner.nextInt();
        String response_for_deleted = sessionControls.deleteAllSessionByLessPrice(price); //cinemaTheatercontrols
        System.out.println(response_for_deleted);
    }
    private void deleteAllSessionByCinemaTheater() {
        System.out.println("Enter a Cinema Theater ID");
        int ID = scanner.nextInt();
        String response_for_deleted = sessionControls.deleteAllSessionByCinemaTheater(ID);
        System.out.println(response_for_deleted);
    }
    private void deleteMovie() {
        System.out.println("Please enter a Movie ID");
        int ID = scanner.nextInt();
        String response_for_deleted = filmControls.deleteMovie(ID);
        System.out.println(response_for_deleted);
    }
    private void addMovie() {
        System.out.println("Enter a title of Movie");
        String title = scanner.next();
        System.out.println("Enter a duration of Movie");
        Time duration = Time.valueOf(scanner.next());
        String response_for_deleted = filmControls.addMovie(title, duration);
        System.out.println(response_for_deleted);
    }
    private void deleteCinemaTheater() {
        System.out.println("Enter a Cinema Theater ID");
        int ID = scanner.nextInt();
        boolean response = sessionControls.deleteCinemaTheater(ID);;
        if(response==true){
            String response_for_deleted = cinemaControls.deleteCinemaTheater(ID);
            System.out.println(response_for_deleted);
        }
        else
            System.out.println("Please enter the correct data!");
    }
    private void addCinemaTheater() { // cinema theater controls
        System.out.println("Enter a title of Cinema Theater");
        String title = scanner.next();
        System.out.println("Enter a addres of Cinema Theater");
        String addres = scanner.next();
        String response_for_deleted = cinemaControls.addCinemaTheater(title, addres);
        System.out.println(response_for_deleted);
    }



    public void getAllSessionByTitle(){
        System.out.println("Please enter a Title of Movie");
        String title = scanner.next();
        String response = clientControls.getAllSessionByTitle(title);
        System.out.println(response);
    }
    public void getAllSessionByCinema(){
        System.out.println("Please enter a Title of Cinema Theater");
        String title = scanner.next();
        String response = clientControls.getAllSessionByCinema(title);
        System.out.println(response);
    }

    public void getAllSession(){
        String response = clientControls.getAllSession();
        System.out.println(response);
    }
    public void getAllMovies(){
        String response = filmControls.getAllMovies();
        System.out.println(response);
    }
    public void getAllTheater(){
        String response = cinemaControls.getAllMovies();
        System.out.println(response);
    }

    public void buyTicket(){
        String buyTicket = clientControls.buyTicket();
        System.out.println(buyTicket);
    }

}
