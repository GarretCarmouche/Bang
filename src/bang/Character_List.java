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

/*Probable replacement for last implement and character
a simpler version with less steps to implement*/
public class Character_List
{    
    public static String BARTCASSIDY = "Bart Cassidy";
    public static String BLACKJACK = "Black Jack";
    public static String CALAMITYJANET = "Calamity Janet";
    public static String ELGRINGO = "El Gringo";
    public static String JESSEJONES = "Jesse Jones";
    public static String JOURDONNAIS = "Jourdonnais";
    public static String KITCARLSON = "Kit Carlson";
    public static String LUCKYDUKE = "Lucky Duke";
    public static String PAULREGRET = "Paul Regret";
    public static String PEDRORAMIREZ = "Pedro Ramirez";
    public static String ROSEDOOLAN = "Rose Doolan";
    public static String SIDKETCHUM = "Sid Ketchum";
    public static String SLABTHEKILLER = "Slab The Killer";
    public static String SUZYLAFAYETTE = "Suzy Lafayette";
    public static String VULTURESAM = "Vulture Sam" ;
    public static String WILLYTHEKID = "Willy The Kid";
    public static String CharactersBaseGame[] = {BARTCASSIDY, BLACKJACK, CALAMITYJANET, 
        ELGRINGO, JESSEJONES, JOURDONNAIS, KITCARLSON, LUCKYDUKE, PAULREGRET, 
        PEDRORAMIREZ, ROSEDOOLAN, SIDKETCHUM, SLABTHEKILLER, SUZYLAFAYETTE, 
        VULTURESAM, WILLYTHEKID};
    
    
    public static String JOSEDELGADO = "Jose Delgado";
    public static String TEQUILAJOE = "Tequila Joe";
    public static String APACHEKID = "Apache Kid";
    public static String BILLNOFACE = "Bill Noface";
    public static String ELENAFUENTE = "Elena Fuente";
    public static String VERACUSTER = "Vera Custer";
    public static String DOCHOLYDAY = "Doc Holyday";
    public static String MOLLYSTARK = "Molly Stark";
    public static String CharacterOldSaloon[] = {JOSEDELGADO, TEQUILAJOE, APACHEKID, 
        BILLNOFACE, ELENAFUENTE, VERACUSTER, DOCHOLYDAY, MOLLYSTARK};
    
    public static String GREGDIGGER = "Greg Digger";
    public static String HERBHUNTER = "Herb Hunter";
    public static String PATBRENNAN = "Pat Brennan";
    public static String PIXIEPETE = "Pixie Pete";
    public static String SAMTHEHEALER = "Sam The Healer";
    public static String SEANMALLORY = "Sean Mallory";
    public static String BELLESTAR = "Belle Star";
    public static String CHUCKWENGAM = "Chuck Wengam";
    public static String CharacterUndeadOrAlive[] = {GREGDIGGER, HERBHUNTER,
        PATBRENNAN, PIXIEPETE, SAMTHEHEALER, SEANMALLORY, BELLESTAR, CHUCKWENGAM};
    
    private String Name;
    
