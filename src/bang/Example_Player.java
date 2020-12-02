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
public class Example_Player
{
    private Character_List Character;
    private int MaxHealth;
    private int Health;
    private String Ability;
    
    public String getAbility()
    {
        return this.Ability;
    }
    public String getSkill()
    {
        return Character_List.getSkillText(getName());
    }
    
    public void setAbility(String Ability)
    {
        this.Ability = Ability;
    }
    public void setCharacter(Character_List Character)
    {
        this.Character = Character;
        
    }
    public String getName()
    {
        return Character.getName();
    }
    
    public void setMaxHealth(int MaxHealth)
    {
        this.MaxHealth = MaxHealth;
        this.Health = MaxHealth;
    }
    
    public int getMaxHealth()
    {
        return MaxHealth;
    }
    
    public int getHealth()
    {
        return Health;
    }
}
