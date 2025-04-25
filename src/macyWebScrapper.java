package CustomExceptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class macyWebScrapper {





    /**
     *Scrapes the current price of a product from a Macy's product page using the given URL.
     *<p>
     *It connects to the page, extracts the price using Jsoup and regex,
     *and returns it as a double. If no price is found, it throws a custom exception.
     *
     * @param url
     * @return currentPrice (on website)
     * @throws IOException
     * @throws PriceNotFoundException
     */
    public static double macyScrapper(String url) throws NullPointerException, IOException, PriceNotFoundException {
        Document doc = Jsoup.connect(url).get();

        // Extract current price and old price if there is a discount
        String currentPriceStr = doc.selectFirst("div.price-wrapper span.base-price").text();

        // reg ex to get the price
        Pattern pattern = Pattern.compile("\\$\\S+");
        Matcher matcher1 = pattern.matcher(currentPriceStr);

        // return the current price
        if(matcher1.find()){
            // gets the current price and convert it to Double
            return Double.parseDouble(matcher1.group().substring(1));
        } else{
            //System.out.println("There is no price for this item an error occured");
            throw new PriceNotFoundException("There is no price for this item.");
        }

    }



}

