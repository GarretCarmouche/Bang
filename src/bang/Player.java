package bang;

import java.util.ArrayList;
/**
 *
 * @author Garret Carmouche
 */

public class Player {
    
    private Implement character;
    private String role;
    private int arrows = 0;
    private int ID;
    
    public Player(Implement character, String role, int ID){
        this.character = character;
        this.role = role;
        this.ID = ID;
    }
    
    
    public Player(){
        
    }
    
    public String getRole(){
        return role;
    }
    
    public Implement getCharacter(){
        return character;
    }
    
    public void giveArrow(int number){
        arrows += number;
    }
    
    public void giveArrow(){
        giveArrow(1);
    }
    
    public void removeArrow(){
        if(arrows > 0)
            arrows--;
    }
    
    public int getArrows(){
        return arrows;
    }
    
    public void removeArrows(){
        arrows = 0;
    }
    
    public String toString(){
        return "Player "+ID;
    }
}
