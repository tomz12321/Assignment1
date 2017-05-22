
/**
 * Simple Board Game, FIT9131 Assignment1.
 * Create a class for two players.
 * 
 * @author Jyhwoei Yang
 * @version 21/03/2017
 */

public class Player
{
    // instance variables
    private String playerName;
    private int playerPosition;
    
    /**
     *  Constructor with parameters for objects of class Player
     */
    public Player(String name,int position) //constructor with parameters
    {
        playerName = name;
        playerPosition = position;
    }
    
    /**
     *  Default Constructor for objects of class Player
     */
    public Player() //default constructor
    {
        playerName = "";
        playerPosition = 0;
    }
    
    /**
     *  Method to return playerName
     */
    public String getName() //method return playerName
    {
        return playerName; 
    }
    
    /**
     *  Method to set playerName
     */
    public void setName(String name) //method set playerName
    {
        playerName=name; 
    }
    
    /**
     *  Method to return playerPosition
     */
    public int getPosition() //method to return playerPosition
    {
        return playerPosition; 
    }
    
    /**
     *  Method to set playerPosition
     */
    public void setPosition(int position) //method to set playerPosition
    {
        playerPosition = position; 
    }
    
    private void display() //method for testing display function
    {
        System.out.println(playerName);
        System.out.print(playerPosition);
    }

}
