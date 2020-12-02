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

/*This will be used for character construct*/
public class Character_Construct 
{
    private Characters.Character_Name_Base Name_List_1;
    private Characters.Character_Name_Old_Saloon Name_List_2;
    private Characters.Character_Name_Undead_Or_Alive Name_List_3;
    private Characters.Health Hit_Points;
    private int Life_Points;
    
    /*Constructor for based characters*/
    public Character_Construct(Characters.Character_Name_Base Names, int Health)
    {
        this.Name_List_1 = Names;
        this.Hit_Points = Characters.Health.Life;
        this.Life_Points = Health;
    }
    
    /*Constructor for the Old Saloon characters*/
    public Character_Construct(Characters.Character_Name_Old_Saloon Names, int Health)
    {
        this.Name_List_2 = Names;
        this.Hit_Points = Characters.Health.Life;
        this.Life_Points = Health;
    }
    
    /*Constructor for the Undead or alive characters*/
    public Character_Construct(Characters.Character_Name_Undead_Or_Alive Names, int Health)
    {
        this.Name_List_3 = Names;
        this.Hit_Points = Characters.Health.Life;
        this.Life_Points = Health;
    }
    
    /*Make to string to allow name to be displayed*/
    public String toString()
    {
        String retval = "";
        switch(Name_List_1)
        {
            case Bart_Cassidy:
                retval += "Bart Cassidy";
                break;
            case Black_Jack:
                retval += "Black Jack";
                break;
            case Calamity_Janet:
                retval += "Calamity Janet";
                break;
            case El_Gringo:
                retval += "El Gringo";
                break;
            case Jesse_Jones:
                retval += "Jesse Jones";
                break;
            case Jourdonnais:
                retval += "Jourdonnais";
                break;
            case Kit_Carlson:
                retval += "Kit Carlson";
                break;
            case Lucky_Duke:
                retval += "Lucky Duke";
                break;
            case Paul_Regret:
                retval += "Paul Regret";
                break;
            case Pedro_Ramirez:
                retval += "Pedro Ramirez";
                break;
            case Rose_Doolan:
                retval += "Rose Doolan";
                break;
            case Sid_Ketchum:
                retval += "Sid Ketchum";
                break;
            case Slab_The_Killer:
                retval += "Slab The Killer";
                break;
            case Suzy_Lafayette:
                retval += "Suzy Lafayette";
                break;
            case Vulture_Sam:
                retval += "Vulture Sam";
                break;
            case Willy_The_Kid:
                retval += "Willy The Kid";
                break;
        }
        switch(Name_List_2)
        {
            case Jose_Delgado:
                retval += "Jose Delgado";
                break;
            case Tequila_Joe:
                retval += "Tequila Joe";
                break;
            case Apache_Kid:
                retval += "Apache Kid";
                break;
            case Bill_Noface:
                retval += "Bill Noface";
                break;
            case Elena_Fuente:
                retval += "Elena Fuente";
                break;
            case Vera_Custer:
                retval += "Vera Custer";
                break;
            case Doc_Holyday:
                retval += "Doc Holyday";
                break;
            case Molly_Stark:
                retval += "Molly Stark";
                break;
        }
        switch(Name_List_3)
        {
            case Greg_Digger:
                retval += "Greg Digger";
                break;
            case Herb_Hunter:
                retval += "Herb Hunter";
                break;
            case Pat_Brennan:
                retval += "Pat Brennan";
                break;
            case Pixie_Pete:
                retval += "Pixie Pete";
                break;
            case Sam_The_Healer:
                retval += "Sam The Healer";
                break;
            case Sean_Mallory:
                retval += "Sean Mallory";
                break;
            case Belle_Star:
                retval += "Belle Star";
                break;
            case Chuck_Wengam:
                retval += "Chuck Wengam";
                break;
        }
        switch(Hit_Points)
        {
            case Life:
                retval += Life_Points;
                break;
        }

        return retval;
    }
    
    public Characters.Character_Name_Base getBaseName()
    {
        return Name_List_1;
    }
    
    
    public Characters.Character_Name_Old_Saloon getSaloonName()
    {
        return Name_List_2;
    }
    
    public Characters.Character_Name_Undead_Or_Alive getUndeadName()
    {
        return Name_List_3;
    }
    
    public int getHealth()
    {
        return Life_Points;
    }
    
    public boolean isAlive(){
        return Life_Points > 0;
    }
    
    public void dealDamage(int amount){
        Life_Points -= amount;
    }
    
}
