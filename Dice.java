/**
 * Simple Board Game, FIT9131 Assignment1.
 * Create a dice.
 * 
 * @author Jyhwoei Yang 
 * @version 04/04/2017
 */

public class Dice
{
   private int maximumNumber;
   
   //Print a random number
   /**
    * Constructor for objects of class Dice
    */
   public Dice()
   {
       maximumNumber = 6;
   }
   
   /**
    * Generate and return a random number between 1 and 
    * the maximum number, inclusive, entered as a parameter.
    */
   public int generateRandomNumber(int maximumNumber)
   {
       return 1 + (int) (Math.random() * maximumNumber);
   }
   
   private void printRandomNumber(int maximumNumber) //method to print test message : RandomNumber
   {
       System.out.println(generateRandomNumber(maximumNumber));
   }    
}
