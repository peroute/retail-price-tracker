import CustomExceptions.PriceNotFoundException;

import java.io.*;
import java.lang.reflect.Array;
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
                System.out.println("You already entered this item at this price target. Please enter another item");
                Choice.addItem();
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
            // Return empty list if there is an error
            return new ArrayList<Item>();
        }
    }
}