package bang;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
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
import javafx.scene.text.Text;

import javax.swing.*;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;

public class Bang extends Application {
    static PlayerFrame[] playerFrames;
    static int players = 0;
    static Group secondaryLayout = new Group();
    static Text[] dice = new Text[6];
    static Text diceLabel = new Text();
    static Button button2 = new Button("Roll Dice");
    
    @Override
    public void start (Stage stage) throws FileNotFoundException{
        secondaryLayout.getChildren().add(diceLabel);
        button2.setLayoutX(500);
        button2.setLayoutY(200);
        secondaryLayout.getChildren().add(button2);
        /*
        //Creating the button
        Button button;
        button = new Button();
        button.setText ("Click me!");
        */

        //Creating an image
        Image image = new Image(new FileInputStream("bangFront.jpg"));

        //Setting the image view 1
        ImageView imageView1 = new ImageView(image);

        //Setting the position of the image
        imageView1.setX(50);
        imageView1.setY(15);

        //setting the fit height and width of the image view
        imageView1.setFitHeight(470);
        imageView1.setFitWidth(390);

        //Setting the preserve ratio of the image view
        imageView1.setPreserveRatio(true);

        // create a button1
        Button button1 = new Button("Start Game");

        // Here's the second page that will be opened once we click on the button
        
        button1.setLayoutX(500);
        button1.setLayoutY(200);

        // create a Menu button
        MenuItem menuItem1 = new MenuItem("4 Players");
        MenuItem menuItem2 = new MenuItem("5 Players");
        MenuItem menuItem3 = new MenuItem("6 Players");

        MenuButton menuButton = new MenuButton("Number of players", null, menuItem1, menuItem2, menuItem3);
        menuItem1.setOnAction((ActionEvent event) ->{
            menuButton.setText("4 players");
            players = 4;
        });

        menuItem2.setOnAction((ActionEvent event) ->{
            menuButton.setText("5 players");
            players = 5;
        });

        menuItem3.setOnAction((ActionEvent event) ->{
            menuButton.setText("6 players");
            players = 6;
        });
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("4 Players");
        choiceBox.getItems().add("5 Players");
        choiceBox.getItems().add("6 Players");


        HBox hbox = new HBox(menuButton);
        hbox.setLayoutX(500);
        hbox.setLayoutY(240);
                /*
                // create a Menu button
                MenuItem menuItem4 = new MenuItem("Classic");
                MenuItem menuItem5 = new MenuItem("Undead or alive");
                MenuItem menuItem6 = new MenuItem("Old fashion");

                MenuButton menuButton2 = new MenuButton("Gameplay", null, menuItem4, menuItem5, menuItem6);
                menuItem4.setOnAction((ActionEvent event) ->{
                    menuButton2.setText("Classic");
                });

                menuItem5.setOnAction((ActionEvent event) ->{
                    menuButton2.setText("Undead or alive");
                });

                menuItem6.setOnAction((ActionEvent event) ->{
                    menuButton2.setText("Old fashion");
                });
                ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
                choiceBox.getItems().add("Classic");
                choiceBox.getItems().add("Undead or alive");
                choiceBox.getItems().add("Old fashion");


                HBox hbox2 = new HBox(menuButton2);
                hbox2.setLayoutX(400);
                hbox2.setLayoutY(280);
                */
        //Create checkbox
        //CheckBox checkBox1 = new CheckBox("Classic");
        CheckBox checkBox2 = new CheckBox("Undead or alive");
        CheckBox checkBox3 = new CheckBox("Old Saloon");

        //HBox hbox3 = new HBox(checkBox1);
        //hbox3.setLayoutX(500);
        //hbox3.setLayoutY(280);

        HBox hbox4 = new HBox(checkBox2);
        hbox4.setLayoutX(500);
        hbox4.setLayoutY(310);

        HBox hbox5 = new HBox(checkBox3);
        hbox5.setLayoutX(500);
        hbox5.setLayoutY(340);
        
        button1.setOnAction((ActionEvent event) -> {
            try {
                Gameplay.startGame(players, checkBox2.isSelected(), checkBox3.isSelected());
            } catch (Exception ex) {
                Logger.getLogger(Bang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // create a stack pane
        StackPane r = new StackPane();

        // add button
        r.getChildren().add(button1);
        r.getChildren().add(hbox);

        //Creating a Group object
        Group root = new Group(imageView1, button1, hbox, hbox4, hbox5);

        //Creating a scene object
        Scene scene = new Scene(root, 800, 600);

        //Setting title to the Stage
        stage.setTitle("Bang The Dice Game");

        //Adding scene to the stage
        stage.setScene(scene);
        //stage.setScene(scene2);

        //Displaying the contents of the stage
        stage.show();

    }
    
    public static void showDice(String[] results, String playerName){
        System.out.println("Showing dice");
        diceLabel.setLayoutX(300);
        diceLabel.setLayoutY(400);
        diceLabel.setText(playerName+":");
        for (Text dice1 : dice) {
            secondaryLayout.getChildren().remove(dice1);
        }
        for(int i = 0; i < results.length; i++){
            dice[i] = new Text();
            dice[i].setLayoutX(400 + 100 * i);
            dice[i].setLayoutY(400);
            dice[i].setText(results[i]);
            secondaryLayout.getChildren().add(dice[i]);
        }
    }
    
    public static void showDieRollButton(){
        button2.setVisible(true);
        button2.setOnAction((ActionEvent e) ->{
            button2.setVisible(false);
            Gameplay.nextTurn(true);
        });
    }
    
    public static void createPlayerFrames(Player[] players){
        Scene secondScene = new Scene(secondaryLayout, 1200, 1000);
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
        
        playerFrames = new PlayerFrame[players.length];
        for(int i = 0; i < players.length; i++){
            Implement ch = players[i].getCharacter();
            int health = ch.getHealth();
            String role = players[i].getRole();
            playerFrames[i] = createPlayerFrame(i,health, role, players[i].getArrows(), players[i].getRole().equals("Sheriff"), secondaryLayout, secondScene);
        }
    }


    //Function that will be called once startGame is done working
    public static PlayerFrame createPlayerFrame(int ID, int health, String roles, int arrow, boolean isSherrif,Group secondaryLayout, Scene secondScene){
        //Creating a Text object
        Text text = new Text();
        Text text2 = new Text();
        Text text3 = new Text();
        Text text4 = new Text();
        Text text5 = new Text();
        Text text6 = new Text();

        //Setting the text to be added.
        text.setText("Player statistics:");
        text2.setText("Player ID: " + ID+ "\n");
        text3.setText("Health: " + health + "\n");
        text4.setText("Role: " + roles + "\n");
        text5.setText("Arrow: " + arrow  + "\n");
        text6.setText("Sheriff?: " + isSherrif + "\n");
        
        PlayerFrame frame = new PlayerFrame();
        frame.Arrows = text5;
        frame.Health = text3;
        frame.PlayerID = text2;
        frame.Role = text4;
        frame.Sheriff = text6;
        frame.statistics = text;

        //Assume each set is 10x30
        //Assume there are 3 columns
        int x = (ID%4) * 200;
        int y = (ID/4) * 200;
        //setting the position of the text
        text.setLayoutX(x);
        text.setLayoutY(y);

        text2.setLayoutX(x);
        text2.setLayoutY(20 + y);

        text3.setLayoutX(x);
        text3.setLayoutY(40+y);

        text4.setLayoutX(x);
        text4.setLayoutY(60 + y);

        text5.setLayoutX(x);
        text5.setLayoutY(80 + y);

        text6.setLayoutX(x);
        text6.setLayoutY(100 + y);

        //Creating a Group object

        //secondaryLayout.getChildren().add(secondLabel);
        secondaryLayout.getChildren().add(text);
        secondaryLayout.getChildren().add(text2);
        secondaryLayout.getChildren().add(text3);
        secondaryLayout.getChildren().add(text4);
        secondaryLayout.getChildren().add(text5);
        secondaryLayout.getChildren().add(text6);


        

        // New window (Stage)
        
        return frame;
    }
    
    public static void updatePlayerFrame(int ID, Player p){
        PlayerFrame pf = playerFrames[ID];
        pf.Health.textProperty().set("Health: "+p.getCharacter().getHealth());
        pf.Arrows.textProperty().set("Arrows: "+p.getArrows());
    }

    public static void main(String[] args) {
        launch(args);
    }

}

class PlayerFrame{
    Text statistics;
    Text PlayerID;
    Text Health;
    Text Role;
    Text Arrows;
    Text Sheriff;
}
