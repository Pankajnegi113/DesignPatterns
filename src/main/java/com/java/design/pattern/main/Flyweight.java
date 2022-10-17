package com.java.design.pattern.main;


//Interinsic - property that remains same for all object
//Extrinsic - property that changes from object to object

/*will create counterStrike game with 20 players terriorist/anti-terrorist - won't be creating 20 objects
instead will have two object one for terriorist and another for anti-terrorist, since  will have
same property for each terriorist except the gun type they choose for, and same goes for anti-terrorist.

Will keep a map , so that if an object is already there will return that and will just ask for the gun for that player

So will use map and factory to getPlayerType object
Interinsic property i.e task for all playerType objects will be same
Extrinsic property i.e gunType will take as input argument for the object creation.
*/

import java.util.HashMap;
import java.util.Random;

interface Player
{
    public void assignWeapon(String weapon);
    public void mission();
}

class Terrorist implements Player
{
    // Intrinsic Attribute
    private final String TASK;

    // Extrinsic Attribute
    private String weapon;

    public Terrorist()
    {
        TASK = "PLANT A BOMB";
    }
    public void assignWeapon(String weapon)
    {
        // Assign a weapon
        this.weapon = weapon;
    }
    public void mission()
    {
        //Work on the Mission
        System.out.println("Terrorist with weapon "
                + weapon + "|" + " Task is " + TASK);
    }
}

class CounterTerrorist implements Player
{
    //Intrinsic Attribute
    private final String TASK;

    //Extrinsic Attribute
    private String weapon;

    public CounterTerrorist()
    {
        TASK = "DIFFUSE BOMB";
    }
    public void assignWeapon(String weapon)
    {
        this.weapon = weapon;
    }
    public void mission()
    {
        System.out.println("Counter Terrorist with weapon "
                + weapon + "|" + " Task is " + TASK);
    }
}

// Class used to get a player using HashMap (Returns
// an existing player if a player of given type exists.
// Else creates a new player and returns it.
class PlayerFactory
{
    //Map stores the reference to the objects of TS or CT
    private static HashMap<String, Player> playerTypeMap = new HashMap<String, Player>();

    public static Player getPlayer(String type)
    {
        Player player = null;

        /*if object already there , return it */
        if (playerTypeMap.containsKey(type))
            player = playerTypeMap.get(type);
        else
        {
            switch(type)
            {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    player = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    player = new CounterTerrorist();
                    break;
                default :
                    System.out.println("Unreachable code!");
            }
            playerTypeMap.put(type, player);
        }
        return player;
    }
}

// Driver class
public class Flyweight
{
    // All player types and weapon (used by getRandPlayerType()
    // and getRandWeapon()
    private static String[] playerType = {"Terrorist", "CounterTerrorist"};
    private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};

    public static void main(String args[])
    {
        /* Assume that we have a total of 20 players in the game. */
        for (int i = 0; i < 20; i++)
        {
            /* getPlayer() is called simply using the class
               name since the method is a static one */
            Player p = PlayerFactory.getPlayer(getRandPlayerType());

            /* Assign a weapon chosen randomly uniformly
               from the weapon array  */
            p.assignWeapon(getRandWeapon());

            // Send this player on a mission
            p.mission();
        }
    }

    // Utility methods to get a random player type and
    // weapon
    public static String getRandPlayerType()
    {
        Random r = new Random();

        // Will return an integer between [0,2)
        int randInt = r.nextInt(playerType.length);

        // return the player stored at index 'randInt'
        return playerType[randInt];
    }
    public static String getRandWeapon()
    {
        Random r = new Random();

        // Will return an integer between [0,5)
        int randInt = r.nextInt(weapons.length);

        // Return the weapon stored at index 'randInt'
        return weapons[randInt];
    }
}
