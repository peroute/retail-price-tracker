import CustomExceptions.PriceNotFoundException;
import CustomExceptions.macyWebScrapper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static CustomExceptions.macyWebScrapper.macyScrapper;


public class mainFX extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        Scene scene = new Scene(mainPane, 400, 500);



        // Create Nodes
        // Title (Label)
        Label titleLBL= new Label("Macys price tracker");
        titleLBL.setFont(Font.font("Minion", FontWeight.BOLD, 28));
        // Macy's red
        titleLBL.setTextFill(Color.web("#e21a2c"));


        // url label
        Label urlLBL = new Label("Type URL:");

        // Url field
        TextField urlTF = new TextField();
        urlTF.setPromptText("eg. https://www.macys.com/shop/product/polo-ralph-lauren-mens-classic-fit-mesh-polo?ID=14380976&swatchColor=Yellow%20Fin");

        // targetPrice label
        Label targetPriceLBL = new Label("Type target price:");

        // targetPrice txt field
        TextField targetPriceTF = new TextField();
        targetPriceTF.setPromptText("eg. 23.42");


        // email label
        Label emailLBL = new Label("Type your email:");

        // email txt field
        TextField emailTF = new TextField();
        emailTF.setPromptText("eg. example@gmail.com");

        // Checkbox
        CheckBox checkBox = new CheckBox("Use the same email for all products");
        checkBox.setOnAction((e) ->{
                    if (checkBox.isSelected()) {
                        emailTF.setDisable(true);
                    }else{
                        emailTF.setDisable(false);
                    }
                }
        );


        // add Button
        Button addButton = new Button("Add item");
        addButton.setOnAction((e) -> {
            addButtonAction(urlTF, targetPriceTF, emailTF, checkBox);
        });


        // check Button
        Button checkButton = new Button("Check item");
        checkButton.setOnAction((e) -> {
            checkButtonAction();
        });


        // see Button
        Button seeButton = new Button("See item list");
        seeButton.setOnAction((e) -> {
            BorderPane seeItemPane = createSeeItemPane(scene, mainPane, seeButton);
            scene.setRoot(seeItemPane);
        });


        // Container to hold all nodes in the top of the pane
        VBox topBox = new VBox(10);
        mainPane.setBackground(new Background(
                new BackgroundFill(Color.web("#f4f4f4"), CornerRadii.EMPTY, Insets.EMPTY)
        ));
        // Add nodes to the VBox
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(titleLBL, urlLBL, urlTF, targetPriceLBL, targetPriceTF, emailLBL, emailTF,
                checkBox,
                addButton, checkButton, seeButton);

        // Add nodes to pane
        mainPane.setCenter(topBox);
        Image icon = new Image("file:img/app/icon.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Macys price tracker");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public BorderPane createSeeItemPane(Scene scene, BorderPane mainPane, Button seeButton){
        BorderPane seeItemPane = new BorderPane();
        VBox vBox = new VBox(10);
        ArrayList<Item> myList;
        myList = DataHandler.loadList();

        vBox.setSpacing(10);

        // Return to main screen hbox on top
        HBox returnHbox = createReturnButton(scene, mainPane);
        vBox.getChildren().add(returnHbox);

        // Creating hbox for each item on list
        for(Item item : myList){
                HBox hBox = createItemNode(item.getUrl(), item.getTargetPrice(), item.getEmail(), item, seeButton);
                vBox.getChildren().add(hBox);
            }




        // add a scroll Pane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);
        scrollPane.setFitToWidth(true);

        seeItemPane.setCenter(scrollPane);


        return seeItemPane;
    }

    public HBox createItemNode(String url, double targetPrice, String email, Item item, Button seeButton){
        HBox hBox = new HBox(10);

        hBox.setSpacing(20);
        hBox.setPrefHeight(50);


        // Add delete image button
        Image delete = new Image("file:img/app/delete.png");

        // convert image to imview
        ImageView deleteIV = new ImageView(delete);
        deleteIV.setFitHeight(50);
        deleteIV.setFitWidth(50);
        // add button to delete image
        Button deleteButton = new Button();
        deleteButton.setGraphic(deleteIV);
        deleteButton.setPadding(Insets.EMPTY);
        deleteButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        // delete button action
        deleteButton.setOnAction((e) -> {
            DataHandler.removeFromList(item);
            // refresh the page
            seeButton.fire();

        });

        // add information:
        VBox vBox = new VBox(10);
        vBox.setPrefHeight(50);
        Label urlLBL = new Label("Url: " + url);
        Label targetPriceLBL = new Label("Target price: $" + targetPrice);
        Label emailLBL = new Label("Email: " + email);
        vBox.setPadding(Insets.EMPTY);
        vBox.getChildren().addAll(urlLBL,targetPriceLBL,emailLBL);

        vBox.setSpacing(5);
        hBox.getChildren().addAll(deleteButton, vBox);
        return hBox;
    }





    public HBox createReturnButton(Scene scene, BorderPane mainPane){
        // Creating hbox with macy red background
        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: #E21A22; -fx-border-color: transparent;");
        hBox.setPrefHeight(50);
        hBox.setSpacing(40);
        // Adding back button
        Image back = new Image("file:img/app/back.png");
        // convert Image to imview
        ImageView backIV = new ImageView(back);
        backIV.setFitHeight(50);
        backIV.setFitWidth(50);
        // adding image to button and make it transparent
        Button backButton = new Button();
        backButton.setGraphic(backIV);
        backButton.setPadding(Insets.EMPTY);
        backButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        // adding label
        Label titleLBL= new Label("Current item list");
        titleLBL.setFont(Font.font("Minion", FontWeight.BOLD, 28));

        titleLBL.setTextFill(Color.WHITE);
        // centering label
        titleLBL.setPadding(new Insets(5, 0, 0, 0));

        backButton.setOnAction((e) -> {
            scene.setRoot(mainPane);
        });

        // adding button and label to hbox
        hBox.getChildren().add(backButton);
        hBox.getChildren().add(titleLBL);

        return hBox;
    }

    public void addButtonAction(TextField urlTF, TextField targetPriceTF, TextField emailTF, CheckBox checkBox){
        ArrayList<Item> myList = new ArrayList<Item>();
        Alert alert = new Alert(Alert.AlertType.ERROR);


        if (urlTF.getText().trim().isEmpty() || targetPriceTF.getText().trim().isEmpty() || emailTF.getText().trim().isEmpty()) {
            alert.setTitle("Error");
            alert.setHeaderText("Missing inputs");
            alert.setContentText("Please make sure to fill all the textboxes.");
            alert.showAndWait();

        }else{
            //add item to list and store it
            try {
                myList.add(new Item(urlTF.getText(), Double.parseDouble(targetPriceTF.getText().trim()), emailTF.getText()));
            }catch (NumberFormatException e){
                alert.setTitle("Error");
                alert.setHeaderText("Target price has to be a double");
                alert.setContentText("Please enter a valid input.");
                alert.showAndWait();
            }
            // Check if the url is a Macys URL and append item to the list
            try {
                macyWebScrapper.macyScrapper(urlTF.getText().trim());
                DataHandler.appendList(myList);
            } catch (NullPointerException e) {
                alert.setTitle("Error");
                alert.setHeaderText("URL has to be a Macys url of a product");
                alert.setContentText("Please enter a valid input.");
                alert.showAndWait();

            }catch ( IOException | PriceNotFoundException  e){
                alert.setTitle("Error");
                alert.setHeaderText("The following error has occured: "+ e.getMessage());
                alert.setContentText("Please enter a valid input.");
                alert.showAndWait();
            }


        }
        if (checkBox.isSelected()) {
            urlTF.clear();
            targetPriceTF.clear();
        }else {
            urlTF.clear();
            targetPriceTF.clear();
            emailTF.clear();
        }

    }

    public static void checkButtonAction(){
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        double currentPrice;
        ArrayList<Item> myList;
        int itemDropped = 0;


        myList = DataHandler.loadList();

        // check if list is empty
        if (myList.isEmpty()){
            infoAlert.setTitle("Info");
            infoAlert.setHeaderText("The item list is empty. ");
            infoAlert.setContentText("Add an item and try again!");
            infoAlert.showAndWait();
        }else {
            // Check if items have dropped below target price
            for (Item item : myList) {
                try {
                    currentPrice = macyScrapper(item.getUrl());
                } catch (IOException | PriceNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (item.getTargetPrice() > currentPrice) {
                    itemDropped++;
                    emailSender.sendEmail(item);
                    DataHandler.removeFromList(item);
                    if(itemDropped == 1) {
                        infoAlert.setTitle("Congratulation!");
                        infoAlert.setHeaderText("One or more item has hit your target price");
                        infoAlert.setContentText("Check your email!");
                        infoAlert.showAndWait();
                    }
                }
            }
            if(itemDropped == 0 ) {
                infoAlert.setTitle("Sorry");
                infoAlert.setHeaderText("None of your items has hit your target price");
                infoAlert.setContentText("Try again later!");
                infoAlert.showAndWait();

            }
        }
    }

}
