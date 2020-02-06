
package too.many.gobbos;

import java.util.ArrayList;
import java.util.Scanner;
import static too.many.gobbos.Gamemain.ran;

/**
 *
 * @author Timo
 */

public class Wander {
    private static Monster M = new Monster();
    private static Gamechar Gc = new Gamechar();
    
    static Scanner reader = new Scanner(System.in);
    static Scanner reader2 = new Scanner(System.in);
    
    private static int round = 0;
    private static int kills = 0;
    private static boolean firststrike = true;
    private static String attack = "default";
    private static boolean runm = false;
    private static boolean runc = false;
    
    private static int Cbonusdmg = 0;
    private static int Cbonusdodge = 0;
    private static int Cbonushp = 0;
    private static int Cbonushit = 0;
    private static int Cbonusarmor = 1;
    private static int Cbonuscrit = 0;
    
    private static int Mbonusdmg = 0;
    private static int Mbonusdodge = 0;
    private static int Mbonushp = 0;
    private static int Mbonushit = 0;
    private static int Mbonusarmor = 1;
    
    static ArrayList <String> buffp = new ArrayList();
    static ArrayList <Integer> timep = new ArrayList();
    static ArrayList <String> buffm = new ArrayList();
    static ArrayList <Integer> timem = new ArrayList();

   
 

    
    
    Wander(){
    
    }
    
    public static Gamechar wander(Gamechar gc){//Player wanders around and doesn't find a monster
        Gc = gc;
        int x = ran.nextInt(30) + 1;
        int d = ran.nextInt(10) + 1;
        switch (x){//Selects one of neutral events
            case 1://Healer event
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: 
            case 9:
            case 10:
                System.out.println("You come by a friendly healer that offers to heal you 50hp for 100 gold.(y/n)");
                if(reader.next().toUpperCase().equals("Y")){
                    if(Gc.getMoney() > 100){
                        Gc.setMoney(Gc.getMoney() - 100);
                        if(Gc.getGclass().getGmaxhealth() == Gc.getGclass().getGhealth()){//Checkin hp amount and heals correspondingly
                            System.out.println("You are healed, but you don't feel any better? Maybe you were already at maximum hp.");
                        }
                        else if(Gc.getGclass().getGmaxhealth() < Gc.getGclass().getGhealth() + 50){
                            System.out.println("You are fully healed.");
                            Gc.setHp(Gc.getGclass().getGmaxhealth());
                        }else{
                            System.out.println("You are still injured.");
                            Gc.setHp(Gc.getGclass().getGhealth() + 50);
                        }
                    }else{
                        System.out.println("Healer: you don't have enough money, so i won't heal you.");
                    }
                }else{
                    System.out.println("Healer wishes you best of luck on your journey and wanders onwards");
                }
                break;
            case 11://BEARCAVE!!!!
            case 12:
            case 13:
            case 14:
            case 15:
                System.out.println("You noticed a large cave, do you go in?(y,n)");
                if(reader.next().toUpperCase().equals("Y")){
                    if(d < 5){
                        System.out.println("You found a large stash of money.");
                        Gc.setMoney(Gc.getMoney() + 500);
                    }else{
                        System.out.println("You walked into bears cave, it attacked you and ran away.(-30hp)");
                        Gc.setHp(Gc.getGclass().getGhealth() - 30);
                    }
                }else{
                    System.out.println("You desided its better not to risk it and walked away.");
                }
                break;
            case 16://Rest event
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                System.out.println("You desided to stop for today, you heal some of your lost hp and mana.");
                if(Gc.getGclass().getGhealth() + 10 > Gc.getGclass().getGmaxhealth()){
                    Gc.setHp(Gc.getGclass().getGmaxhealth());
                }else{
                    Gc.setHp(Gc.getGclass().getGhealth() + 10);
                }
                if(Gc.getGclass().getGmana() + 5 > Gc.getGclass().getGmaxmana()){
                    Gc.setMana(Gc.getGclass().getGmaxmana());
                }
                else{
                    Gc.setMana(Gc.getGclass().getGmana() + 5);
                }
                break;
            default://Boring event
                System.out.println("You walk for hours and don't find anything intresting.");
                break;
        }
        
        
        return Gc;
    }
    
