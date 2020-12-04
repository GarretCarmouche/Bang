package bang;

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
    
    public static void startGame(){
        
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
        }
    }
    
    /**
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
