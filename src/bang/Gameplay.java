package bang;

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
        }
    }
    
    /**
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