    public static Gamechar combat(Gamechar gc){//Player wanders and finds a monster, COMBAT METHOID
        
        Gc = gc;
        int x = ran.nextInt(5) + 1;
        M = new Monster(x);
        Gc = fight(Gc,M,false);
        return Gc;
    }
    
    public static Gamechar combat(Gamechar gc, Monster IM,boolean town){//Player wanders and finds a monster, COMBAT METHOID
        Gc = gc;
        M = IM;
        Gc = fight(Gc,M,town);
        return Gc;
    }
    
    public static Gamechar fight(Gamechar gc, Monster M, boolean town){
        boolean loop = true;
        int c = ran.nextInt(4) + 1;
        switch(M.getGcreature()){//Random events which spawn monsters.
            case "goblin":
                if(c == 1){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an goblin, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 2){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an goblin, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 3){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an goblin, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 4){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an goblin, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }
                
                break;
            case "troll":
                if(c == 1){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an troll, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 2){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an troll, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 3){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an troll, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 4){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an troll, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }
                break;
            case "skeleton":
                if(c == 1){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an skeleton, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 2){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an skeleton, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 3){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an skeleton, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 4){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an skeleton, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }
                break;
            case "golem":
                if(c == 1){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an golem, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 2){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an golem, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 3){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an golem, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }else if(c == 4){
                    System.out.println("------------------------");
                    System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an golem, you prepare for battle!(enter to continue)");
                    System.out.println("------------------------");
                    reader2.nextLine();
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                }
                break;
            case "thug":
                    if(town){
                        System.out.println("As you walk the streets of the town a random thug attacks you!(enter to continue)");
                    }else{
                        System.out.println("------------------------");
                        System.out.println("You continue your way along the road, suddenly you hear bushes near you rustle.\nIt's an thug, you prepare for battle!(enter to continue)");
                        System.out.println("------------------------");
                    }
                    System.out.println("------------------------");
                    System.out.println("You are facing:");
                    System.out.println(M);
                break;
            default:
                break;
        }
        //Determines if player get a damagebuff agains this monster
        if(M.getGtype().equals("normal") && Gc.getWep().getGbonus().equals("Fire")){
            Cbonusdmg = 20;
            System.out.println("Your weapon has a damage boost against this enemy from fire enchantment!");
        }else if(M.getGtype().equals("elemental") && Gc.getWep().getGbonus().equals("Magic")){
            Cbonusdmg = 20;
            System.out.println("Your weapon has a damage boost against this enemy from magic enchantment!");
        }else if(M.getGtype().equals("undead") && Gc.getWep().getGbonus().equals("Thunder")){
            Cbonusdmg = 20;
            System.out.println("Your weapon has a damage boost against this enemy from ligthning enchantment!");
        }
        runm = false;
        runc = false;
        do{//COMBAT LOOP
            
            monsterbuffdown();//Lower 1 turn from all monster buffs and removes them if necessary
            playerdebuffdown();//Lower 1 turn from all player debuffs and removes them if necessary
            
            if(M.getGhealth() > 0){//Monster uses skill
            MAttack();
            }
            
            playerbuffdown();//Lower 1 turn from all player buffs and removes them if necessary
            monsterdebuffdown();//Lower 1 turn from all monster debuffs and removes them if necessary
            
            if(Gc.getGclass().getGhealth() > 0){//Player uses skill
                PAttack();
            }
            
            
           
        if(M.getGhealth() <= 0 || Gc.getGclass().getGhealth() <= 0 || runm || runc){//COMBAT END
            loop = false;
            if(runc){
                System.out.println("You succesfully ran away from the enemy.(enter to continue)");
                reader2.nextLine();
            }
            if(runm){//Monster runs away
                System.out.println(M.getGname() + " ran away from you.(enter to continue)");
                reader2.nextLine();
            }
            if(M.getGhealth() <= 0){//Monster dies
                c = ran.nextInt(600) + 1;
                kills++;
                if(M.getGcreature().equals("troll") && Gc.Priest == 1){
                    Gc.Priest = 2;
                }
                System.out.println("The enemy lies defeated under your feet.You got " + c + " coins from its corpse(enter to continue)");
                Gc.setMoney(Gc.getMoney() + c);
                reader2.nextLine();
                if(town){
                    System.out.println("You return to the streets.(enter to continue)");
                    reader2.nextLine();
                }
            }
            if(Gc.getGclass().getGhealth() <= 0){//Player dies
                System.out.println("The enemy hits you and you lose consciousness,no one heard from you again.(enter to continue)");
                reader2.nextLine();
            }
            round = 0;
        }
        
        
        }while(loop);//Keeps looping untill either monster or player can't fight.
        end();//Resets everything
        return Gc;
    }
    
