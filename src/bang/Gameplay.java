package bang;

<<<<<<< HEAD
import java.util.ArrayList;

/**
 *
 * @author garre
 */
public class Gameplay {
 
    private static String[] expansions = {"Default","UndeadOrAlive","OldSaloon"};
    private static boolean undeadOrAlive = false;
    private static boolean oldSaloon = false;
    private static int playerDice = 5;
    private static ArrayList<Player> players;
    private static int playerTurn = -1;
    
    /**
     * Invoked when the player clicks to roll the dice. Rolls the appropriate number of dice and returns result.
     * @param loudmouthCoward whether to include one Loudmouth, or one Coward die. Return "None" if neither.
     * @return ArrayList<String> containing results of dice roll
     */
    public static ArrayList<String> rollPlayerDice(String loudmouthCoward){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Die> dice;
        int defaultDice = playerDice;
        int blackDice = 0;
        int loudmouth = 0;
        int coward = 0;
        
        if(oldSaloon){
            if(loudmouthCoward.equals("Loudmouth")){
                defaultDice--;
                loudmouth = 1;
            }else if (loudmouthCoward.equals("Coward")){
                defaultDice--;
                coward = 1;
            }
        }
        if(undeadOrAlive){
            blackDice = defaultDice;
            defaultDice = 0;
        }
        return result;
    }
    
    /**
     * Initialize player objects
     * @param numberOfAI Number of AI selected by the player
     */
    public static void createPlayers(int numberOfAI){
        players.add(new Player());
        for(int i = 0; i < numberOfAI; i++){
            players.add(new AI());
        }
    }
    
    /**
     * Begin the turn of the next player
     */
    private static void nextTurn(){
        playerTurn++;
        Player plr = players.get(playerTurn);
        if(plr instanceof AI){
            ((AI) plr).runTurn();
=======
/**
 *
 * @author Garret Carmouche
 */
public class Gameplay {
    
    private static boolean blackDieEnabled = false;
    private static boolean loudmouthDieEnabled = false;
    private static boolean cowardDieEnabled = false;
    
    private static Player[] players;
    private static int currentTurn = -1;
    
    private static boolean gameOver = false;
    //Roll player's dice
    public static void rollDice(){
        int defaultDice = 6;
        int loudmouthDice = 0;
        int cowardDice = 0;
        int blackDice = 0;
        String[] results = new String[6];
        
        if(blackDieEnabled){
            defaultDice -= 2;
            blackDice += 2;
        }
        if(loudmouthDieEnabled){
            defaultDice--;
            loudmouthDice++;
        }else if(cowardDieEnabled){
            defaultDice--;
            cowardDice++;
        }
        
        //Roll all dice
        for(int i = 0; i < defaultDice; i++){
            Die d = new Die(0);
            results[i] = d.roll();
        }
        
        for(int i = 0; i < blackDice; i++){
            Die d = new Die(1);
            results[i+defaultDice] = d.roll();
        }
        
        for(int i = 0; i < cowardDice; i++){
            Die d = new Die(2);
            results[i+defaultDice+blackDice] = d.roll();
        }
        
        for(int i = 0; i < loudmouthDice; i++){
            Die d = new Die(3);
            results[i+defaultDice+blackDice+cowardDice] = d.roll();
        }
    }
    
    /**
     * Constructs the appropriate number of AI and players
     * @param playerCount Number of players in the game (including user)
     */
    public static void constructPlayers(int playerCount){
        players[0] = new Player();
        for(int i = 1; i < playerCount; i++){
            players[i] = new AI();
        }
    }
    
    private static GameResult getGameResult(){
        GameResult result = new GameResult();
        
        return result;
    } 
    
    //Iterate through turns until player turn is reached
    private static void nextTurn(){
        currentTurn = (currentTurn+1) %  players.length;
        
        Player player = players[currentTurn];
        if(player instanceof AI){
            ((AI) player).runTurn();
        }else{
            //Prompt dice roll from UI   
        }
        
        GameResult result = getGameResult();
        if(!gameOver){
            nextTurn();
>>>>>>> 1518c9e4a5e8a769f6f75b1ee15d4575d935b1a9
        }
    }
    
    /**
<<<<<<< HEAD
     * Set selected expansion
     * @param ex Expansion selected
     */
    public static void setExpansion(String ex, boolean val){
        if(ex.equals("UndeadOrAlive")){
            undeadOrAlive = val;
        }else if(ex.equals("OldSaloon")){
            oldSaloon = val;
        }
    }
}
=======
     * Enables or disables expansion dice
     * @param expansionDie Die to be toggled
     * @param enabled boolean toggle
     */
    public static void setExpansionDie(String expansionDie, boolean enabled){
        switch(expansionDie){
            case "Black":
                blackDieEnabled = enabled;
            case "Loudmouth":
                loudmouthDieEnabled = enabled;
            case "Coward":
                cowardDieEnabled = enabled;
        }
    }
}

class GameResult{
    boolean gameOver = false;
    String victoriousFaction;
    int victoriousPlayer;
}
>>>>>>> 1518c9e4a5e8a769f6f75b1ee15d4575d935b1a9
