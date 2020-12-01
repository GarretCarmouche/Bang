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
public class Character_Implement 
{
    private ArrayList<Character_Construct> Character = new ArrayList<Character_Construct>();
    
    public Character_Implement(int x)
    {
        int Character_Selection_Number = x;
        Give_Character(Character_Selection_Number);
    }
    
    private void Give_Character(int y)
    {
        String Character_Wanted = Integer.toString(y);
        int i = 7;
        int j = 8;
        int k = 9;
        switch(Character_Wanted)
        {
            case "1":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Bart_Cassidy,j));
                break;
            case "2":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Black_Jack,j));
                break;
            case "3":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Calamity_Janet,j));
                break;
            case "4":
                Character.add(new Character_Construct(Characters.Character_Name_Base.El_Gringo,i));
                break;
            case "5":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Jesse_Jones,k));
                break;
            case "6":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Jourdonnais,i));
                break;
            case "7":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Kit_Carlson,i));
                break;
            case "8":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Lucky_Duke,j));
                break;
            case "9":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Paul_Regret,k));
                break;
            case "10":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Pedro_Ramirez,j));
                break;
            case "11":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Rose_Doolan,k));
                break;
            case "12":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Sid_Ketchum,j));
                break;
            case "13":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Slab_The_Killer,j));
                break;
            case "14":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Suzy_Lafayette,j));
                break;
            case "15":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Vulture_Sam,k));
                break;
            case "16":
                Character.add(new Character_Construct(Characters.Character_Name_Base.Willy_The_Kid,j));
                break;
            case "17":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Apache_Kid,k));
                break;
            case "18":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Bill_Noface,k));
                break;
            case "19":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Doc_Holyday,j));
                break;
            case "20":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Elena_Fuente,i));
                break;
            case "21":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Jose_Delgado,i));
                break;
            case "22":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Molly_Stark,j));
                break;
            case "23":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Tequila_Joe,i));
                break;
            case "24":
                Character.add(new Character_Construct(Characters.Character_Name_Old_Saloon.Vera_Custer,i));
                break;
            case "25":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Belle_Star,j));
                break;
            case "26":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Chuck_Wengam,j));
                break;
            case "27":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Greg_Digger,i));
                break;
            case "28":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Herb_Hunter,j));
                break;
            case "29":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Pat_Brennan,j));
                break;
            case "30":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Pixie_Pete,k));
                break;
            case "31":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Sam_The_Healer,i));
                break;
            case "32":
                Character.add(new Character_Construct(Characters.Character_Name_Undead_Or_Alive.Sean_Mallory,i));
                break;
                
        }
    }
}