    public void setName(String Name)
    {
        this.Name = Name;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public static int getSetHealth(String Name)
    {
        if(Name.equals(ELGRINGO) || Name.equals(JOURDONNAIS) || Name.equals(KITCARLSON) || 
                Name.equals(JOSEDELGADO) || Name.equals(TEQUILAJOE) || Name.equals(ELENAFUENTE) || 
                Name.equals(VERACUSTER) || Name.equals(GREGDIGGER) || Name.equals(SAMTHEHEALER))
        {
           return 7;
        }
        else if(Name.equals(JESSEJONES) || Name.equals(PAULREGRET) || Name.equals(ROSEDOOLAN) || 
                Name.equals(VULTURESAM) || Name.equals(APACHEKID) || Name.equals(BILLNOFACE) || 
                Name.equals(PIXIEPETE))
        {
            return 9;
        }
        else
        {
            return 8;
        }
    }
    
    /*else if hell due to not having time to rewrite to make switch statement possible*/
    public static String getSkillText(String Name)
    {
        if(Name.equals(BARTCASSIDY))
        {
            return  "You can take an arrow instead of losing a life point (except to Indians or Dynamite)\n"
                            + " You cannot use this ability if you lose a life point to indian or Dynamite, only for Bull's Eye 1,\n"
                            + " Bull's Eye 2, or Gatling Guns. \n"
                            + "You may not use this ability to take the last arrow remaining in the pile.\n";
        }
        else if(Name.equals(BLACKJACK))
        {
            return "You may re-roll dynamite (notif you roll three or more!)\n "
                            + "If you roll three or more Dynamite at once (or in total if \n"
                            + "you didn't re-roll them), follow the usual rules(your turn ends, etc.).\n";
        }
        else if(Name.equals(CALAMITYJANET))
        {
            return "You can use Bull's eye one as Bull's eye 2 and vice-versa\n";
        }
        else if(Name.equals(ELGRINGO))
        {
            return "When a player makes you lose one or more life points, he must take an arrow. \n"
                            + "Life points lost to Indians or Dynamite are not affected\n";
        }
        else if(Name.equals(JESSEJONES))
        {
            return "If you have four life points or less, you gain two if you use beer for yourself.\n"
                            + " For example, if you have four life points and use two bears,\n "
                            + "you get four life points.\n";
        }
        else if(Name.equals(JOURDONNAIS))
        {
            return "You never lose more than one life point to Indians\n";
        }
        else if(Name.equals(KITCARLSON))
        {
            return "for each gatlin you may discard one arrow from any player. \n"
                            + "You may choose to discard your own arrows. \n"
                            + "If you roll three gatlin, you discard \n"
                            + "all your own arrows, pluss three from any player(s).\n"
                            + "(of course, you still deal one damage to each other player)\n";
        }
        else if(Name.equals(LUCKYDUKE))
        {
            return "You may make one extra re-roll.\n "
                            + "You may roll the dice a total of four times on your own\n";
        }
        else if(Name.equals(PAULREGRET))
        {
            return "You never lose life to the Gatling Gun.\n";
        }
        else if(Name.equals(PEDRORAMIREZ))
        {
            return "Each time you lsoe a life point, you may discard one of your arrows.\n "
                            + "You still lose the life point when you use this ability.\n";
        }
        else if(Name.equals(ROSEDOOLAN))
        {
            return "You may use one Bull's eye 1 or Bull's eye 2 for players sitting one place further.\n"
                            + " With Bull's eye 1 you may hit a player sitting up to two places away,\n"
                            + " and with Bull's eye 2 you may hit a player sitting two or three places away.\n";
        }
        else if(Name.equals(SIDKETCHUM))
        {
            return "At the beginning of your turn, any player of your choice gains one life point.\n"
                            + " You may also choose yourself.\n";
        }
        else if(Name.equals(SLABTHEKILLER))
        {
            return "once per turn, you can use a beer to double a Bull's eye 1 or Bull's eye 2.\n "
                            + "The dice you double take two life points away from \n"
                            + "the same player (you can't choose two different players).\n "
                            + "The beer in this case does not provide any life points.\n";
        }
        else if(Name.equals(SUZYLAFAYETTE))
        {
            return "If you didn't roll any Bull's eye 2 or Bull's eye 2, you gain two life points.\n "
                            + "This only applies at the end of your turn, not during your re-rolls.\n";
        }
        else if(Name.equals(VULTURESAM))
        {
            return "Each time another player is eliminatted, you gain two life points.\n";
        }
        else if(Name.equals(WILLYTHEKID))
        {
            return "You only need two gatlin to use the Gatling Gun.\n "
                            + "You can activate the Gatling Gun only once per turn\n"
                            + " even if you roll more than two gatlin results.\n";
        }
        else if(Name.equals(JOSEDELGADO))
        {
            return "You may use the Loudmouth die without replacing a base die (roll six die total). \n"
                            + "If you use the Loudmouth die, you roll 6 dice total; if you sue the Coward die, 5. \n"
                            + "You cannot use the Loudmouth and the Coward dice together.\n";
        }
        else if(Name.equals(TEQUILAJOE))
        {
            return "You may use the Coward die without replacing a base\n "
                            + "die(roll six dice total)If you use the Coward die, \n"
                            + "you roll 6 dice total; if you use the Loudmouth die, 5. You cannot use the\n"
                            +"Loudmouth and the Coward dice together.\n";
        }
        else if(Name.equals(APACHEKID))
        {
            return "If you roll  arrow, you may take the Indian\n" 
                            + "Chief’s Arrow from another player.";
        }
        else if(Name.equals(BILLNOFACE))
        {
            return "Apply arrow results only after your last roll.\n" 
                            + "Your last roll isn’t necessarily the third one,\n" 
                            + "you may stop earlier, as normal.";
        }
        else if(Name.equals(ELENAFUENTE))
        {
            return "Each time you roll one or more arrow , you\n" 
                            + "may give one of those arrows to a player of\n" 
                            + "your choice.";
        }
        else if(Name.equals(VERACUSTER))
        {
            return "Each time you must lose life points for Bull's eye 1\n" 
                            + "or Bull's eye 2, you lose 1 life point less.\n" 
                            + "For example, if someone hits you with just\n" 
                            + "one Bull's eye 1 , you don’t lose any life points at all.\n" 
                            + "Remember that, for example, Bull's eye 1 counts as two Bull's eye 1.\n";
        }
        else if(Name.equals(DOCHOLYDAY))
        {
            return "Each time you use three or more\n" 
                            + "Bull's eye 1 and/or Bull's eye 2, you also regain 2 life points.\n" 
                            + "Remember that, for example, Bull's eye 1 counts as two Bull's eye 1.\n";
        }
        else if(Name.equals(MOLLYSTARK))
        {
            return "Each time another player must lose 1 or\n" 
                            + "more life points, you can lose them in\n" 
                            + "his place.\n" 
                            + "You may never choose to lose more life\n" 
                            + "points than you have.";
        }
        else if(Name.equals(GREGDIGGER))
        {
            return "You may use each whiskey you rill twice.\n ";
        }
        else if(Name.equals(HERBHUNTER))
        {
            return "If another player loses two or more life\n" 
                            + "points during your turn, they must take\n" 
                            + "a Duel Wound token.\n";
        }
        else if(Name.equals(PATBRENNAN))
        {
            return "At the beginning of your turn, you may move\n" 
                            + "one Rage card from one player to another.\n" 
                            + "You can choose yourself\n";
        }
        else if(Name.equals(PIXIEPETE))
        {
            return "Each time you draw a Rage card, draw\n" 
                            + "two and choose one to keep.\n" 
                            + "Shuffle the unchosen card back into\n" 
                            + "the pile.";
        }
        else if(Name.equals(SAMTHEHEALER))
        {
            return "Each time you use a fight a duel, you may choose\n" 
                            + "one player to gain one life point.\n" 
                            + "You may choose yourself. When shooting back,\n" 
                            + "this ability doesn’t trigger; it triggers only when\n" 
                            + "you challenge someone during your own turn.\n";
        }
        else if(Name.equals(SEANMALLORY))
        {
            return "You may reroll a Duel die once on your turn.\n" 
                            + "You can only use this ability during your\n" + 
                            "own turn, not when another player gives\n" 
                            + "you a Duel die during their turn\n";
        }
        else if(Name.equals(BELLESTAR))
        {
            return "After each of yourdice rolls, you can change\n"
                            + " one dynamite to gatlin (not if you roll three or more dynamite)\n";
        }
        else if(Name.equals(CHUCKWENGAM))
        {
            return "Once per turn, you may lose one life\n" 
                            + "point to turn one of your dice to the\n" 
                            + "side of your choice (except if you\n" 
                            + "rolled three or more!).\n";
        }
        else
        {
            throw new RuntimeException("ERROR!: INVALID CHARACTER!!!");
        }
    }
}
