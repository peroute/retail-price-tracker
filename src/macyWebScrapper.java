import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class macyWebScrapper {

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


    public static void macyScrapper(String url, double targetPrice) throws IOException{

        double currentPrice = 0.0;
        double oldPrice;
        double discount;
        Document doc = Jsoup.connect(url).get();

        // Extract current price and old price if there is a discount
        String currentPriceStr = doc.selectFirst("div.price-wrapper span.base-price").text();
        String oldPriceStr = doc.selectFirst("div.price-wrapper span.extra-price").text();

        System.out.println(currentPriceStr);
        System.out.println(oldPriceStr);
        // reg ex to get the price
        Pattern pattern = Pattern.compile("\\$\\S+");
        Matcher matcher1 = pattern.matcher(currentPriceStr);
        // if there is a reduction check for the ld price
        Matcher matcher2 = pattern.matcher(oldPriceStr);

        // return the current price
        if(matcher1.find()){
            // gets the current price and convert it to Double
            currentPrice = Double.parseDouble(matcher1.group().substring(1));
            System.out.println("current price is: " + matcher1.group());
        } else{
            System.out.println("There is no price for this item an error occured");
        }

        if (matcher2.find()) {
            // gets the old price (in case they are already making a discount) and convert it to Double
            oldPrice = Double.parseDouble(matcher2.group().substring(1));
            System.out.println("Previous price was: " + matcher2.group());
            discount = ((oldPrice-currentPrice)/oldPrice)*100;
            System.out.println("current discount %" + discount + " off.");
        }


    }

}
