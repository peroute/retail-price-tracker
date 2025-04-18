import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class dataSaving {
    public static void saveInput(String url, double targetprice) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
        writer.write(url + "," + targetprice);
        writer.newLine();
        writer.close();
        System.out.println("Saved!");
    }

    public static Map<String, Double> getData() throws IOException{
        Map<String, Double> data = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

        while ((reader.readLine()) != null) {
            String[] parts = reader.readLine().split(",");
            if (parts.length == 2) {
                String url = parts[0];
                double targetprice = Double.parseDouble(parts[1]);
                data.put(url, targetprice);
            }
        }
        return data;

    }
}
