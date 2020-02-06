package too.many.gobbos;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Timo
 */
public class Gamemain {
    static Scanner reader = new Scanner(System.in);
    static Scanner reader2 = new Scanner(System.in);
    static Random ran = new Random();
    static Gamechar player;
    static Monster enemy;
    static ArrayList<String> IAttacks = new ArrayList();
    
    /**
     *
     * @param args
     */
    public static void main(String [] args) {
        int dev = 0;
        System.out.println("----------------WELCOME TO TOO MANY GOBBOS---------------");
        System.out.println("-------------------a text based fighter------------------");
        if(dev == 1){//Developer character for testing
            IAttacks = new ArrayList();
            IAttacks.add("Attack");
            IAttacks.add("Defend");
            IAttacks.add("Dodge");
            IAttacks.add("Bellow");
            IAttacks.add("Laugh it off");
            //Iname, Wtype, Wbonus, Wdamage, Wcriticalc, Cname, Chealth, Cmana, CClevel, Cspecial, Cdodge, Ispellbonus, IAttacks
            player = new Gamechar("DEV", "Sword", "Magic", 130, 20, "Warrior", 200, 20, "20", "Strong", 10,0,IAttacks);
            System.out.println(player);
            
        }else if(dev == 2){//Loop to test character creation
           player = createchar();//Creates new Gamechar with players name
            System.out.println(player);//prints info about character
            System.out.println("------------------------");
            System.out.print("Do you want to create your character again?(y,n): "); 
            
        }else if(dev == 3){//Loop that prints 10 random monsters
            for (int i = 0; i < 10; i++) {
                System.out.println("------------------------");
                int x = ran.nextInt(4) + 1;
                Monster M = new Monster(x);
                System.out.println(M);
                System.out.println("------------------------");
                if(i == 10){
                    System.exit(1);
                }
            }
        }else{
        do{//Loop where player creates his/her character
        player = createchar();//Creates new Gamechar with players name
        System.out.println(player);//prints info about character
        System.out.println("------------------------");
        System.out.print("Continue with this character?(y,n): ");
        }while(reader.next().toUpperCase().equals("N"));
        }
        if(dev == 0){//DEV GODMODE
            System.out.print("Enable godmode(y,n)(9999 hp and mana)?");
            if(reader.next().toUpperCase().equals("Y")){
                Charclass CC = new Charclass();
                CC = player.getGclass();
                CC.setGhealth(9999);
                CC.setGmaxhealth(9999);
                CC.setGmana(9999);
                CC.setGmaxmana(9999);
                player.setGclass(CC);
            }
                
        }
        ///////////////////////////////////////
        //Player character has been created
        //Next part is the main game loop
        //////////////////////////////////////
        
        System.out.println("------------------------");
        System.out.println("You are " + player.getGname() + " the " + player.getGclass().getGname() + ". You are roaming the lands of Ronrir in search of money and fame.");
        System.out.println("------------------------");
        System.out.print("Enter to continue");
        reader2.nextLine();
        System.out.println("------------------------");
        
        boolean loop = true;
        do{
        int x = ran.nextInt(6) + 1;
        switch (x){
            default:
            case 1:
            case 2:
            case 3:
                player = Wander.wander(player);
                break;
            case 4:
            case 5:
                player = Wander.combat(player);
                break;
            case 6:
                player = TownAndQuests.Town(player);//not implemented yet
                break;
        }
        if(player.getGclass().getGhealth() <= 0){
            loop = false;
        }
        if(loop){
            System.out.println("------------------------");
            System.out.print("C = continue, I = investigate yourself.");
            if(reader.next().toUpperCase().equals("I")){
            System.out.println(player);
            System.out.println("------------------------");
            System.out.print("Enter to continue");
            reader2.nextLine();
        }
        System.out.println("------------------------");
        }
        }while(loop);
        
        ///////////////////////////////////////
        //Player has either won or died
        //Next part is for printing stats
        //Work in progress
        //////////////////////////////////////
        
        System.out.println("END");
        
    }
    

       
   
    
     private static void town() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
    public static Gamechar createchar(){//methoid that creates player character
        ///////////////////////////////////////
        //Naming the character
        System.out.print("Name your character:");
        String Iname = reader.next();//Saves playername
        System.out.println("------------------------");
        ////////////////////////////////////////
        //Character class atributes
        boolean loop = true;
        String Cname = "";
        int Chealth = 0;
        int Cmana = 0;
        int Cdodge = 0;
        int Cspellbonus = 0;
        String Clevel = "";
        String Cspecial = "";
        ArrayList<String> Cattacks = new ArrayList();
        ////////////////////////////////////////
        //Weapon class atributes
        String Wtype = "";
        int Wdamage = 0;
        int Wcriticalc = 0;
        String Wbonus = "";
        ////////////////////////////////////////
        Cattacks.add("Attack");
        Cattacks.add("Block");
        Cattacks.add("Dodge");
        while (loop){//Character class creation
            System.out.print("What is your characters class?\nWarrior: has high health, and hits hard with melee weapons.Gets Bellow attack that lowers enemy damage,and Laugh it off skill that heals.\nRogue: has bonus dodge change and critical strike chance, also always gets first turn.Gets Stealth skill that hides the character,and Eagle eyes skill that gives crit chance."
                    + "\nMage: has low health,moderate dodge and lots of mana,and gets a healing spell and a fireball spell.\n------------------------\nType the name of the class you want to play as:");
            Cname = reader.next();
            System.out.println("------------------------");
            if(Cname.toUpperCase().equals("WARRIOR")){//Warrior gets bonus health
                Cname = "Warrior";
                Chealth = 200;
                Cmana = 20;
                Cdodge = 10;
                loop = false;
                Cattacks.add("Bellow");
                Cattacks.add("Laugh it off");
            }else if(Cname.toUpperCase().equals("ROGUE")){//Rogue gets bonus dodge
                Cname = "Rogue";
                Chealth = 150;
                Cmana = 20;
                Cdodge = 30;
                loop = false;
                Cattacks.add("Stealth");
                Cattacks.add("Eagle eyes");
            }else if(Cname.toUpperCase().equals("MAGE")){//Mage gets bonus mana
                Cname = "Mage";
                Chealth = 100;
                Cmana = 80;
                Cdodge = 20;
                loop = false;
                Cattacks.add("Fireball");
                Cattacks.add("Heal");
            }else{//If player gave invalid name ask again.
                System.out.println("Invalid input, try again.");
            }
        }
        //Ask characters level and saves it
        System.out.print("What is your characters level?(does not effect the game in any way):");
        Clevel = reader.next();
        System.out.println("------------------------");
            
        loop = true;
        while(loop){//Loop where player chooses his/hers specialization
            System.out.print("What is your characters speciality\nResistant: more health.\nStrong: more damage with weapons.\nSpiritual: more mana."
                    + "\n------------------------\nType the name of the special that you want to use: ");
            Cspecial = reader.next();
            System.out.println("------------------------");
            if(Cspecial.toUpperCase().equals("RESISTANT")){//Resistant gives bonus health
                Cspecial = "Resistant";
                Chealth += 30;
                loop = false;
            }else if(Cspecial.toUpperCase().equals("STRONG")){//Strong gives bonus damage
                Cspecial = "Strong";
                Wdamage += 30;
                loop = false;
            }else if(Cspecial.toUpperCase().equals("SPIRITUAL")){//Spiritual gives bonus mana
                Cspecial = "Spiritual";
                Cmana += 30;
                loop = false;
            }else{//If player gave invalid name ask again.
                System.out.println("Invalid input, try again.");
            }
        }
        ////////////////////////////////////
        //Character weapon creation
        loop = true;
        while(loop){//Asks what weapontype player wants to use
            System.out.print("What is your weapon?\nSword: does more damage than other weapons.\nBow: gets to srike first, and has also the highest critical hit change."
                    + "\nSpear: deals moderate damage, and also gets a dodge bonus.\n------------------------\nType the name of the weapon you want to use: ");
            Wtype = reader.next();
            System.out.println("------------------------");
            switch (Wtype.toUpperCase()) {
                case "SWORD":
                    //Places weapon as a sword
                        loop = false;
                        Wdamage += 100;
                        Wtype = "Sword";
                        Wcriticalc += 20;
                        break;
                case "BOW":
                        loop = false;
                        Wdamage += 50;
                        Wtype = "Bow";
                        Wcriticalc += 70;
                        break;
                case "SPEAR":
                        loop = false;
                        Wdamage += 80;
                        Wtype = "Spear";
                        Wcriticalc += 20;
                       break;
                default:
                    //If player gives invalid characters or didn't want to use selected weapon, while loop continues.
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
        loop = true;
        while(loop){//Loop where the player chooses his/her bonus 
            System.out.println("What bonus would you like?\nThunder: strong against undead.\nFire: strong against normal enemies.\nMagic: strong against elementals.");
            System.out.print("------------------------\nType the name of the bonus:");
            
            switch (reader.next().toUpperCase()) {
                case "THUNDER":
                    System.out.println("------------------------");
                    Wbonus = "Thunder";
                    loop = false;
                    break;
                case "FIRE":
                    System.out.println("------------------------");
                    Wbonus = "Fire";
                    loop = false;
                    break;
                case "MAGIC":
                    System.out.println("------------------------");
                    Wbonus = "Magic";
                    loop = false;
                    break;
                default:
                    System.out.println("------------------------");
                    //If player gives invalid weapon type while loop continues
                    System.out.println("Try again.");
                    break;
            }
        }
        Gamechar player = new Gamechar(Iname, Wtype, Wbonus,Wdamage,Wcriticalc,Cname,Chealth,Cmana,Clevel,Cspecial,Cdodge,Cspellbonus, Cattacks);
        return player;
    }

   
}
