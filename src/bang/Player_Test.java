/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.ArrayList;

/**
 *
 * @author Digimon2000
 */

/*stand alone player used to test out program implementations I am making*/
public class Player_Test 
{
    
    public int Bangs;
    public int Identification_Num;
    public String Name;
    public Given_Role.Role role;
    public int MaxLifePoints;
    public int WeaponRange;
    public int Range;
    public int Distance;
    //private Character char;
    public Player_Test(int Identification_Num, String Name)
    {
        this.Identification_Num = Identification_Num;
        this.Name = Name;
    }
    
    public ArrayList<Implement> Hand = new ArrayList<Implement>();
    public ArrayList<Implement> Field = new ArrayList<Implement>();
    
    public int C_LifePoints;
    public int character = -1; /*No current character*/
    public Implement characterCard;
    public String toString()
    {
        return Name;
    }
    
    
}
