package bang;

import java.util.Random;

/** Die
 *  Creates Dice object
 * @author Samrat Bhattarai, Garret Carmouche
 */
public class Die {
    // Global variable declaration
    private final int numberOfDice = 5;
    private final int numDieSide = 6;
    public final String[] diceType ={"WhiteDice","BlackDice","CowardDice","LoudMouthDice"};
    public String side1,side2,side3,side4,side5,side6,diceName;
    
    public final String[] whiteDice = {"Arrow","Dynamite","Gatling Gun",
        "Bull's Eye 1", "Bull's Eye 2","Beer"};
    
    public final String[] blackDice = {"Duel","Duel31",
        "Dynamite","Arrow", "Gatling Gun","Whiskey Jar"};
    
    public final String[] cowardDice = {"Arrow","Dynamite",
        "Bull's Eye 1","Broken Arrow", "Beer","Two Beers"};
    
    public final String[] loudMouth = {"Arrow","Dynamite",
        "Gatling Gun","Double Bull's Eye 1", "Double Bull's Eye 2","Silver Bullet"};
    
//Constructor for a Die
    /**
     * Constructor
     */
    public Die(int expansion){
        switch (expansion) {
            case 1:
                this.side1 = blackDice[0];
                this.side2 = blackDice[1];
                this.side3 = blackDice[2];
                this.side4 = blackDice[3];
                this.side5 = blackDice[4];
                this.side6 = blackDice[5];
                this.diceName = diceType[1];
                break;
            case 2:
                this.side1 = cowardDice[0];
                this.side2 = cowardDice[1];
                this.side3 = cowardDice[2];
                this.side4 = cowardDice[3];
                this.side5 = cowardDice[4];
                this.side6 = cowardDice[5];
                this.diceName = diceType[2];
                break;
            case 3:
                this.side1 = loudMouth[0];
                this.side2 = loudMouth[1];
                this.side3 = loudMouth[2];
                this.side4 = loudMouth[3];
                this.side5 = loudMouth[4];
                this.side6 = loudMouth[5];
                this.diceName = diceType[3];
                break;
            case 0:
            default:
                this.side1 = whiteDice[0];
                this.side2 = whiteDice[1];
                this.side3 = whiteDice[2];
                this.side4 = whiteDice[3];
                this.side5 = whiteDice[4];
                this.side6 = whiteDice[5];
                this.diceName = diceType[0];
                break;
        }

    }
    
    /**
     * Rolls the die
     * @return String side of die rolled
     */
    public String roll(){
        int sideChosen = (int)(Math.random() * 7);
        switch(sideChosen){
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
    
    // Creating an array of Dice
    Die[] Dice = new Die[numberOfDice];
    
    /**
     * This method creates 5 dice objects and stores in
     * Dice[]
     * @param whiteDice number of whiteDice to be included if expansion is used
     *        by default there are 5 white dices
     * @param blackDice check if player wants to include it
     * @param cowardDice check if player wants to include it
     * @param loudMouth check if player wants to include it
     * It doesn't return anything, just creates 5 dices
     * @deprecated
     * Replaced by new functionality (Garret)
     */
    public  void createDice(int whiteDice, int blackDice, int cowardDice, int loudMouth) {
        int numDice = 0; // index of dice
        // create loudMouth die
        if (loudMouth != 0) {
            for (int i = 0; i <= loudMouth-1; i++) {
                Dice[numDice] = new Die(3);
                numDice++;
            }
        }
        // create coward die
        if (cowardDice != 0){
            for (int i = 0; i <= cowardDice-1; i++) {
                Dice[numDice] = new Die(2);
                numDice++;
            }
        }
        // create black die
        if (blackDice != 0){
            for (int i = 0; i <= blackDice-1; i++) {
                Dice[numDice] = new Die(2);
                numDice++;
            }
        }
        // create white die
        for (int i = numDice; i <= 4; i++) {
            Dice[i] = new Die(0);
        }
       
            
        
    }
    
    // Rolling the desired Die
    /**
     * rollDice
     * This method rolls a die
     * It doesn't have any parameters
     * @return random side of a dice
     * @deprecated
     * Replaced by new functionality (Garret)
     */
    public String rollDice(Die toRoll) {
        Random rand = new Random(); // To get a random number
        int randomInt = rand.nextInt(numDieSide);
        String temp = selectSide(toRoll,randomInt);
        System.out.println(temp);
        return temp;
    }
    
    // Getting the name of the side after rolling the die
    /**
     * 
     * @param input a random integer 
     * @return name of a side of a dice
     * @deprecated Replaced with new functionality (Garret)
     */
    private String selectSide(Die toRoll,int input){
        String temp;
        if (diceType[0].equals(toRoll.diceName)) { 
            temp = whiteDice[input];
        }
        
        else if (diceType[1].equals(toRoll.diceName)) { 
            temp = blackDice[input];
        }
        
        else if (diceType[2].equals(toRoll.diceName)) { 
            temp = cowardDice[input];
        }
        
        else {
            temp = loudMouth[input];
        }
        return temp;
    }
}
