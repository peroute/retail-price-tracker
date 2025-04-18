package CustomExceptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class macyWebScrapper {




    public static double macyScrapper(String url, double targetPrice) throws IOException, PriceNotFoundException {

        double currentPrice = 0.0;
        //double oldPrice;
        //double discount;
        Document doc = Jsoup.connect(url).get();

        // Extract current price and old price if there is a discount
        String currentPriceStr = doc.selectFirst("div.price-wrapper span.base-price").text();
        //String oldPriceStr = doc.selectFirst("div.price-wrapper span.extra-price").text();

        //System.out.println(currentPriceStr);
        //System.out.println(oldPriceStr);
        // reg ex to get the price
        Pattern pattern = Pattern.compile("\\$\\S+");
        Matcher matcher1 = pattern.matcher(currentPriceStr);
        // if there is a reduction check for the ld price
        //Matcher matcher2 = pattern.matcher(oldPriceStr);

        // return the current price
        if(matcher1.find()){
            // gets the current price and convert it to Double
            return Double.parseDouble(matcher1.group().substring(1));
            //System.out.println("current price is: " + matcher1.group());
        } else{
            System.out.println("There is no price for this item an error occured");
            throw new PriceNotFoundException("There is no price for this item.");
        }
/*
        if (matcher2.find()) {
            // gets the old price (in case they are already making a discount) and convert it to Double
            oldPrice = Double.parseDouble(matcher2.group().substring(1));
            System.out.println("Previous price was: " + matcher2.group());
            discount = ((oldPrice-currentPrice)/oldPrice)*100;
            System.out.println("current discount %" + discount + " off.");
        }

*/
    }


}

