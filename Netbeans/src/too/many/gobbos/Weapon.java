package too.many.gobbos;


import java.util.Scanner;

/*
 * Weapon.java is to be used with TOO MANY GOBBOS game
 * Contains characters weapon information
 */

public class Weapon {
    //Global variables
    private String Gtype = "";
    private int Gdamage = 0;
    private int Gcriticalc = 0;
    private String Gbonus = "";
    private Scanner reader = new Scanner(System.in);
    
    
    public Weapon(String Itype,String Ibonus,int Idamage,int Icriticalc){//Constructors for Weapon.java
        //Places imported atributes to global ones.
        Gtype = Itype;
        Gdamage = Idamage;
        Gbonus = Ibonus;
        Gcriticalc = Icriticalc;
    }
    
    public Weapon(){
        
    }
    
    public Weapon(boolean loop){// Constructor where the player chooses his/her weapon
        loop = true;
        while(loop){//Asks what weapontype player wants to use
            System.out.print("What is your weapon?\nSword: does more damage than other weapons.\nBow: gets to srike first, and has also the highest critical hit change."
                    + "\nSpear: deals moderate damage, and also gets a dodge bonus.\n------------------------\nType the name of the weapon you want to use: ");
            Gtype = reader.next();
            System.out.println("------------------------");
            switch (Gtype.toUpperCase()) {
                case "SWORD":
                    //Places weapon as a sword
                        loop = false;
                        Gdamage = 100;
                        Gtype = "Sword";
                        Gcriticalc = 20;
                        break;
                case "BOW":
                        loop = false;
                        Gdamage = 50;
                        Gtype = "Bow";
                        Gcriticalc = 70;
                        break;
                case "SPEAR":
                        loop = false;
                        Gdamage = 80;
                        Gtype = "Spear";
                        Gcriticalc = 20;
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
                    Gbonus = "Thunder";
                    loop = false;
                    break;
                case "FIRE":
                    System.out.println("------------------------");
                    Gbonus = "Fire";
                    loop = false;
                    break;
                case "MAGIC":
                    System.out.println("------------------------");
                    Gbonus = "Magic";
                    loop = false;
                    break;
                default:
                    System.out.println("------------------------");
                    //If player gives invalid weapon type while loop continues
                    System.out.println("Try again.");
                    break;
            }
        }
    }
    
    
    
    //Getters and setters

    /**
     * @return the Gtype
     */
    public String getGtype() {
        return Gtype;
    }

    /**
     * @return the Gdamage
     */
    public int getGdamage() {
        return Gdamage;
    }

    /**
     * @return the Gbonus
     */
    public String getGbonus() {
        return Gbonus;
    }

    /**
     * @param Gtype the Gtype to set
     */
    public void setGtype(String Gtype) {
        this.Gtype = Gtype;
    }

    /**
     * @param Gdamage the Gdamage to set
     */
    public void setGdamage(int Gdamage) {
        this.Gdamage = Gdamage;
    }

    /**
     * @param Gbonus the Gbonus to set
     */
    public void setGbonus(String Gbonus) {
        this.Gbonus = Gbonus;
    }

    /**
     * @return the Gcriticalc
     */
    public int getGcriticalc() {
        return Gcriticalc;
    }

    /**
     * @param Gcriticalc the Gcriticalc to set
     */
    public void setGcriticalc(int Gcriticalc) {
        this.Gcriticalc = Gcriticalc;
    }
    
     @Override
    public String toString(){//Overrides the normal toString methoid. 
        return "Weapon type: " + Gtype +"\nWeapon damage: " +Gdamage +"\nWeapon bonuses: " + Gbonus + "\nWeapon crit chance: " + Gcriticalc;
    }
}
