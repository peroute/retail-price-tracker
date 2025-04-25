import CustomExceptions.PriceNotFoundException;

import java.io.IOException;
import java.util.Scanner;

public class userInput {
    public static String userChoice(Scanner scanner){
        String choice;

        System.out.print("would you like to check your items / add an item to the list " +
                "/ see current list (type: [c] for check, [a] for add, [s] to see --> ");
        choice = scanner.next();
        if(choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("s")) {
            return choice;
        } else{
            System.out.println("Please make sure to enter a valid option");
            return userChoice(scanner);
        }

    }

    public static String getUserUrl(Scanner scanner){

        System.out.print("Enter Macy's product URL: ");
        return scanner.nextLine();


    }
    public static double getUserTargetPrice(Scanner scanner){
        System.out.print("Enter your target price: ");
        double targetPrice = scanner.nextDouble();
        System.out.print("");
        return targetPrice;

    }
    public static String getUserEmail(Scanner scanner){
        System.out.print("Enter Email adress: ");
        return scanner.nextLine();

    }
    public static void addMore(Scanner scanner) throws PriceNotFoundException, IOException {
        System.out.print("would you like to add another item? [y/n]");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("y")){
            Choice.addItem();
        }
        else {
            Choice.checkItems();
        }
}
}
