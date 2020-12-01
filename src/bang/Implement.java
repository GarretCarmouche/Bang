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
import java.util.Arrays;
/**/
public class Implement
{  
    public String description = "";
    public Enum<?> e;
    public String Name;
    public int Ordinal;
    public int Type;
    public int Health;
    /*Ordinal is placed just in case we need to do other kinds of cards*/
    /*Type is to who this is given or targetting. be it self, choosen, all, or other*/
    public Implement(Enum<?> e)
    {
        this.e = e;
        Ordinal = e.ordinal();
        Name = e.toString();
        if (e instanceof Characters.Character_Name_Base)
        {
            Type = 1;
            int[] HP = new int[] { 3, 5, 6};
            int[] HP2 = new int[] {4, 8, 10, 14};
            if(Arrays.binarySearch(HP, Ordinal) >= 0 && Ordinal == HP[Arrays.binarySearch(HP, Ordinal)])
            {
                Health = 7;
            }
            if(Arrays.binarySearch(HP2,Ordinal) >= 0 && Ordinal == HP2[Arrays.binarySearch(HP2,Ordinal)])
            {
                Health = 9;
            }
            else
            {
                Health = 8;
            }
            switch((Characters.Character_Name_Base) e)
            {
                case Bart_Cassidy:
                    description = "You can take an arrow instead of losing a life point (except to Indians or Dynamite)\n"
                            + " You cannot use this ability if you lose a life point to indian or Dynamite, only for Bull's Eye 1,\n"
                            + " Bull's Eye 2, or Gatling Guns. \n"
                            + "You may not use this ability to take the last arrow remaining in the pile.\n";
                    break;
                case Black_Jack:
                    description = "You may re-roll dynamite (notif you roll three or more!)\n "
                            + "If you roll three or more Dynamite at once (or in total if \n"
                            + "you didn't re-roll them), follow the usual rules(your turn ends, etc.).\n";
                    break;
                case Calamity_Janet:
                    description = "You can use Bull's eye one as Bull's eye 2 and vice-versa\n";
                    break;
                case El_Gringo:
                    description = "When a player makes you lose one or more life points, he must take an arrow. \n"
                            + "Life points lost to Indians or Dynamite are not affected\n";
                    break;
                case Jesse_Jones:
                    description = "If you have four life points or less, you gain two if you use beer for yourself.\n"
                            + " For example, if you have four life points and use two bears,\n "
                            + "you get four life points.\n";
                    break;
                case Jourdonnais:
                    description = "You never lose more than one life point to Indians\n";
                    break;
                case Kit_Carlson:
                    description = "for each gatlin you may discard one arrow from any player. \n"
                            + "You may choose to discard your own arrows. \n"
                            + "If you roll three gatlin, you discard \n"
                            + "all your own arrows, pluss three from any player(s).\n"
                            + "(of course, you still deal one damage to each other player)\n";
                    break;
                case Lucky_Duke:
                    description = "You may make one extra re-roll.\n "
                            + "You may roll the dice a total of four times on your own\n";
                    break;
                case Paul_Regret:
                    description = "You never lose life to the Gatling Gun.\n";
                    break;
                case Pedro_Ramirez:
                    description = "Each time you lsoe a life point, you may discard one of your arrows.\n "
                            + "You still lose the life point when you use this ability.\n";
                    break;
                case Rose_Doolan:
                    description = "You may use one Bull's eye 1 or Bull's eye 2 for players sitting one place further.\n"
                            + " With Bull's eye 1 you may hit a player sitting up to two places away,\n"
                            + " and with Bull's eye 2 you may hit a player sitting two or three places away.\n";
                    break;
                case Sid_Ketchum:
                    description = "At the beginning of your turn, any player of your choice gains one life point.\n"
                            + " You may also choose yourself.\n";
                    break;
                case Slab_The_Killer:
                    description = "once per turn, you can use a beer to double a Bull's eye 1 or Bull's eye 2.\n "
                            + "The dice you double take two life points away from \n"
                            + "the same player (you can't choose two different players).\n "
                            + "The beer in this case does not provide any life points.\n";
                    break;
                case Suzy_Lafayette:
                    description = "If you didn't roll any Bull's eye 2 or Bull's eye 2, you gain two life points.\n "
                            + "This only applies at the end of your turn, not during your re-rolls.\n";
                    break;
                case Vulture_Sam:
                    description = "Each time another player is eliminatted, you gain two life points.\n";
                    break;
                case Willy_The_Kid:
                    description = "You only need two gatlin to use the Gatling Gun.\n "
                            + "You can activate the Gatling Gun only once per turn\n"
                            + " even if you roll more than two gatlin results.\n";
                    break;
                    
            }
            
        }
        if(e instanceof Characters.Character_Name_Old_Saloon)
        {
            Type = 1;
            int[] HP = new int[]{0, 4, 5};
            int[] HP2 = new int[] {2,3};
            if(Arrays.binarySearch(HP, Ordinal) >= 0 && Ordinal == HP[Arrays.binarySearch(HP, Ordinal)])
            {
                Health = 7;
            }
            if(Arrays.binarySearch(HP2,Ordinal) >= 0 && Ordinal == HP2[Arrays.binarySearch(HP2,Ordinal)])
            {
                Health = 9;
            }
            else
            {
                Health = 8;
            }
            switch((Characters.Character_Name_Old_Saloon) e)
            {
                case Jose_Delgado:
                    description = "You may use the Loudmouth die without replacing a base die (roll six die total). \n"
                            + "If you use the Loudmouth die, you roll 6 dice total; if you sue the Coward die, 5. \n"
                            + "You cannot use the Loudmouth and the Coward dice together.\n";
                    break;
                case Tequila_Joe:
                    description = "You may use the Coward die without replacing a base\n "
                            + "die(roll six dice total)If you use the Coward die, \n"
                            + "you roll 6 dice total; if you use the Loudmouth die, 5. You cannot use the\n"
                            +"Loudmouth and the Coward dice together.\n";
                    break;
                case Apache_Kid:
                    description = "If you roll  arrow, you may take the Indian\n" 
                            + "Chief’s Arrow from another player.";
                    break;
                case Bill_Noface:
                    description = "Apply arrow results only after your last roll.\n" 
                            + "Your last roll isn’t necessarily the third one,\n" 
                            + "you may stop earlier, as normal.";
                    break;
                case Elena_Fuente:
                    description = "Each time you roll one or more arrow , you\n" 
                            + "may give one of those arrows to a player of\n" 
                            + "your choice.";
                    break;
                case Vera_Custer:
                    description = "Each time you must lose life points for Bull's eye 1\n" 
                            + "or Bull's eye 2, you lose 1 life point less.\n" 
                            + "For example, if someone hits you with just\n" 
                            + "one Bull's eye 1 , you don’t lose any life points at all.\n" 
                            + "Remember that, for example, Bull's eye 1 counts as two Bull's eye 1.\n";
                    break;
                case Doc_Holyday:
                    description = "Each time you use three or more\n" 
                            + "Bull's eye 1 and/or Bull's eye 2, you also regain 2 life points.\n" 
                            + "Remember that, for example, Bull's eye 1 counts as two Bull's eye 1.\n";
                    break;
                case Molly_Stark:
                    description = "Each time another player must lose 1 or\n" 
                            + "more life points, you can lose them in\n" 
                            + "his place.\n" 
                            + "You may never choose to lose more life\n" 
                            + "points than you have.";
                    break;
            }
        }
        if(e instanceof Characters.Character_Name_Undead_Or_Alive)
        {
             Type = 1;
            int[] HP = new int[]{0, 4};
            int[] HP2 = new int[] {3};
            if(Arrays.binarySearch(HP, Ordinal) >= 0 && Ordinal == HP[Arrays.binarySearch(HP, Ordinal)])
            {
                Health = 7;
            }
            if(Arrays.binarySearch(HP2,Ordinal) >= 0 && Ordinal == HP2[Arrays.binarySearch(HP2,Ordinal)])
            {
                Health = 9;
            }
            else
            {
                Health = 8;
            }
            switch((Characters.Character_Name_Undead_Or_Alive) e)
            {
                case Greg_Digger:
                    description = "You may use each whiskey you rill twice.\n ";
                    break;
                case Herb_Hunter:
                    description = "If another player loses two or more life\n" 
                            + "points during your turn, they must take\n" 
                            + "a Duel Wound token.\n";
                    break;
                case Pat_Brennan:
                    description = "At the beginning of your turn, you may move\n" 
                            + "one Rage card from one player to another.\n" 
                            + "You can choose yourself\n";
                    break;
                case Pixie_Pete:
                    description = "Each time you draw a Rage card, draw\n" 
                            + "two and choose one to keep.\n" 
                            + "Shuffle the unchosen card back into\n" 
                            + "the pile.";
                    break;
                case Sam_The_Healer:
                    description = "Each time you use a fight a duel, you may choose\n" 
                            + "one player to gain one life point.\n" 
                            + "You may choose yourself. When shooting back,\n" 
                            + "this ability doesn’t trigger; it triggers only when\n" 
                            + "you challenge someone during your own turn.\n";
                    break;
                case Sean_Mallory:
                    description = "You may reroll a Duel die once on your turn.\n" 
                            + "You can only use this ability during your\n" + 
                            "own turn, not when another player gives\n" 
                            + "you a Duel die during their turn\n";
                    break;
                case Belle_Star:
                    description = "After each of yourdice rolls, you can change\n"
                            + " one dynamite to gatlin (not if you roll three or more dynamite)\n";
                    break;
                case Chuck_Wengam:
                    description = "Once per turn, you may lose one life\n" 
                            + "point to turn one of your dice to the\n" 
                            + "side of your choice (except if you\n" 
                            + "rolled three or more!).\n";
                    break;
            }
        }
    }
    public String toString()
    {
        return Name;
    }
}