    /*
    MONSTER ATTACKS/SKILLS
    madness
    steal
    confused
    fireball
    heal
    dmgbuff
    armor
    sweep
    buffdodge
    cover
    runaway
    yell
    obliterate
    */
    
    public static void MAttack(){//Monster attacks or prepares an attack
        
        int damage = 0;
        //////////////////////
        //calculating hit chance
        //////////////////////
        boolean dodge = true;
        int hitchance = ran.nextInt(100) + 1 + Mbonushit;
        int pdodge = Gc.getGclass().getGdodge();
        pdodge += Cbonusdodge;
        if(pdodge < hitchance){//Determines whenever monster hits or misses the player 
            dodge = false;
        }
        
        //////////////////////
        //First round calculations
        //////////////////////
        if(round == 0 && firststrike){//if monster attacks first or player attacks first
            if(!Gc.getGclass().getGname().equals("Rogue")){
                System.out.println("------------------------");
                System.out.println(M.getGname() + " is attacking!(enter to continue)");
                reader2.nextLine();
                damage = (M.getGdamage() + Mbonusdmg) / Cbonusarmor;
                System.out.println("You take " + damage + " damage!");
                Gc.setHp(Gc.getGclass().getGhealth() - damage);
            }else{
                PAttack();
            }
        }
        
        //////////////////////
        //monster uses skill
        //////////////////////
        if(round != 0){//Monster strikes
            System.out.println("------------------------");
            System.out.print(M.getGname() + " is doing a " + attack + "!(enter to continue)");
            reader2.nextLine();
            switch(attack){
                case "attack":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " strikes you with its weapon!");
                    damage = (M.getGdamage() + Mbonusdmg) / Cbonusarmor;
                    System.out.println("You take " + damage + " damage.");
                    Gc.setHp(Gc.getGclass().getGhealth() - damage);
                    break;
                case "block":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " is blocking your next attack");
                    Mbonusarmor += 2;
                    buffm.add("block");
                    timem.add(1);
                    break;
                case "dodge":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " tries to dodge your next attack.");
                    Mbonusdodge += 20;
                    buffm.add("dodge");
                    timem.add(1);
                    break;
                case "madness":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " strikes you with two powerfull blows. While yelling \"UUUUEEEERRRGGGG!\"");
                    if(dodge = false){
                    damage = (M.getGdamage() + Mbonusdmg) / Cbonusarmor;
                    System.out.println("You take " + damage + " damage.");
                    System.out.println("You take " + damage + " damage.");
                    damage = ((M.getGdamage() + Mbonusdmg) / Cbonusarmor) * 2;
                    Gc.setHp(Gc.getGclass().getGhealth() - damage);
                    }else{
                        System.out.println("Enemy smashes the ground with first strike, you skillfully step out of the way as the second strike is about to land. The monster misses you completely!");
                    }
                    break;
                case "steal":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " tries to steal your money.");
                    if(dodge = false){
                        int greed = ran.nextInt(4) + 1;
                        if(greed == 1){
                            System.out.println(M.getGname() + " instead grabs your spicebag and accidentaly rips it open.");
                            System.out.println("It starts to sneeze and cough from the powdered spices, and gets a hit chance debuff for 2 turns.");
                            Mbonushit -= buff("blind");
                            buffm.add("blind");
                            timem.add(2);
                        }else if(greed == 2){
                            System.out.println(M.getGname() + " instead grabs your food and slurps it down its gob becaming enraged for 2 turns!");
                            Mbonushit += buff("dmgbuff");
                            buffm.add("dmgbuff");
                            timem.add(2);
                        }else if(greed == 3 || greed == 4){
                            if(Gc.getMoney() <= 0){
                                System.out.println("It steals your coin purse, and notises it's empty and throws it on the ground.");
                            }else{
                                if(Gc.getMoney() < 100){
                                    System.out.println(M.getGname() + " steals "+Gc.getMoney()+" coins from you!");
                                    Gc.setMoney(0);
                                }else{
                                    System.out.println(M.getGname() + " steals 100 coins from you!");
                                    Gc.setMoney(Gc.getMoney()-100);
                                }
                            }
                        }
                    }else{
                        System.out.println(M.getGname() + " misses you.");
                        
                    }
                    break;
                case "fireball":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " casts fireball.");
                    if(dodge){
                        System.out.println("You managed to dodge the fireball.");
                    }else{
                        System.out.println("Fireball hits you scorching you badly.");
                        Gc.setHp(Gc.getGclass().getGhealth() - 20);
                        System.out.println("You take " + 20 + " damage");
                    }
                    break;
                case "confused":
                    
                    System.out.println("------------------------");
                    int rand = ran.nextInt(4) + 1;
                    if(rand == 1){
                        System.out.println(M.getGname() + " is staring at you thinking about what you'll do next.");
                    }else if(rand == 2){
                        System.out.println(M.getGname() + " is trying to make sense of it's situation.");
                    }else if(rand == 3){
                        System.out.println(M.getGname() + " is trying to get its thoughs together.");
                    }else if(rand == 4){
                        System.out.println(M.getGname() + " wanders around pointlessly.");
                    }
                    break;
                case "heal":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " glows green and its wounds start to disappear");
                    int heal = M.getGhealth() / 4;
                    M.setGhealth(M.getGhealth() + heal);
                    break;
                case "dmgbuff":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " is channeling its strenght and gains a damage buff for 4 turns.");
                    Mbonushit += buff("dmgbuff");
                    buffm.add("dmgbuff");
                    timem.add(5);
                    break;
                case "armor":
                    System.out.println("------------------------");
                    if(M.getGtype().equals("normal")){
                        System.out.println(M.getGname() + " is hardening its skin for 2 turns.");
                    }else if(M.getGtype().equals("undead")){
                        System.out.println(M.getGname() + " is summoning magical armor for 2 turns.");
                    }else if(M.getGtype().equals("elemental")){
                        System.out.println(M.getGname() + " spaws floating rocks to defend itself for 2 turns.");
                    }
                    Mbonusarmor += buff("armor");
                    buffm.add("armor");
                    timem.add(2);
                    break;
                case "sweep":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " tries to sweep your legs.");
                    if(dodge){
                        System.out.println("You step out of the attack.");
                    }else{
                        System.out.println(M.getGname() + " hits your legs and criples you for 2 turns");
                        damage = (M.getGdamage() + Mbonusdmg) / Cbonusarmor;
                        Gc.setHp(Gc.getGclass().getGhealth() - damage);
                        Cbonusdodge -= buff("sweep");
                        buffp.add("sweep");
                        timep.add(2);
                    }
                    break;
                case "buffdodge":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " dares you to try strike it.");
                    Mbonusdodge += buff("buffdodge");
                    buffm.add("buffdodge");
                    timem.add(2);
                    break;
                case "cover":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " takes cover from trees.");
                    Mbonusdodge += buff("cover");
                    buffm.add("cover");
                    timem.add(1);
                    break;
                case "runaway":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " is trying to run away!");
                    int r = ran.nextInt(100) + 1;
                    if(r < 20){
                        System.out.println(M.getGname() + " ran away.");
                        runm = true;
                    }else{
                        System.out.println("You manage to stop it from escaping.");
                    }
                    break;
                case "yell":
                    System.out.println("------------------------");
                    int ra = ran.nextInt(4) + 1;
                    if(ra == 1){
                        System.out.println("Enemy lets outs out a soul chilling shout.");
                    }else if(ra == 2){
                        System.out.println("Enemy makes a terrifying shout.");
                    }else if(ra == 3){
                        System.out.println("You feel afraid of this enemy as it's shouting.");
                    }else if(ra == 4){
                        System.out.println("Enemy tries to scare you, but you don't care about its shouting.");
                    }
                    if(ra != 4){
                        Cbonusdodge -= buff("yell");
                        Cbonushit -= buff ("yell");
                        buffp.add("yell");
                        timep.add(2);
                    }
                    break;
                case "obliterate":
                    System.out.println("------------------------");
                    System.out.println(M.getGname() + " strikes you with all of its strenght.");
                    if(dodge){
                        System.out.println("You manage to dodge the attack. The tree next to you wasn't as lucky.");
                    }else{
                        System.out.println(M.getGname() + " hits you with devastating strike.");
                        damage = ((M.getGdamage() + Mbonusdmg) * 3) / Cbonusarmor;
                        System.out.println("You take " + damage + " damage.");
                        Gc.setHp(Gc.getGclass().getGhealth() - damage);
                    }
                    break;
                default:
                    System.out.println(attack);
                    System.out.println("Error in attack");
                    break;
            }
        
        }
        System.out.print("(press enter to continue)");
        reader2.nextLine();
        int c = ran.nextInt(M.getGattacks().size());
        attack = M.getGattacks().get(c);
        System.out.println("------------------------");
        System.out.println(M.getGname() + " prepares skill  \"" + attack + "\"");
        round += 1;
    }
    
    
    private static void PAttack() {//Player attacks
        boolean inspect = true;
        int damage = 0;
        //////////////////////
        //calculating hit and crit chance
        //////////////////////
        
        boolean dodge = true;
        int hitchance = ran.nextInt(100) + 1 + Cbonushit;
        int pdodge = M.getGdodge();
        pdodge += Mbonusdodge;
        if(pdodge < hitchance){
            dodge = false;
        }
        boolean crit = false;
        
        int critchance = ran.nextInt(100) + 1 - Cbonuscrit;
        if(Gc.getWep().getGcriticalc() > critchance){
            crit = true;
        }
        int event = ran.nextInt(10) + 1;
        do{
            System.out.println("------------------------");
            System.out.println("What do you want to do?(A=attack,S=skill,B=block,D=dodge,I=inspect yourself, M=inspect monster,E=escape)");
            switch(reader.next().toUpperCase()){
                case ("A")://ATTACK
                    inspect = false;
                    if(dodge){//If the monster manages to dodge players attack
                        System.out.println("------------------------");
                        
                        if(Gc.getWep().getGtype().equals("Sword") || Gc.getWep().getGtype().equals("Spear")){//SWORD AND SPEAR
                        switch(event){//Events that happen when monster dodges the attack
                            case 1:
                                System.out.println("You swing your weapon for the enemys head, but as it's about to land the enemy sweeps it aside!");
                                break;
                            case 2:
                                System.out.println("You try to stab the enemy, but the enemy blocks your attack!");
                                break;
                            case 3:
                                System.out.println("You charge the enemy, but the enemy kicks dirt on your face interrupting your attack!");
                                break;
                            case 4:
                                System.out.println("You hold your ground and take some careful attacks on the enemy, but the enemy manages to dodge and block them all!");
                                break;
                            case 5:
                                System.out.println("You manage to hit the enemy, but the enemy though armor just deflects the attack!");
                                break;
                            case 6:
                                System.out.println("You miss the enemy!");
                                break;
                            case 7:
                                System.out.println("As you attack the enemy, you trip on a rock and miss your attack!");
                                break;
                            case 8:
                                System.out.println("Enemy dodges the attack!");
                                break;
                            case 9:
                                System.out.println("Enemy blocks the attack!");
                                break;
                            case 10:
                                System.out.println("As you are attackin, the enemy roars and deflects your attack!");
                                break;
                        }
                        
                        }else{//BOW
                            switch(event){//Events that happen when monster dodges the attack
                            case 1:
                                System.out.println("You fire your bow, but a random bird flies on the way of your arrow!");
                                break;
                            case 2:
                                System.out.println("You hit the enemy on though part of his armor, the arrow deflects!");
                                break;
                            case 3:
                                System.out.println("You fire your bow, the enemy hits the arrow out of the air as it's about to hit it!");
                                break;
                            case 4:
                                System.out.println("You fire your bow, but you miss the enemy!");
                                break;
                            case 5:
                                System.out.println("You fire your bow, but the enemy dodges it!");
                                break;
                            case 6:
                                System.out.println("You fire your bow, but a gust of wind trails the arrow off it's target!");
                                break;
                            case 7:
                                System.out.println("You fire your bow, but the enemy blocks your attack!");
                                break;
                            case 8:
                                System.out.println("You trip while trying to fire your bow and miss your target!");
                                break;
                            case 9:
                                System.out.println("You fire your bow, but the enemy manages to take cover!");
                                break;
                            case 10:
                                System.out.println("You try to fire your bow, but as you are firing the enemy attacks! You managed to dodge the attack.");
                                break;
                        }
                        }
                        
                    }else{
                    if(crit){
                        damage =((Gc.getWep().getGdamage() + Cbonusdmg) / Mbonusarmor) * 2;
                        System.out.println("You critically hit " + M.getGname() + " with your weapon and dealt " + damage + " damage.");
                        M.setGhealth(M.getGhealth() - damage);
                    }else{
                        damage =((Gc.getWep().getGdamage() + Cbonusdmg) / Mbonusarmor);
                        System.out.println("You attacked " + M.getGname() + " with your weapon and dealt " + damage + " damage.");
                        M.setGhealth(M.getGhealth() - damage);
                    }}
                    break;
                case ("B")://BLOCK
                    inspect = false;
                    System.out.println("You prepare to block the monsters next attack.");
                    Cbonusarmor += 2;
                    buffp.add("block");
                    timep.add(1);
                    break;
                case ("S")://SKILL
                    inspect = pskill();
                    break;
                case ("D")://DODGE
                    inspect = false;
                    System.out.println("You prepare to dodge the enemys next attack.");
                    Cbonusdodge += 2;
                    buffp.add("dodge");
                    timep.add(1);
                    break;
                case ("I")://INSPECT
                    System.out.println("You inspect yourself:");
                    System.out.println(Gc);
                    System.out.println("Debuffs/buffs:");
                    System.out.println(buffp);
                    break;
                case ("M")://MONSTER
                    System.out.println("You inspect the enemy:");
                    System.out.println(M);
                    System.out.println("Debuffs/buffs:");
                    System.out.println(buffm);
                    break;
                case ("T")://DEV
                    System.out.println("cbonusdmg: " + Cbonusdmg);
                    System.out.println("cbonusdodge: " + Cbonusdodge);
                    System.out.println("cbonushp: " + Cbonushp);
                    System.out.println("cbonushit: " + Cbonushit);
                    System.out.println("cbonusarmor: " + Cbonusarmor);
                    System.out.println("cbonuscrit:" + Cbonuscrit);
                    System.out.println("-----");
                    System.out.println("mbonusdmg: " + Mbonusdmg);
                    System.out.println("mbonusdodge: " + Mbonusdodge);
                    System.out.println("mbonushp: " + Mbonushp);
                    System.out.println("mbonushit: " + Mbonushit);
                    System.out.println("mbonusarmor: " + Mbonusarmor);
                    break;
                case ("E")://ESCAPE
                    System.out.println("You have a 50% chance to escape do you want to try it?(y/n)");
                    if(reader.next().toUpperCase().equals("Y")){
                        inspect = false;
                        if(event < 5){
                            runc = true;
                        }else{
                            System.out.println("The enemy catches you as you try to run away."); 
                        }
                    }
                    break;
                default:
                    break;
            }
        }while(inspect);
        
        
    }
     public static boolean pskill() {//Player uses skill
         boolean loop = true;//Loops all skills of the character
         boolean found = false;//Used to check if character has specified skill(should not be needed)
         do{
         System.out.println("Your skills are:");//Prints skills to the user
         if(Gc.getGclass().getGname().equals("Warrior")){
             System.out.println("Bellow,Laugh it off");
             
         }else if(Gc.getGclass().getGname().equals("Rogue")){
             System.out.println("Eagle eyes,Stealth");
         }else{
             System.out.println("Fireball,Heal");
         }
         if(Gc.Priest == 3){
             System.out.print(",Fireball");
         }
         System.out.println("What skill do you want to use?(type the first word of the skill or b for back)(all skills cost 5 mana)");
         if(Gc.getGclass().getGmana() < 5){//Checks if player has mana to cast skill
             System.out.println("You don't have mana to do that.");
             loop = false;
         }else{
         switch(reader.next().toUpperCase()){
            default:
                 break;
            case("BELLOW")://Skill that weakens monster
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Bellow")){
                        System.out.println("You lower the enemys damage by 5 for 3 turns.");
                        Mbonusdmg -= buff("bellow");
                        buffm.add("bellow");//Adds debuff to monster
                        timem.add(3);//Adds timer to debuff
                        Gc.setMana(Gc.getGclass().getGmana() - 5);
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case("LAUGH")://Skill that heals player
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Laugh it off")){
                        System.out.println("You heal for 30hp.");
                        if(Gc.getGclass().getGmaxhealth() < Gc.getGclass().getGhealth()){//Checkin hp amount and heals correspondingly
                            System.out.println("You are already at maximum HP!");
                        }
                        else if(Gc.getGclass().getGmaxhealth() < Gc.getGclass().getGhealth() + 30){
                            System.out.println("You are fully healed.");
                            Gc.setHp(Gc.getGclass().getGmaxhealth());
                            Gc.setMana(Gc.getGclass().getGmana() - 5);
                        }else{
                            System.out.println("You are still injured.");
                            Gc.setHp(Gc.getGclass().getGhealth() + 30);
                            Gc.setMana(Gc.getGclass().getGmana() - 5);
                        }
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case("STEALTH")://Skill that boosts dodge dramaticly
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Stealth")){
                        System.out.println("You hide from sight for 2 turns making it hard for enemy to attack.");
                        Cbonusdodge += buff("stealth");
                        buffp.add("stealth");//Adds buff to player
                        timep.add(2);//Adds timer to buff
                        Gc.setMana(Gc.getGclass().getGmana() - 5);
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case("EAGLE")://Skill that boost criticalhit chance
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Eagle eyes")){
                        System.out.println("You increase your crit for 5 turns.");
                        Cbonuscrit += buff("eagle");
                        buffp.add("eagle");//Adds buff to player
                        timep.add(5);//Adds timer to buff
                        Gc.setMana(Gc.getGclass().getGmana() - 5);
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case("FIREBALL")://Deals damage to monster
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Fireball")){
                        System.out.println("You cast a fireball and scorch the enemy for 300 damage.");
                        M.setGhealth(M.getGhealth() - 300);//Monster loses hp
                        Gc.setMana(Gc.getGclass().getGmana() - 5);
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case("HEAL")://Heals player
                for (int i = 0; i < Gc.getGclass().getAttacks().size(); i++) {
                    if(Gc.getGclass().getAttacks().get(i).equals("Heal")){
                        System.out.println("Your wound start to vanish and you heal for 50hp.");
                        if(Gc.getGclass().getGmaxhealth() < Gc.getGclass().getGhealth()){//Checkin hp amount and heals correspondingly
                            System.out.println("You are already at maximum HP!");
                        }
                        else if(Gc.getGclass().getGmaxhealth() < Gc.getGclass().getGhealth() + 50){
                            System.out.println("You are fully healed.");
                            Gc.setHp(Gc.getGclass().getGmaxhealth());
                            Gc.setMana(Gc.getGclass().getGmana() - 5);
                        }else{
                            System.out.println("You are still injured.");
                            Gc.setHp(Gc.getGclass().getGhealth() + 50);
                            Gc.setMana(Gc.getGclass().getGmana() - 5);
                        }
                        loop = false;
                        found = true;
                        return false;
                    }
                }
                break;
            case "B":
                return true;
            }
         
         if(!found){//Player doesn't have that skill
              System.out.println("You don't have that skill.");
         }
         }
         }while (loop);
         return true;
    }

        
        public static void playerbuffdown(){//Removes 1 turn from buff timer and if it reaches 0 removes it.
        for (int i = 0; i < timep.size(); i++) {
            int d =timep.get(i);
            if(d == 0){
                switch(buffp.get(i)){
                    case "dmgbuff":
                        Cbonusdmg -= buff("dmgbuff");
                        break;
                    case"armor":
                        Cbonusarmor -= buff("armor");
                        break;
                    case "buffdodge":
                        Cbonusdodge -= buff("buffdodge");
                        break;
                    case "cover":
                        Cbonusdodge -= buff("cover");
                        break;
                    case "dodge":
                        Cbonusdodge = Cbonusdodge - buff("dodge");
                        break;
                    case "block":
                        Cbonusarmor -= buff("block");
                        break;
                }
            timep.remove(i);
            buffp.remove(i);
            }else{
                d--;
                timep.set(i, d);
            }
        }
    }
    public static void playerdebuffdown(){//Removes 1 turn from debuff timer and if it reaches 0 removes it.
        for (int i = 0; i < timep.size(); i++) {
            int d =timep.get(i);
            if(d == 0){
                switch(buffp.get(i)){
                    case "blind":
                        Cbonusdodge = Cbonusdodge + buff("blind");
                        break;
                    case "yell":
                        Cbonusdodge = Cbonusdodge + buff("yell");
                        Cbonushit = Cbonusdodge + buff("yell");
                        break;
                    case "sweep":
                        Cbonusdodge = Cbonusdodge + buff("sweep");
                        break;
                }
            timep.remove(i);
            buffp.remove(i);
            }else{
                d--;
                timep.set(i, d);
            }
        }
    }
    
    public static void monsterbuffdown(){//Removes 1 turn from buff timer and if it reaches 0 removes it.
        for (int i = 0; i < timem.size(); i++) {
            int d =timem.get(i);
            if(d == 0){
                switch(buffm.get(i)){
                    case "dmgbuff":
                        Mbonusdmg = Mbonusdmg - buff("dmgbuff");
                        break;
                    case"armor":
                        Mbonusarmor = Mbonusarmor -buff("armor");
                        break;
                    case "buffdodge":
                        Mbonusdodge = Mbonusdodge - buff("buffdodge");
                        break;
                    case "cover":
                        Mbonusdodge = Mbonusdodge - buff("cover");
                        break;
                    case "dodge":
                        Mbonusdodge = Mbonusdodge - buff("dodge");
                        break;
                    case "block":
                        Mbonusarmor = Mbonusarmor - buff("block");
                        break;
                }
                timem.remove(i);
                buffm.remove(i);
            }else{
                d--;
                timem.set(i, d);
            }
        }
    }
    public static void monsterdebuffdown(){//Removes 1 turn from debuff timer and if it reaches 0 removes it.
        for (int i = 0; i < timem.size(); i++) {
            int d =timem.get(i);
            if(d == 0){
                switch(buffm.get(i)){
                    case "blind":
                        Mbonusdodge += buff("blind");
                        break;
                    case "yell":
                        Mbonusdodge += buff("yell");
                        Mbonushit += buff("yell");
                        break;
                    case "sweep":
                        Mbonusdodge += buff("sweep");
                        break;
                    case "bellow":
                        Mbonusdmg += buff("bellow");
                }
                timem.remove(i);
                buffm.remove(i);
            }else{
                d--;
                timem.set(i, d);
            }
        }
    }
    public static int buff(String buff){//buff values
        switch(buff){
            case "blind":
                return 50;
            case "dmgbuff":
                return 5;
            case "armor":
                return 2;
            case "buffdodge":
                return 20;
            case "cover":
                return 40;
            case "yell":
                return 15;
            case "dodge":
                return 20;
            case "block":
                return 2;
            case "sweep":
                return 20;
            case "bellow":
                return 5;
            case "stealth":
                return 70;
            case "eagle":
                return 30;
        }
        return 1;
    }
    
    
    public static void end(){//Resets buffs and combat list
        
        round = 0;
        Cbonusdmg = 0;
        Cbonusdodge = 0;
        Cbonushp = 0;
        Cbonushit = 0;
        Cbonuscrit = 0;
        
        Mbonusdmg = 0;
        Mbonusdodge = 0;
        Mbonushp = 0;
        Mbonushit = 0;
        
        firststrike = true;
        attack = "";
        runm = false;
    
        buffp = new ArrayList();
        timep = new ArrayList();
        buffm = new ArrayList();
        timem = new ArrayList();
    }
    
    /**
     * @return the M
     */
    public Monster getM() {
        return M;
    }

    /**
     * @return the Gc
     */
    public Gamechar getGc() {
        return Gc;
    }

    /**
     * @param M the M to set
     */
    public void setM(Monster M) {
        this.M = M;
    }

    /**
     * @param Gc the Gc to set
     */
    public void setGc(Gamechar Gc) {
        this.Gc = Gc;
    }

    /**
     * @return the kills
     */
    public static int getKills() {
        return kills;
    }
}
