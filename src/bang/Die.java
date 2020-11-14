package bang;

import java.util.Random;

/** Die
 *  Creates Dice object
 * @author Samrat Bhattarai
 */
public class Die {
    // Global variable declaration
    private final int numberOfDice = 5;
    private final int numDieSide = 6;
    public String side1,side2,side3,side4,side5,side6;
    public final String[] sides = {"Arrow","Dynamite","Gatling Gun","Bull's Eye 1",
        "Bull's Eye 2","Beer"};
    
    //Constructor for a Die
    /**
     * Constructor 
     */
    Die(){
        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
        this.side4 = sides[3];
        this.side5 = sides[4];
        this.side6 = sides[5];
    }
    
    // Creating an array of Dice
    Die[] Dice = new Die[numberOfDice];
    /**
     * This method creates 5 dice objects and stores in
     * Dice[]
     * It doesn't have any parameters and return types
     */
    public  void createDie() {
        for (int i = 0; i <= 4; i++) {
            Dice[i] = new Die();
        }
    }
    
    // Rolling the desired Die
    /**
     * rollDice
     * This method rolls a die
     * It doesn't have any parameters
     * @return random side of a dice
     */
    public String rollDice() {
        Random rand = new Random(); // To get a random number
        int randomInt = rand.nextInt(numDieSide);
        String temp = selectSide(randomInt+1);
        System.out.println(temp + randomInt);
        return temp;
    }
    
    // Getting the name of the side after rolling the die
    /**
     * 
     * @param input a random integer 
     * @return name of a side of a dice
     */
    private String selectSide(int input){
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
