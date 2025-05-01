
import CustomExceptions.PriceNotFoundException;
import CustomExceptions.macyWebScrapper;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws PriceNotFoundException, IOException {

        testMacysScrapper();

    }
    public static void testMacysScrapper() throws IOException, PriceNotFoundException{
        String url = "https://www.amazon.com/Shockproof-Protective-Accessories-Resistant-Compatible/dp/B0CNRTFFDW/ref=asc_df_B0CNRTFFDW?mcid=61a9b51879603708b674fc2c04708b5b&hvocijid=12051591214345022361-B0CNRTFFDW-&hvexpln=73&tag=hyprod-20&linkCode=df0&hvadid=721245378154&hvpos=&hvnetw=g&hvrand=12051591214345022361&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1025202&hvtargid=pla-2281435180058&th=1";

        try {
            macyWebScrapper.macyScrapper(url);
        } catch (NullPointerException e){
            System.out.println("use a Macys url of a product");
        }

    }

}
