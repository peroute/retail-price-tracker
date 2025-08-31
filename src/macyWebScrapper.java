package CustomExceptions;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;



public class macyWebScrapper {





    /**
     *Scrapes the current price of a product from a Macy's product page using the given URL.
     *<p>
     *It connects to the page, extracts the price using Jsoup and regex,
     *and returns it as a double.
     *
     * @param url
     * @return currentPrice
     */
    public static double macyScrapper(String url) throws NullPointerException, IOException, PriceNotFoundException {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String currentPriceStr = "";
        try {
            driver.get(url);
            WebElement priceElement = driver.findElement(By.cssSelector("div.price-wrapper span.base-price"));

            currentPriceStr = priceElement.getText();

        } finally {
            driver.quit();
        }

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

