/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.*;
/**
 *
 * @author Garret
 */

public class Player {
    
    private Character_Construct character;
    private String role;
    private int arrows = 0;
    
    public Player(Character_Construct character, String role){
        this.character = character;
        this.role = role;
    }
    
    public Player(){
        
    }
    
    public String getRole(){
        return role;
    }
    
    public Character_Construct getCharacter(){
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
