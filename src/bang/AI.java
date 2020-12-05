package bang;

import java.util.*;

/**
 *
 * @author Garret
 */
public class AI extends Player {
    ArrayList<Integer> opinions = new ArrayList<Integer>();
    ArrayList<Player> players = new ArrayList<Player>();
    
    /**
     * AI constructor
     */
    public AI(Implement ch, String role, int ID){
        super(ch, role, ID);
    }
    
    /**
     * Rolls a given number of dice and returns a list of results
     * @param dice Number of dice to roll
     * @return List of length dice results
     */
    public String[] rollDice(int dice){
        return Gameplay.rollDice();
    }
    
    public void runTurn(){
        int dice = 6;
        String[] diceResults = rollDice(dice);
        Bang.showDice(diceResults, this.toString());
    }
    
    /**
     * Returns the opinion of a player
     * @param player Player to get opinion of
     * @return The int opinion of the player
     */
    private int getPlayerOpinion(Player player){
        int playerIndex = players.indexOf(player);
        if(playerIndex == -1){
            players.add(player);
            opinions.add(0);
            playerIndex = players.size() - 1;
        }
        return opinions.get(playerIndex);
    }
    
    /**
     * Decides between the given players which has the highest opinion
     * @param healablePlayers ArrayList of players to decide from
     * @return Player with highest opinion
     */
    public Player decideHeal(ArrayList<Player> healablePlayers){
        Player healPlayer = healablePlayers.get(0);
        int healOpinion = getPlayerOpinion(healPlayer);
        
        for(int i = 0; i < healablePlayers.size(); i++){
            Player player = healablePlayers.get(i);
            int opinion = getPlayerOpinion(player);
            if(opinion > healOpinion){
                healOpinion = opinion;
                healPlayer = player;
            }
        }
        
        return healPlayer;
    }
    
    /**
     * Decides between the given players which has the lowest opinion
     * @param attackablePlayers ArrayList of players to decide from
     * @return Player with lowest opinion
     */
    public Player decideAttack(ArrayList<Player> attackablePlayers){
        Player attackPlayer = attackablePlayers.get(0);
        int attackOpinion = getPlayerOpinion(attackPlayer);
        
        for(int i = 0; i < attackablePlayers.size(); i++){
            Player player = attackablePlayers.get(i);
            int opinion = getPlayerOpinion(player);
            if(opinion < attackOpinion){
                attackOpinion = opinion;
                attackPlayer = player;
            }
        }
        
        return attackPlayer;
    }
    
    /**
     * Method should be invoked when a player interacts with another intentionally (give heal/damage)
     * @param source Player making the decision
     * @param target Player receiving damage/health
     * @param hostile Boolean whether the action was damage or healing (true: damage, false: healing)
     */
    public void playerInteracted(Player source, Player target, boolean hostile){
        int indexOfTarget = players.indexOf(target);
        int indexOfSource = players.indexOf(source);
        int targetOpinion;
        int sourceOpinion;
        
        if(indexOfTarget == -1){
            indexOfTarget = players.size();
            players.add(target);
            opinions.set(indexOfTarget, 0);
        }
        
        if(indexOfSource == -1){
            indexOfSource = players.size();
            players.add(source);
            opinions.set(indexOfSource, 0);
        }
        
        targetOpinion = opinions.get(indexOfTarget);
        sourceOpinion = opinions.get(indexOfSource);
        
        if(hostile){
            sourceOpinion = sourceOpinion - targetOpinion;
            targetOpinion = targetOpinion - sourceOpinion;
        }
        else{
            sourceOpinion = sourceOpinion + targetOpinion;
            targetOpinion = targetOpinion + sourceOpinion;
        }
        
        
        opinions.set(indexOfSource, sourceOpinion);
        opinions.set(indexOfTarget, targetOpinion);
    }
    
    /**
     * Method should be invoked at the start of the game when the sheriff is revealed
     * @param sheriff Player who is the sheriff role
     */
    public void revealSheriff(Player sheriff){
        
    }
    
    /**
     * Method should be invoked when a player is deliberately attacked
     * @param source Player making the attack
     * @param target Player receiving the attack
     */
    public void playerAttacked(Player source, Player target){
        playerInteracted(source, target, false);
    }
    
    /**
     * Method should be invoked when a player is deliberately healed
     * @param source Player healing
     * @param target Player being healed
     */
    public void playerHealed(Player source, Player target){
        playerInteracted(source, target, false);
    }
}
