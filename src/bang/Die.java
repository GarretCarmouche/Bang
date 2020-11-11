/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.Random;

/**
 *
 * @author archanbhattarai
 */
public class Die {
    public final int numberOfDice = 5;
    private final int numDieSide = 6;
    public String side1,side2,side3,side4,side5,side6;
    public String[] sides = {"Arrow","Dynamite","Gatling Gun","Bull's Eye 1",
        "Bull's Eye 2","Beer"};
    
    //Constructor for a Die
    Die(){
        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
        this.side4 = sides[3];
        this.side5 = sides[4];
        this.side6 = sides[5];
    }
    
    // Creating an array of Dice of type Die
    Die[] Dice = new Die[numberOfDice];
    public  void createDie() {
        for (int i = 0; i <= 4; i++) {
            Dice[i] = new Die();
        }
    }
    public String rollDice(String input) {
        Random rand = new Random(); // To get a random number
        int randomInt = rand.nextInt(numDieSide);
        String temp = selectSide(randomInt);
        System.out.println(temp);
        return input;
    }
    
    public String selectSide(int input){
        switch(input) {
            case 1:
                return this.side1;
                
            case 2:
                return this.side2;
                
            case 3:
                return this.side3;
                
            case 4: 
                return this.side4;
                
            case 5:
                return this.side5;
                
            case 6:
                return this.side6;
                
            default:
                return this.side1;
        }
        
    }
}
