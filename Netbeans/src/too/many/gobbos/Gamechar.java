package too.many.gobbos;


import java.util.ArrayList;
import java.util.Scanner;

/*
 *Gamechar.java is to be used with TOO MANY GOBBOS game
 *Contain information about the character(class and weapon)
 */

public class Gamechar {
    private String Gname = "";
    private Charclass Gclass = new Charclass();
    private Weapon wep = new Weapon();
    private Scanner reader = new Scanner(System.in);
    private int money = 1000;
    
    //QUEST STATUS
    //Thief Quest
    static int Thief = 0;
    static int Smoney = 0;
    //Priest Quest
    static int Priest = 0;
    
    public Gamechar(){//empty constructor
        
    }
    
    public Gamechar(String Iname,String Wtype,String Wbonus,int Wdamage,int Wcriticalc,String Cname,int Chealth,int Cmana,String CClevel,String Cspecial,int Cdodge,int Ispellbonus,ArrayList<String> IAttacks){//Constructor where stat buffs are given by class and weapons
       Gname = Iname;
        if(Cname.equals("Warrior")){//Warrior gives damage bonus to all melee weapons
            if(!(Wtype.equals("Bow"))){
                Wdamage += 20;
            }
        }else if(Cname.equals("Rogue")){//Rogue gives bonus critical chance
            Wcriticalc += 20;
        }
        if(Wtype.equals("Spear")){//Spear gives bonus dodge change
            Cdodge += 20;
        }
        wep.setGtype(Wtype);
        wep.setGdamage(Wdamage);
        wep.setGcriticalc(Wcriticalc);
        wep.setGbonus(Wbonus);
        Gclass.setGname(Cname);
        Gclass.setGhealth(Chealth);
        Gclass.setGmaxhealth(Chealth);
        Gclass.setGmana(Cmana);
        Gclass.setGmaxmana(Cmana);
        Gclass.setGClevel(CClevel);
        Gclass.setGdodge(Cdodge);
        Gclass.setGspellbonus(Ispellbonus);
        Gclass.setGspecial(Cspecial);
        Gclass.setAttacks(IAttacks);
    }
    
    @Override
    public String toString(){//Returns information about characters weapon and class
        return "Character "+getGname()+" info:\n------------------------\n" +getGclass()+ "\nMoney: " + money +"\n------------------------\nCharacters weapon: \n------------------------\n" + getWep() ;
    }

    
    //Getters and setters
    
    /**
     * @return the Gname
     */
    public String getGname() {
        return Gname;
    }

    /**
     * @return the Gclass
     */
    public Charclass getGclass() {
        return Gclass;
    }

    /**
     * @return the wep
     */
    public Weapon getWep() {
        return wep;
    }

    /**
     * @param Gname the Gname to set
     */
    public void setGname(String Gname) {
        this.Gname = Gname;
    }

    /**
     * @param Gclass the Gclass to set
     */
    public void setGclass(Charclass Gclass) {
        this.Gclass = Gclass;
    }

    /**
     * @param wep the wep to set
     */
    public void setWep(Weapon wep) {
        this.wep = wep;
    }
    /**
     * Sets current hp
     */
    public void setHp(int hp){
        Gclass.setGhealth(hp);
    }
    /**
     * Sets current mana
     */
    public void setMana(int mana){
        Gclass.setGmana(mana);
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }
}
