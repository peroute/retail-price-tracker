import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class macyScrapper {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://www.macys.com/shop/product/sun-stone-mens-garment-dyed-cargo-jogger-pants-created-for-macys?ID=18241730&swatchColor=Tank").get();
        Document document1 = Jsoup.connect("https://www.macys.com/shop/product/the-north-face-mens-vault-backpack?ID=14765104&swatchColor=Tnf%20Black").get();
        // Extract a specific element by class
        Elements titles = document.select(".price-wrapper");

        // Extract text from an element
        for (Element title : titles) {
            System.out.println(title.text());
        }

        // Extract a specific element by class
        Elements titles1 = document1.select(".price-wrapper");

        for (Element title : titles1) {
            System.out.println(title.text());
        }
    }
}
