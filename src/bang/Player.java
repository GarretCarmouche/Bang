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
    
    public Player(Implement character, String role){
        this.character = character;
        this.role = role;
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
    
    public int getArrows(){
        return arrows;
    }
    
    public void removeArrows(){
        arrows = 0;
    }
}
