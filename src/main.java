import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String url;
        double targetPrice;
        Map<String, Double> data = new HashMap<>();
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
}
