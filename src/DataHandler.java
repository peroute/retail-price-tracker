import CustomExceptions.PriceNotFoundException;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class DataHandler {

    private static final String FILE_NAME = "items.ser";


    public static void appendList(ArrayList<Item> list) throws PriceNotFoundException, IOException {
        ArrayList<Item> currentList = loadList();
        for (Item item : list) {
            if (!currentList.contains(item)) {
                currentList.add(item);
                saveList(currentList);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("You already entered this item at this price target.");
                alert.setContentText("Please enter another item");
                alert.showAndWait();
                

            }
        }

    }

    public static void removeFromList(Item item){
        ArrayList<Item> currentList = loadList();
        currentList.remove(item);
        saveList(currentList);

    }



    public static void saveList(ArrayList<Item> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(list);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static ArrayList<Item> loadList() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Item>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Item>();
        }
    }
}