package too.many.gobbos;


import java.util.ArrayList;
import java.util.Random;

/*
 * Class where monster is created
 */

public class Monster {
    private String Gname = "";
    private String GFname = "";
    private String Gtype = "";
    private String Gcreature = "";
    private int Ghealth = 0;
    private int Gdodge = 0;
    private int Gdamage = 0;
    
    private ArrayList<String> Gattacks = new ArrayList<String>();
    
    
    public Monster(){
        
    }
    public Monster(String IGtype,String IGcreature,int IGhealth, int IGdodge, int IGdamage){
        GFname = getName();
        Gtype = IGtype;
        Gcreature = IGcreature;
        Ghealth = IGhealth;
        Gdodge = IGdodge;
        Gdamage = IGdamage;
        Gattacks.add("attack");
        Gattacks.add("block");
        Gattacks.add("dodge");
    }


    public Monster(int monsternmb){
        Gattacks.add("attack");
        Gattacks.add("block");
        Gattacks.add("dodge");
        switch(monsternmb){
            default:
                Gcreature = "goblin";
                Gtype = "normal";
                Ghealth = 1000;
                Gdodge = 20;
                Gdamage = 5;
                GFname = getName();
                break;
            case 1:
                Gcreature = "goblin";
                Gtype = "normal";
                Ghealth = 1000;
                Gdodge = 20;
                Gdamage = 5;
                GFname = getName();
                break;
            case 2:
                Gcreature = "troll";
                Gtype = "normal";
                Ghealth = 2000;
                Gdamage = 15;
                GFname = getName();
                Gdodge = 5;
                break;
            case 3:
                Gcreature = "skeleton";
                Gtype = "undead";
                Ghealth = 700;
                Gdodge = 10;
                Gdamage = 7;
                GFname = getName();
                break;
                
            case 4:
                Gcreature = "golem";
                Gtype = "elemental";
                Ghealth = 1500;
                Gdamage = 7;
                GFname = getName();
                Gdodge = 0;
                break;
            case 5:
                Gcreature = "thug";
                Gtype = "normal";
                Ghealth = 1000;
                Gdamage = 15;
                GFname = getName();
                Gdodge = 20;
                break;
        }
    }
    
    private String getName(){
        Random ran = new Random();
        StringBuilder name = new StringBuilder();
        int x = ran.nextInt(10) + 1;
        switch (x){
            case 1:
                Gname = "Bonespawn";
                name.append("Bonespawn");
                break;
            case 2:
                Gname = "Cloudteeth";
                name.append("Cloudteeth");
                break;
            case 3:
                Gname = "Venomchild";
                name.append("Venomchild");
                break;
            case 4:
                Gname = "Soulseeker";
                name.append("Soulseeker");
                break;
            case 5:
                Gname = "Mistbrood";
                name.append("Mistbrood");
                break;
            case 6:
                Gname = "Cinderfreak";
                name.append("Cinderfreak");
                break;
            case 7:
                Gname = "Mournling";
                name.append("Mournling");
                break;
            case 8:
                Gname = "Blazehound";
                name.append("Blazehound");
                break;
            case 9:
                Gname = "Thunderspawn";
                name.append("Thunderspawn");
                break;
            case 10:
                Gname = "Tombpod";
                name.append("Tombpod");
                break;
        }
        
        x = ran.nextInt(51) + 1;
        
        switch (x){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                name.append(",the rabid " +getGcreature());
                setGdamage(getGdamage() + 10);
                getGattacks().add("madness");
                break;
            case 6:
            case 7:
            case 8:
                name.append(",the greedy " +getGcreature());
                setGhealth(getGhealth() + 300);
                setGdamage(getGdamage() + -10);
                getGattacks().add("steal");
                getGattacks().add("runaway");
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                name.append(",the foolish " +getGcreature());
                setGdodge(getGdodge() + -10);
                getGattacks().add("confused");
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                name.append(",the caster " +getGcreature());
                setGhealth(getGhealth() + -500);
                getGattacks().add("fireball");
                getGattacks().add("heal");
                break;
            case 20:
            case 21:
            case 22:
            case 23:
                name.append(",the crazy " +getGcreature());
                setGdamage(getGdamage() + 20);
                setGdodge(getGdodge() + -5);
                getGattacks().add("madness");
                getGattacks().add("yell");
                getGattacks().add("dmgbuff");
                break;
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                name.append(",the sturdy " +getGcreature());
                setGhealth(getGhealth() + 1000);
                getGattacks().add("armor");
                getGattacks().add("sweep");
                break;
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                name.append(",the lucky " +getGcreature());
                setGdodge(getGdodge() + 20);
                getGattacks().add("buffdodge");
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                name.append(",the cowardly " +getGcreature());
                getGattacks().add("cover");
                getGattacks().add("runaway");
                getGattacks().add("yell");
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                name.append(",an average " +getGcreature());
                break;
            case 50:
            case 51:
                name.append(",the legendary " +getGcreature());
                setGhealth(getGhealth() + 1000);
                setGdamage(getGdamage() + 30);
                setGdodge(getGdodge() + 5);
                getGattacks().add("obliterate");
                getGattacks().add("heal");
                getGattacks().add("sweep");
                break;
        }
        return name.toString();
    }
    
   
    @Override
    public String toString(){
        return "Monster name: " +getGFname()+"\nMonster type: " +getGtype()+ "\nMonster health: " +getGhealth()+"\nMonster damage: " +getGdamage()+ "\nMonster dodge: " +getGdodge();
    }

    /**
     * @return the Gname
     */
    public String getGname() {
        return Gname;
    }

    /**
     * @return the GFname
     */
    public String getGFname() {
        return GFname;
    }

    /**
     * @return the Gtype
     */
    public String getGtype() {
        return Gtype;
    }

    /**
     * @return the Gcreature
     */
    public String getGcreature() {
        return Gcreature;
    }

    /**
     * @return the Ghealth
     */
    public int getGhealth() {
        return Ghealth;
    }

    /**
     * @return the Gdodge
     */
    public int getGdodge() {
        return Gdodge;
    }

    /**
     * @return the Gdamage
     */
    public int getGdamage() {
        return Gdamage;
    }

    /**
     * @return the Gattacks
     */
    public ArrayList<String> getGattacks() {
        return Gattacks;
    }

    /**
     * @param Ghealth the Ghealth to set
     */
    public void setGhealth(int Ghealth) {
        this.Ghealth = Ghealth;
    }

    /**
     * @param Gdodge the Gdodge to set
     */
    public void setGdodge(int Gdodge) {
        this.Gdodge = Gdodge;
    }

    /**
     * @param Gdamage the Gdamage to set
     */
    public void setGdamage(int Gdamage) {
        this.Gdamage = Gdamage;
    }
}
