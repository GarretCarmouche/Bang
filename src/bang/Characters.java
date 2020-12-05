/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

/**
 *
 * @author Digimon2000
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

/*This code will contain character names for later implementation*/
public class Characters 
{
    /*List of names of the base game characters*/
    public enum Character_Name_Base {Bart_Cassidy,Black_Jack, Calamity_Janet, El_Gringo,Jesse_Jones,
    Jourdonnais,Kit_Carlson, Lucky_Duke, Paul_Regret, Pedro_Ramirez, Rose_Doolan, Sid_Ketchum,
    Slab_The_Killer,Suzy_Lafayette, Vulture_Sam, Willy_The_Kid}
    
    /*List of names of the old saloon characters*/
    public enum Character_Name_Old_Saloon {Jose_Delgado, Tequila_Joe, Apache_Kid, 
    Bill_Noface, Elena_Fuente, Vera_Custer, Doc_Holyday, Molly_Stark}
    
    /*List of names of the Undead or Alive characters*/
    public enum Character_Name_Undead_Or_Alive {Greg_Digger, Herb_Hunter, Pat_Brennan, 
    Pixie_Pete, Sam_The_Healer, Sean_Mallory, Belle_Star, Chuck_Wengam}
    
    public static ArrayDeque<Implement> DrawPile = new ArrayDeque<Implement>();
    public static ArrayList<Implement> DiscardPile = new ArrayList<Implement>(); /*Implemnted just in case this is changed for all cards in general*/
    public Characters(){}
    public static void fillCharacterDeck(int numPlayers)
    {
        ArrayList<Character_Name_Base> MainCharList = new ArrayList<Character_Name_Base>();
        for(Character_Name_Base e: Character_Name_Base.values())
        {
            MainCharList.add(e);
        }
        
        ArrayList<Character_Name_Old_Saloon> Expan1CharList = new ArrayList<Character_Name_Old_Saloon>();
        for(Character_Name_Old_Saloon e: Character_Name_Old_Saloon.values())
        {
            Expan1CharList.add(e);
        }
        
        ArrayList<Character_Name_Undead_Or_Alive> Expan2CharList = new ArrayList<Character_Name_Undead_Or_Alive>();
        for(Character_Name_Undead_Or_Alive e: Character_Name_Undead_Or_Alive.values())
        {
            Expan2CharList.add(e);
        }
        
        for(int n = 0; n<numPlayers; n++)
        {
            System.out.println(n);
            DrawPile.add(new Implement(MainCharList.remove((int)(Math.random()*MainCharList.size()))));
        }
    }
    public static Implement draw() throws Exception
    {
        if(DrawPile.size() > 0)
            return DrawPile.pop();
        else
            throw new Exception("This deck is empty!");
    }
    public static int size()
    {
        return DrawPile.size();
    }
}
