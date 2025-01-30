package console_client;

import java.util.Scanner;

public class ConsoleApplication {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ConsoleLogic consoleLogic = new ConsoleLogic("http://localhost:8080");

        while (true) {

            System.out.println("\n\n Please select a task number between 1-3!");

            int selection = scan.nextInt();

            switch (selection){
                case 1:
                    String urlEndpoint1 = "average-temperature";
                    consoleLogic.taskOne(urlEndpoint1);
                    break;

                case 2:
                    String urlEndpoint2 = "rainfall";
                    consoleLogic.taskTwo(urlEndpoint2);
                    break;

                case 3:
                    String urlEndpoint3 = "temperature-institutes";
                    consoleLogic.taskThree(urlEndpoint3);
                    break;

                default:
                    System.out.println("You can only select numbers between 1-3!");
            }
        }
    }
}
