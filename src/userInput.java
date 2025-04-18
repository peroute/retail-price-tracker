import java.util.Scanner;

public class userInput {
    public static String userChoice(){
        String choice;
        Scanner scanner = new Scanner(System.in);
        choice =scanner.next().toLowerCase();
        System.out.println("would you like to check your items / add an item to the list " +
                "/ see current list (type: [c] for check, [a] for add, [s] to see");

        if(choice.equals("c") || choice.equals("a") || choice.equals("s")) {
            return choice;
        } else{
            System.out.println("Please make sure to enter a valid option");
            userChoice();
        }
        return "error";
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

}
