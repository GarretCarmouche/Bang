package bang;

import java.util.ArrayList;

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
    private static int arrowsRemaining = 9;
    
    private static int defaultDice = 6;
    private static int loudmouthDice = 0;
    private static int cowardDice = 0;
    private static int blackDice = 0;
    
    
    /**
     * Rolls the appropriate dice for the expansion and returns the result
     * @return String[] result of each die roll
     */
    public static String[] rollDice(){
        String[] results = new String[defaultDice+loudmouthDice+cowardDice+blackDice];
        
        //Roll all dice
        int defaultCount = defaultDice;
        for(int i = 0; i < defaultCount; i++){
            Die d = new Die(0);
            results[i] = d.roll();
            if(results[i].equals("Dynamite"))
                defaultDice--;
        }
        
        int blackCount = blackDice;
        for(int i = 0; i < blackCount; i++){
            Die d = new Die(1);
            results[i+defaultCount] = d.roll();
            if(results[i+defaultCount].equals("Dynamite"))
                blackDice--;
        }
        
        int cowardCount = cowardDice;
        for(int i = 0; i < cowardCount; i++){
            Die d = new Die(2);
            results[i+defaultCount+blackCount] = d.roll();
            if(results[i+defaultCount+blackCount].equals("Dynamite"))
                cowardDice--;
        }
        
        int loudmouthCount = loudmouthDice;
        for(int i = 0; i < loudmouthCount; i++){
            Die d = new Die(3);
            results[i+defaultCount+blackCount+cowardCount] = d.roll();
            if(results[i+defaultCount+blackCount+cowardCount].equals("Dynamite"))
                loudmouthDice--;
        }
        
        return results;
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
    
    /**
     * Determines whether the game is over, and if so, who the victor(s) are
     * @return GameResult containing boolean of game completion and victor(s)
     */
    private static GameResult getGameResult(){
        GameResult result = new GameResult();
        
        int numberOfDeputies = 0;
        int numberOfOutlaw = 0;
        int numberOfRenegade = 0;
        
        Player renegade = null;
        
        for (Player p : players) {
            if(p.getCharacter().isAlive()){
                String role = p.getRole();
                switch (role) {
                    case "Sheriff":
                    case "Deputy":
                        numberOfDeputies++;
                        break;
                    case "Outlaw":
                        numberOfOutlaw++;
                        break;
                    case "Renegade":
                        numberOfRenegade++;
                        renegade = p;
                        break;
                    default:
                        break;
                }
            }
            
            if(numberOfOutlaw == 0 && numberOfRenegade == 0){
                result.gameOver = true;
                result.victoriousFaction = "Sheriff";
            }else if(numberOfDeputies == 0){
                if(numberOfOutlaw == 0){
                    if(numberOfRenegade == 1){
                        result.gameOver = true;
                        result.victoriousFaction = "Renegade";
                        result.victoriousPlayer = renegade;
                    }
                }else{
                    result.gameOver = true;
                    result.victoriousFaction = "Outlaw";
                }
            }
        }
        
        return result;
    }
    
    /**
     * Deals damage and returns all arrows from players
     */
    private static void returnArrows(){
        for (Player player : players) {
            Character_Construct character = player.getCharacter();
            character.dealDamage(player.getArrows());
            player.removeArrows();
        }
        arrowsRemaining = 9;
    }
    
    /**
     * Invoked when a player rolls an arrow
     * @param player 
     */
    private static void rolledArrow(Player player){
        player.giveArrow();
        arrowsRemaining--;
        if(arrowsRemaining <= 0){
            returnArrows();
        }
    }
    
    /**
     * Iterate through turns until player turn is reached
     */
    private static void nextTurn(){
        //Init dice counts
        defaultDice = 6;
        blackDice = 0;
        loudmouthDice = 0;
        cowardDice = 0;
        
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
        
        currentTurn = (currentTurn+1) %  players.length;
        int dynamite = 0;
        int gatlingGun = 0;
        
        Player player = players[currentTurn];
        if(player instanceof AI){
            ((AI) player).runTurn();
        }else{
            //Prompt dice roll from UI   
        }
        
        
        String[] result = rollDice();
        for (String result1 : result) {
            switch (result1) {
                case "Arrow":
                    rolledArrow(player);
                    break;
                case "Dynamite":
                    dynamite++;
                    break;
                case "Bull's Eye 1":
                case "Bull's Eye 2":
                    Player target;
                    int range = 2;
                    if (result1.equals("Bull's Eye 1")) {
                        range = 1;
                    }                    
                    if(player instanceof AI){
                        Player right, left;
                        int rightIndex = currentTurn + range - 1, leftIndex = currentTurn - range + 1;
                        do{
                            rightIndex = (rightIndex + 1)%players.length;
                            right = players[rightIndex];
                        }while(right.getCharacter().isAlive() && right != player);
                        
                        do{
                            leftIndex = (leftIndex - 1)%players.length;
                            left = players[leftIndex];
                        }while(left.getCharacter().isAlive() && left != player);
                        
                        ArrayList<Player> attackOptions = new ArrayList<Player>();
                        attackOptions.add(left);
                        attackOptions.add(right);
                        target = ((AI) player).decideAttack(attackOptions);
                    }else{
                        //Prompt bullseye selection UI
                    }
                    break;
                case "Gatling Gun":
                    break;
            }
        }
        if(dynamite >= 3){
            return;
        }
        
        GameResult Gameresult = getGameResult();
        if(!Gameresult.gameOver){
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
    Player victoriousPlayer;
}