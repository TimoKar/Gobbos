package too.many.gobbos;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * Charclass.java is to be used with TOO MANY GOBBOS game
 * Contains characters class information
 */

public class Charclass {
    //Global variables
    private String Gname;//Characters name
    private int Ghealth;//Characters current health
    private int Gmaxhealth;//Characters maximum health
    private int Gmana;//Characters current mana
    private int Gmaxmana;//Characters maximum mana
    private int Gdodge;//Characters dodge chance 0-100%
    private int Gspellbonus;//Characters bonus to spells(work in progress)
    private String GClevel;//Characters level
    private String Gspecial;//Characters special trait
    private ArrayList<String> Gattacks;//Characters attacks
    private Scanner reader = new Scanner(System.in);
    
    public Charclass(){//Empty constructor
        
    }
    
    public Charclass(String Iname,int Imaxhealth, int Imaxmana,String IClevel,String Ispecial,int Idodge,int Ispellbonus, ArrayList<String> Iattacks){//Constructors for Charclass.java
        //Places imported atributes to global ones.
        Gname = Iname;
        Ghealth = Imaxhealth;
        Gmaxhealth = Imaxhealth;
        Gmana = Imaxmana;
        Gmaxmana = Imaxmana;
        GClevel = IClevel;
        Gdodge = Idodge;
        Gspellbonus = Ispellbonus;
        Gspecial = Ispecial;
        Gattacks = Iattacks;
    }
    
    public Charclass(boolean loop){// Constructor where the player chooses his/her characters class
        loop = true;
        while (loop){
            Gattacks.add("Attack");
            Gattacks.add("Block");
            Gattacks.add("Dodge");
            System.out.print("What is your characters class?\nWarrior: has high health, and hits hard with melee weapons.Gets Bellow attack that lowers enemy damage,and Laugh it off skill that heals.\nRogue: has bonus dodge change and critical strike chance, also always gets first turn.Gets Stealth skill that hides the character,ann Eagle eyes skill that gives crit chance."
                    + "\nMage: has low health,moderate dodge and lots of mana,and gets a healing spell and a fireball spell.\n------------------------\nType the name of the class you want to play as:");
            Gname = reader.next();
            System.out.println("------------------------");
            if(Gname.toUpperCase().equals("WARRIOR")){//Warrior gets bonus health
                Gname = "Warrior";
                Ghealth = 200;
                Gmana = 20;
                Gdodge = 10;
                loop = false;
                Gattacks.add("Bellow");
                Gattacks.add("Laugh it off");
            }else if(Gname.toUpperCase().equals("ROGUE")){//Rogue gets bonus dodge
                Gname = "Rogue";
                Ghealth = 150;
                Gmana = 20;
                Gdodge = 30;
                loop = false;
                Gattacks.add("Stealth");
                Gattacks.add("Eagle eyes");
            }else if(Gname.toUpperCase().equals("MAGE")){//Mage gets bonus mana
                Gname = "Mage";
                Ghealth = 100;
                Gmana = 80;
                Gdodge = 20;
                loop = false;
                Gattacks.add("Fireball");
                Gattacks.add("Heal");
            }else{//If player gave invalid name ask again.
                System.out.println("Invalid input, try again.");
            }
        }
        //Ask characters level and saves it
        System.out.print("What is your characters level?(does not effect the game in any way):");
        GClevel = reader.next();
        System.out.println("------------------------");
            
        loop = true;
        while(loop){//Loop where player chooses his/hers specialization
            System.out.print("What is your characters speciality\nResistant: more health.\nStrong: more damage with weapons.\nSpiritual: more mana."
                    + "\n------------------------\nType the name of the special that you want to use: ");
            Gspecial = reader.next();
            System.out.println("------------------------");
            if(Gspecial.toUpperCase().equals("RESISTANT")){//Resistant gives bonus health
                Gspecial = "Resistant";
                Ghealth += 30;
                loop = false;
            }else if(Gspecial.toUpperCase().equals("STRONG")){//Strong gives bonus damage
                Gspecial = "Strong";
                loop = false;
            }else if(Gspecial.toUpperCase().equals("SPIRITUAL")){//Spiritual gives bonus mana
                Gspecial = "Spiritual";
                Gmana += 30;
                loop = false;
            }else{//If player gave invalid name ask again.
                System.out.println("Invalid input, try again.");
            }
        }
        
    }
    
    
    //Getters and setters
    
    /**
     * @return the Gname
     */
    public String getGname() {
        return Gname;
    }

    /**
     * @return the Ghealth
     */
    public int getGhealth() {
        return Ghealth;
    }

    /**
     * @return the Gmana
     */
    public int getGmana() {
        return Gmana;
    }

    /**
     * @return the GClevel
     */
    public String getGClevel() {
        return GClevel;
    }

    /**
     * @return the Gspecial
     */
    public String getGspecial() {
        return Gspecial;
    }

    /**
     * @param Gname the Gname to set
     */
    public void setGname(String Gname) {
        this.Gname = Gname;
    }

    /**
     * @param Ghealth the Ghealth to set
     */
    public void setGhealth(int Ghealth) {
        this.Ghealth = Ghealth;
    }

    /**
     * @param Gmana the Gmana to set
     */
    public void setGmana(int Gmana) {
        this.Gmana = Gmana;
    }

    /**
     * @param GClevel the GClevel to set
     */
    public void setGClevel(String GClevel) {
        this.GClevel = GClevel;
    }

    /**
     * @param Gspecial the Gspecial to set
     */
    public void setGspecial(String Gspecial) {
        this.Gspecial = Gspecial;
    }

    /**
     * @return the Gdodge
     */
    public int getGdodge() {
        return Gdodge;
    }

    /**
     * @param Gdodge the Gdodge to set
     */
    public void setGdodge(int Gdodge) {
        this.Gdodge = Gdodge;
    }
    
    @Override
    public String toString(){//Overrides method toString 
        return "Class name: " +Gname+ "\nHealth: " + Ghealth + "/"+ Gmaxhealth + "\nMana: " + Gmana +"/" + Gmaxmana + "\nSpellbonus:" + Gspellbonus+ "\nLevel: " +GClevel +"\nDodge: " +Gdodge+ "\nSpecial: " + Gspecial;
    }

    /**
     * @return the Attacks
     */
    public ArrayList<String> getAttacks() {
        return Gattacks;
    }

    /**
     * @param Attacks the Attacks to set
     */
    public void setAttacks(ArrayList<String> Attacks) {
        Gattacks = Attacks;
    }

    /**
     * @return the Gmaxhealth
     */
    public int getGmaxhealth() {
        return Gmaxhealth;
    }

    /**
     * @return the Gmaxmana
     */
    public int getGmaxmana() {
        return Gmaxmana;
    }

    /**
     * @return the Gspellbonus
     */
    public int getGspellbonus() {
        return Gspellbonus;
    }

    /**
     * @param Gmaxhealth the Gmaxhealth to set
     */
    public void setGmaxhealth(int Gmaxhealth) {
        this.Gmaxhealth = Gmaxhealth;
    }

    /**
     * @param Gmaxmana the Gmaxmana to set
     */
    public void setGmaxmana(int Gmaxmana) {
        this.Gmaxmana = Gmaxmana;
    }

    /**
     * @param Gspellbonus the Gspellbonus to set
     */
    public void setGspellbonus(int Gspellbonus) {
        this.Gspellbonus = Gspellbonus;
    }

}