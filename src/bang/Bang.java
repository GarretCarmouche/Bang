/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.util.Optional;

import javafx.application.Application;
import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 *
 * @author vreyz
 */

public class Bang extends Application{
    @Override
            public void start (Stage stage) throws FileNotFoundException{
        /*
        //Creating the button
        Button button;
        button = new Button();
        button.setText ("Click me!");
        */

        //Creating an image
             Image image = new Image(new FileInputStream("C:\\Users\\vreyz\\Desktop\\Bang\\bangFront.jpg"));

             //Setting the image view 1
              ImageView imageView1 = new ImageView(image);

              //Setting the position of the image
              imageView1.setX(50);
              imageView1.setY(15);

              //setting the fit height and width of the image view
              imageView1.setFitHeight(370);
              imageView1.setFitWidth(290);

              //Setting the preserve ratio of the image view
              imageView1.setPreserveRatio(true);

              // create a button1
              Button button1 = new Button("Start Game");

              // Here's the second page that will be opened once we click on the button
              button1.setOnAction((ActionEvent event) -> {
                  Label secondLabel = new Label("I'm a Label on new Window");
                  
                  StackPane secondaryLayout = new StackPane();
                  secondaryLayout.getChildren().add(secondLabel);
                  
                  Scene secondScene = new Scene(secondaryLayout, 600, 400);
                  
                  // New window (Stage)
                  Stage newWindow = new Stage();
                  newWindow.setTitle("Second Stage");
                  newWindow.setScene(secondScene);
                  
                  // Specifies the modality for new window.
                  newWindow.initModality(Modality.WINDOW_MODAL);
                  
                  /*
                  // Specifies the owner Window (parent) for new window
                  newWindow.initOwner(primaryStage);
                  
                  // Set position of second window, related to primary window.
                  newWindow.setX(primaryStage.getX() + 200);
                  newWindow.setY(primaryStage.getY() + 100);
                  */
                  newWindow.show();
             });
              button1.setLayoutX(400);
              button1.setLayoutY(200);

              // create a Menu button
                MenuItem menuItem1 = new MenuItem("4 Players");
                MenuItem menuItem2 = new MenuItem("5 Players");
                MenuItem menuItem3 = new MenuItem("6 Players");

                MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);
                menuItem1.setOnAction((ActionEvent event) ->{
                  menuButton.setText("4 players");
                });

                menuItem2.setOnAction((ActionEvent event) ->{
                    menuButton.setText("5 players");
                });

                menuItem3.setOnAction((ActionEvent event) ->{
                    menuButton.setText("6 players");
                });
                ChoiceBox<String> choiceBox = new ChoiceBox<>();
                choiceBox.getItems().add("4 Players");
                choiceBox.getItems().add("5 Players");
                choiceBox.getItems().add("6 Players");


                HBox hbox = new HBox(menuButton);
                hbox.setLayoutX(400);
                hbox.setLayoutY(240);

              // create a stack pane
              StackPane r = new StackPane();

              // add button
              r.getChildren().add(button1);
              r.getChildren().add(hbox);

        //Creating a Group object
              Group root = new Group(imageView1, button1, hbox);

              //Creating a scene object
              Scene scene = new Scene(root, 600, 400);

              //Setting title to the Stage
              stage.setTitle("Bang The Dice Game");

              //Adding scene to the stage
              stage.setScene(scene);
              //stage.setScene(scene2);

              //Displaying the contents of the stage
              stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
