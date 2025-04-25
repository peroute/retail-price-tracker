import CustomExceptions.PriceNotFoundException;
import CustomExceptions.macyWebScrapper;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static CustomExceptions.macyWebScrapper.macyScrapper;

public class Choice {
    public static void userMakeChoice(Scanner scan) throws PriceNotFoundException, IOException {

    }
    public static void addItem() throws PriceNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<Item> myList = new ArrayList<Item>();
        String url;
        double priceTarget;
        String email;

        // get input from the user
        url = userInput.getUserUrl(scanner);
        priceTarget = userInput.getUserTargetPrice(scanner1);
        email = userInput.getUserEmail(scanner);

        // Check if it is a macys url
        try {
            macyWebScrapper.macyScrapper(url);
        } catch (NullPointerException e){
            System.out.println("use a Macys url of a product");
        } catch ( IOException | PriceNotFoundException  e){
            System.out.println("the following error has occured" + e.getMessage());
        }

        //add item to list and store it
        myList.add(new Item(url, priceTarget, email));
        DataHandler.appendList(myList);
        userInput.addMore(scanner);
    }


    public static void checkItems() throws PriceNotFoundException, IOException {
        //for myList
        ArrayList<Item> myList;
        myList = DataHandler.loadList();

        for(Item item : myList){
            checker(item);
        }

    }

    private static void checker(Item item) throws PriceNotFoundException, IOException {
        double currentPrice;

        currentPrice = macyScrapper(item.getUrl());
        if (item.getTargetPrice() > currentPrice){
            emailSender.sendEmail(item);


            DataHandler.removeFromList(item);
            System.out.println("Check your email! ");
        }else {

            System.out.println("Unfortunately this item " + item.getUrl() + "still has not hit the target price.");
        }

    }

    public static void seeItemList() throws PriceNotFoundException, IOException {
        ArrayList<Item> myList;
        myList = DataHandler.loadList();
        int i;
        if (myList.isEmpty()) {
            System.out.println("Sorry the list is empty");

        }else {
            i = 1;
            for(Item item : myList){

                System.out.println(i + ". URL: "+ item.getUrl());
                System.out.println("   Price: "+ macyScrapper(item.getUrl()));
                System.out.println("   Your target price for this item is: "+ item.getTargetPrice());
                i++;
            }
        }

    }


}
