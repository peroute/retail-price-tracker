import CustomExceptions.PriceNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException, PriceNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String choice;



        System.out.println("welcome to the price tracker! \nThis program will help you keep track of sales of your favorite item at macys."
                + "\nyou will need the url of the product (make sure to click on the product and paste the correct url)"
                );


        choice = userInput.userChoice(scanner);
        if (choice.equalsIgnoreCase("c")){
            Choice.checkItems();
        } else if (choice.equalsIgnoreCase("a")) {
            Choice.addItem();
        } else if (choice.equalsIgnoreCase("s")) {
            // see
            Choice.seeItemList();

        }

    }


    }
