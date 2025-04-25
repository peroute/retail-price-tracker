import CustomExceptions.PriceNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static CustomExceptions.macyWebScrapper.macyScrapper;

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

        /*

Boolean truth;


        System.out.println("checking current list" );
        Choice.seeItemList();

        System.out.println("testing remove method" );
        Choice.addItem();
        //https://www.macys.com/shop/product/donna-karan-new-york-womens-belted-sleeveless-shirtdress?ID=20784838&CategoryID=5449still
        //12
        System.out.println();
        Choice.seeItemList();
*/

        /*

        System.out.println("welcome to the price tracker would you like to check your items / add an item to the list " +
                "/ see current list (type: [c] for check, [a] for add, [s] to see");

        scan

        //Base url and price
        //        url without reduction:
        //        url with https://www.macys.com/shop/product/sun-stone-mens-garment-dyed-cargo-jogger-pants-created-for-macys?ID=18241730&swatchColor=Tank
        url = "https://www.macys.com/shop/product/nike-mens-calm-slide-sandals-from-finish-line?ID=15469912&swatchColor=Khaki";
        targetPrice = 31.2;

        //url = macyWebScrapper.getUserUrl(scan);
        //targetPrice = macyWebScrapper.getUserTargetPrice(scan);

        dataSaving.saveInput(url,targetPrice);
        data = dataSaving.getData();
        System.out.println(data);
        macyWebScrapper.macyScrapper(url,targetPrice);




    }

}*/
