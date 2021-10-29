
import java.util.Scanner;


public class GameMenu {

    Scanner scan = new Scanner(System.in);
    Race race = new Race();

    public void startGame() {
        int start = 1;
        int menu = 0;
        System.out.println("Welcome to Boat Race Game!");
        this.mainMenuOptions();
        try {
            System.out.print("Choose an option: ");
            menu = scan.nextInt();
        } catch (Exception InputMismatchException) {
            System.out.println("Invalid choice.Please choose number from 1 to 3.");
            scan.next();
        }
        if (menu == 1) {
            this.race.startRace();
        } else if (menu == 2) {
            this.displayGameInfo();
            String confirm = scan.next();
            this.startGame();
        } else {
            System.out.println("Thank you for playing.");
        }
    }


    void mainMenuOptions() {
        System.out.println();
        System.out.println("(1) Start a new game");
        System.out.println("(2) Game Info");
        System.out.println("(3) Exit Game");

    }

    void displayGameInfo() {
        System.out.println();
        System.out.println("This is a two-player boat racing game.");
        System.out.println("The objective is to reach the end of the track by rolling a dice.");
        System.out.println("First player to reach the end wins.");
        System.out.println("But watch out, there are obstacles along the journey");
        System.out.println("Enter any button to continue.");


    }
}