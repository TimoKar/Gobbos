package too.many.gobbos;
import java.util.Scanner;
import static too.many.gobbos.Gamemain.ran;
import java.util.ArrayList;
/**
 *
 * @author Timo
 */

public class TownAndQuests {
    static Scanner reader = new Scanner(System.in);
    static Scanner reader2 = new Scanner(System.in);
    
    
    
    
    TownAndQuests(){//empty constructor
        
    }   
    
    public static Gamechar Town(Gamechar GC){//Events after entering the town
        boolean leave = false;
        boolean loop = false;
        System.out.println("------------------------");
        System.out.println("You arrive at the town of Kennor.");
        do{
        System.out.println("What would you like to do?(C = inspect yourself, S = smith, H = healer, I = inn, L = library, E = enchanter, D = wander around the town, Leave = continue your journey)");
        Town:
        switch(reader.next().toUpperCase()){
            case ("C")://Prints character stats
                System.out.println(GC);
                System.out.println("------------------------");
            break;
            case ("S")://SMITHY
                loop = true;
                System.out.println("------------------------");
                System.out.println("As you enter the smithy you can feel a strong smell of booze.");
                do{
                System.out.println("\"I can upgrade yer stuffffs if ya pay me.(W = upgrade weapon(500 gold), A = upgrade armor(500 gold), C = cancel and leave)\"");
                switch (reader.next().toUpperCase()){
                    case ("W")://Weapon upgrade
                        if(GC.getMoney() >= 500){
                            System.out.println("Thank ye kindly.(Enter to continue)");
                            reader2.nextLine();
                            System.out.println("An hour passes and the smith is ready with your upgraded weapon.");
                            System.out.println("Here's ya weapon, now be careful not to scratch my work!(Enter to continue)");
                            reader2.nextLine();
                            GC.getWep().setGdamage(GC.getWep().getGdamage() + 10);
                            GC.setMoney(GC.getMoney() - 500);
                            System.out.println("Your weapon now deals " + GC.getWep().getGdamage() + " damage.");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                        }else{
                            System.out.println("I ain't working for free, ya know?");
                            System.out.println("You don't have enough money("+GC.getMoney()+")");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                        }
                        break;
                    case ("A")://Armor upgrade
                        if(GC.getMoney() >= 500){
                            System.out.println("Thank ye kindly.(Enter to continue)");
                            reader2.nextLine();
                            System.out.println("An hour passes and the smith is ready with your upgraded armor.");
                            System.out.println("Here's ya armor, now be careful not to scratch my work!(Enter to continue)");
                            reader2.nextLine();
                            GC.getGclass().setGmaxhealth(GC.getGclass().getGhealth() + 20);
                            GC.setMoney(GC.getMoney() - 500);
                            System.out.println("Your health went up by 20! You have " + GC.getGclass().getGmaxhealth() + " Hp.");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                        }else{//Leave event
                            System.out.println("I ain't working for free, ya know?");
                            System.out.println("You don't have enough money("+GC.getMoney()+")");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                        }
                        break;
                    case ("C"):
                        System.out.println("You leave the smelly smith. As you are leaving you can hear quiet drinking noises begind you.");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                        loop = false;
                        break;
                    default:
                        break;
                }
                }while(loop);
                break;
            case("H")://HEALER
                loop = true;
                System.out.println("------------------------");
                System.out.println("You enter the healers shop.");
                System.out.println("\"Hello, what can i do for you?\"");
                do{
                System.out.println("(H = heal, B = buy upgrades, C = cancel and leave)");
                switch(reader.next().toUpperCase()){
                    case "H":
                        System.out.println("\"I can heal you for 100 points for 50 coins.\"(Y/N)");
                        if(reader.next().toUpperCase().equals("Y")){
                            if(GC.getMoney() >= 50){
                                System.out.println("\"Thank you.\"");
                                if(GC.getGclass().getGmaxhealth() == GC.getGclass().getGhealth()){//Checkin hp amount and heals correspondingly
                                    System.out.println("You are healed, but you don't feel any better? Maybe you were already at maximum hp.");
                                }
                                else if(GC.getGclass().getGmaxhealth() < GC.getGclass().getGhealth() + 100){
                                    System.out.println("You are fully healed.");
                                    GC.setHp(GC.getGclass().getGmaxhealth());
                                }else{
                                    System.out.println("You are still injured.");
                                    GC.setHp(GC.getGclass().getGhealth() + 100);
                                }
                                GC.setMoney(GC.getMoney() - 50);
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                            }else{
                                System.out.print("\"I'm sorry but you don't have enough money.\"(Enter to continue)");
                                reader2.nextLine();
                            }
                        }else{
                            System.out.println("\"Something else then?\"");
                        }
                    break;
                    case "B":
                        System.out.println("\"I can increase your maximum mana by 20 with this potion, and its only 500 gold!(Y/N)");
                        if(reader.next().toUpperCase().equals("Y")){
                            if(GC.getMoney() >= 500){
                                GC.getGclass().setGmaxmana(GC.getGclass().getGmaxmana() + 20);
                                GC.setMoney(GC.getMoney() - 500);
                                System.out.println("Your mana has increased by 20.(Enter to continue)");
                                reader2.nextLine();
                            }else{
                                System.out.print("\"I'm sorry but you don't have enough money.\"(Enter to continue)");
                                reader2.nextLine();
                            }
                        }else{
                            System.out.println("Maybe some other time then.");
                        }
                        break;
                    case "C":
                        loop = false;
                        System.out.println("\"Thank you. Please come again.\". You leave the store");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                    default:
                        break;
                }
                }while(loop);
                break ;
            case("I")://INN
                System.out.println("------------------------");
                System.out.println("\"Hello, looking for a room to rest and recover? 20 gold for one night.\"(Y/N)");
                if(reader.next().toUpperCase().equals("Y")){
                    if(GC.getMoney() >= 20){
                        System.out.println("You stay at the inn for one night. You recover 50hp and 10 mana.");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                        if(GC.getGclass().getGhealth() + 50 > GC.getGclass().getGmaxhealth()){
                            GC.setHp(GC.getGclass().getGmaxhealth());
                        }else{
                            GC.setHp(GC.getGclass().getGhealth() + 50);
                        }
                        if(GC.getGclass().getGmana() + 10 > GC.getGclass().getGmaxmana()){
                            GC.setMana(GC.getGclass().getGmaxmana());
                        }
                        else{
                            GC.setMana(GC.getGclass().getGmana() + 10);
                        }
                        GC.setMoney(GC.getMoney() - 20);
                    }else{
                        System.out.print("\"You don't have enough money.\"");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                    }
                }else{
                    System.out.println("\"My inn is not good enough for you? hmph.\"");
                    System.out.println("------------------------");
                    System.out.print("Enter to continue");
                    reader2.nextLine();
                }
                break;
            case("L"):
                System.out.println("------------------------");
                System.out.println("As you aproach the door of the library you see a note:\"Under construction, come again in a few weeks.\"");
                System.out.println("------------------------");
                System.out.print("Enter to continue");
                reader2.nextLine();
                break;
            case("E")://ENCHANTMENT
                System.out.println("------------------------");
                System.out.println("\"Hiya! I can chance the enhanctment on your sword for a fee of 100 coins.\"(Y/N)");
                if(reader.next().toUpperCase().equals("Y")){
                    if(GC.getMoney() >= 100){
                        System.out.println("\"What enchantment would you like?\"(F = Fire, T = Thunder, M = Magic, C = Cancel).");
                        switch(reader.next().toUpperCase()){
                            case "F":
                                GC.getWep().setGbonus("Fire");
                                GC.setMoney(GC.getMoney() - 100);
                                System.out.println("\"Here you go.\"");
                                System.out.println("Your new weapon is searing with heat.");
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                            break;
                            case "T":
                                GC.getWep().setGbonus("Thunder");
                                GC.setMoney(GC.getMoney() - 100);
                                System.out.println("\"Here you go.\"");
                                System.out.println("Your new weapon is crackling with energy.");
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                            break;
                            case "M":
                                GC.getWep().setGbonus("Magic");
                                GC.setMoney(GC.getMoney() - 100);
                                System.out.println("\"Here you go.\"");
                                System.out.println("Your new weapon glowing with power.");
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                            default:
                            break;
                        }
                    }else{
                        System.out.print("\"You don't have enough money... sad times.\"");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                    }
                }else{
                    System.out.println("\"Alright maybe next time.\"");
                    System.out.println("------------------------");
                    System.out.print("Enter to continue");
                    reader2.nextLine();
                }
                break;
            case("LEAVE"):
                System.out.println("------------------------");
                System.out.println("You decide to leave the city for now.");
                System.out.println("------------------------");
                System.out.print("Enter to continue");
                reader2.nextLine();
                leave = true;
                break;
            default://ALL OF THE RANDOM WANDER EVENTS AND QUESTS
                System.out.println("------------------------");
                int x = ran.nextInt(25) + 1;
                int d = ran.nextInt(10) + 1;
                switch (x){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    default:
                        System.out.println("You find nothing that intresting.");
                        System.out.println("------------------------");
                        System.out.print("Enter to continue");
                        reader2.nextLine();
                        break Town;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        System.out.println("A thief attacks you and tries to steal your money!");
                        if(GC.Thief == 0){//Thief quest
                        System.out.println("Do you run after him?(y/n)");
                        if(reader.next().toUpperCase().equals("Y")){//Player runs after the thief
                            if(d > 3){//Player catches the thief
                                System.out.println("You catch the thief and bring him to the guard. They reward you with 100 gold!");
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                GC.setMoney(GC.getMoney() + 100);
                                break Town;
                            }else{//Player doesn't catch the thief
                                System.out.println("You run out of breath and the thief runs away. Angered by this you prepare a trap for next thief that tries his luck.");
                                GC.Thief = 1;
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                GC.Smoney = GC.getMoney();
                                GC.setMoney(0);
                                break Town;
                            }
                        }else{//Player gives up
                            System.out.println("You deside to give up and let the thief run away with your money. Maybe you felt sorry for this person?");  
                            GC.setMoney(0);
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                            break Town;
                        }
                        }else if(GC.Thief == 1){//If player was robbed earlier and set up a trap
                            System.out.println("This time you were prepared for thiefs and managed to catch him before he got your money.");
                            System.out.println("To your supprise it's the same thief that robbed you earlier. You get your money back and a reward of 100 coins!");
                            GC.setMoney(GC.getMoney()+ GC.Smoney + 100);
                            GC.Thief = 2;
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                            break Town;
                        }else{//Player has completed the thief questline
                            System.out.println("You still have your systems ready for thiefs and capture him easily. You get a reward of 100 gold from the guards!");
                            GC.setMoney(GC.getMoney() + 100);
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                            break Town;
                        }
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        if(GC.Priest == 0){//Priest quest
                            System.out.println("You find a menrva priest talking about the power of Gormunda, who is the only living sorcerer of his race. It seems they worship her as god.");
                            System.out.println("\"Server our god Gormunda and maybe even you might get a piece of her unlimited power.\"");
                            System.out.println("What do you want to do? T = talk to the priest, C = continue");
                            if(reader.next().toUpperCase().equals("T")){
                                System.out.println("\"You,my child seem like a capable warrior, would you like to slay a troll that has been attacking peasants outside the town in the name of our mighty god? \nI shall reward you with some of her powers if you complete this task.(Y/N)\"");
                                if(reader.next().toUpperCase().equals("Y")){//Player takes the quest
                                    System.out.println("You deside to take this quest and slay your next troll in the name of Gormunda.");
                                    GC.Priest = 1;
                                    System.out.println("------------------------");
                                    System.out.print("Enter to continue");
                                    reader2.nextLine();
                                    break Town;
                                }else{//Player doesn't take the quest
                                    System.out.println("You leave the priest to his mad ramblings and continue your journey.");
                                    System.out.println("------------------------");
                                    System.out.print("Enter to continue");
                                    reader2.nextLine();
                                    break Town;
                                }
                            }else{
                                System.out.println("You leave the priest to his mad ramblings and continue your journey.");
                                System.out.println("------------------------");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                break Town;
                            }
                        }else if(GC.Priest == 1){
                            System.out.println("You find a familiar menrva priest talking about the power of Gormunda. He's continuing his prearching as usual.");
                            System.out.println("He notices you and says \"Have you completed my request? No? Then come back to me when you have.\"");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                            break Town;
                        }else if(GC.Priest == 2){
                            System.out.println("You find a familiar menrva priest talking about the power of Gormunda. He's continuing his prearching as usual.");
                            System.out.println("He notices you and says \"Have you completed my request? Yes? Wonderfull i ask that you come to our temple today to receive your powers.\"");
                            System.out.print("Do you go to the temple now?(Y/N)");
                            if(reader.next().toUpperCase().equals("Y")){
                                System.out.println("You arrive to the temple with the priest. The temple is located underground. the walls and furniture are decorated bone and dragonscales.");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                System.out.println("\"Welcome to our temple. This place is dedicated to power of our god. Everything here is made from dragon parts to praise her powers as god.\"");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                System.out.println("\"We shall now begin the ritual. You need to stay here for tonight in order to recover from the ritual.\"");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                System.out.println("As the ritual progresses you can feel something powerfull flowing inside you.");
                                System.out.println("\"Can you feel that? It's pure power made possible by her blessings, she seems to listen us at this very moment!\"");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                System.out.println("You fall unconcious and wake the next morning.");
                                System.out.println("\"You now have the blessing of our god. Use it in her name and nothing shall stop you!(You now have the skill Fireball and your maximum mana has been increased)\"");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                GC.Priest = 3;
                                GC.getGclass().setGmaxmana(GC.getGclass().getGmaxmana() + 50);
                                ArrayList attacks = GC.getGclass().getAttacks();
                                attacks.add("Fireball");
                                GC.getGclass().setAttacks(attacks);
                                System.out.println("You leave the temple and continue your journey.");
                                System.out.print("Enter to continue");
                                reader2.nextLine();
                                break Town;
                            }
                        }else {
                            System.out.println("You find a familiar menrva priest talking about the power of Gormunda. He's continuing his prearching as usual.");
                            System.out.println("He notices you and says \"Thank you warrior of Gormunda.\". You continue your journey.");
                            System.out.println("------------------------");
                            System.out.print("Enter to continue");
                            reader2.nextLine();
                            break Town;
                        }
                        break Town;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        Monster M = new Monster(5);
                        Wander.combat(GC, M, true);
                        if(GC.getGclass().getGhealth() <= 0){
                            leave = true;
                            break Town;
                        }
                }
        }
        }while(leave == false);
        return GC;
    }
}

