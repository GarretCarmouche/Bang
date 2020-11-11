/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author archanbhattarai
 */
public class Bang extends Application {
   
  
    // objects in the GUI for data input
    private RadioButton three = new RadioButton("Three");
    private RadioButton four = new RadioButton("Four");
    private RadioButton five = new RadioButton("Five");
    private RadioButton six = new RadioButton("Six");
    private RadioButton seven = new RadioButton("Seven");
    private RadioButton eight = new RadioButton("Eight");

    
    private TextField nameOfPlayer = new TextField();
    private TextField new3= new TextField();
    private TextField new5= new TextField();
    private Button startGame = new Button("Start");
    

    public static void main(String args[]) { 
        // launch the application 
        launch(args); 
    } 
    
    @Override
    public void start(Stage firstStage) {   
        // set title for the stage
        firstStage.setTitle("Welcome to Bang! The Dice Game");

        // Create a Grid to align objects, then set objects in place
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Number of Players:"), 0,0);
        gridPane.add(four, 3, 0);
        gridPane.add(five, 4, 0);
        gridPane.add(six, 5, 0);
        gridPane.add(seven, 6, 0);
        gridPane.add(eight, 7, 0);
       
//        gridPane.add(new Label("Your Name:"), 0,1);
//        gridPane.add(nameOfPlayer, 1, 1);
        gridPane.add(startGame, 4, 3);
       
        
        // set the proper alignment for the objects
        gridPane.setAlignment(Pos.CENTER);
//        four.setAlignment(Pos.BOTTOM_LEFT);
//        nameOfPlayer.setAlignment(Pos.BOTTOM_LEFT);
        
        
        //display the first scene
        Scene scene = new Scene(gridPane,500,250);
        firstStage.setScene(scene);
        firstStage.show();
        
        GridPane secondGridPane = new GridPane();
        secondGridPane.setHgap(5);
        secondGridPane.setVgap(5);
        Scene newScene = new Scene(secondGridPane, 1400,820);
        
        Die di = new Die();
        di.createDie();
        System.out.println(di.Dice[1].side1);
        
        //display the second scene
        startGame.setOnAction(e -> {
            firstStage.setScene(newScene);
            startGame.requestFocus();
            //secondScene.show(secondStage);
        });
        
    }
    
}
