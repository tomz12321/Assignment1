import java.util.*;
import java.lang.*;
/**
 * Simple Board Game, FIT9131 Assignment1.
 * 
 * @author Jyhwoei Yang 
 * @version 10/04/2017
 */
public class Game
{
    // instance variables - replace the example below with your own
    private Player player1;
    private Player player2;
    private Dice dice;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables
        player1 = new Player();
        player2 = new Player();
        dice = new Dice();
    }
    
    /**
     * Constructor for objects of class Game if it has parameters
     */
    public Game(String game)
    {
        // initialise instance variables
        player1 = new Player();
        player2 = new Player();
        dice = new Dice();
    }
    
    /** 
     *  Method to start a game
     */
    public void start() //method to start a game
    {
        String gamename = "";
        Scanner console = new Scanner(System.in);
        
        //start a new game
        System.out.println("Insert a game name: ");
        //insert game name
        gamename = console.nextLine();
        
       //isGameName.equals(""), "Error: Game name shouldn't be blank! Please enter the name again:" 
       //check console.nextLine() is not null or blank       
       while (checkBlank(gamename,"Game"))
            gamename = console.nextLine();
       
        play(gamename);
    }
    
    private boolean checkBlank(String iobuffer,String subject) //method to check insert any emptys or blanks
    {
       if (subject.equals("Option"))
       {
          //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (5)! and return false to break if condition
          if (iobuffer.isEmpty() || iobuffer.length() > 1)
          {
              System.out.println("Error : please insert from (1) to (5)!");
              return false;
          }
          return true;
       }
       else
       {    
            //isPlayer1Name.trim().isEmpty(), "Error: Player1's name shouldn't be blank! Please enter the name again:" and return true to keep while condition
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " name shouldn't be blank! Please enter the name again:");
                return true;
            }
       }
       return false;
    }
    
    private boolean checkIsPlayersSetup() //method to check whether player is setup or not
    {
       //if players have not been set up, show Error message!
       if (player1.getName().equals(""))
       {
           System.out.println("Error : players have not been set up!");
           return true;
       }else
       {
           return false;
       }
    }
   
   
    private boolean checkLastGameFinished(String winner) //method to check last game is finished or not
    {
       //if game finished and haven't start a new game, show Error message!
       if (!winner.equals(""))
       {
           System.out.println("Game Finised.");
           System.out.println("The last game was won by Player " + winner + "");
           System.out.println("Please select (1) to start a new game!");                     
           return true;
       }
       else
       {
           return false; 
       }
       
    }
    
    private boolean checkOption(char option) //method to check char option
    {
        //check if option is in 1,2,3,4,5 , and return false to break if condition
        if (option < '1' || option > '5')
        {
            System.out.println("Error : please insert from (1) to (5)!");
            return false;
        }
        return true;        
    }
    
    private String checkPenalty(Player player,int move) //method to check Penalty
    {
       //check players Penalty
   
       //Penalty on Location 11/22/33/44/55
       if (move % 11 == 0 && move < 55)
       {
           move = move - 5;
           //System.out.println("Player " + player.getName()+" rolled a "+ step + ", and moves from position " + player.getPosition() + " to " + move + " (Penalty)");
           player.setPosition(move);
           return move + " (Penalty)";
       }
       else
       {
           //System.out.println("Player " + player.getName()+" rolled a "+ step + ", and moves from position " + player.getPosition() + " to " + move);
           player.setPosition(move);
           return move + "";
       }
    }
    
    private void displayMainMenu() //method to print Main Menu
    {
       //print menu
       System.out.println("");
       System.out.println("Welcome to the Simple Board Game");
       System.out.println("================================");
       System.out.println("(1) Start/Restart a Game");
       System.out.println("(2) Play One Round");
       System.out.println("(3) Display Players' Positions");
       System.out.println("(4) Display Game Help");
       System.out.println("(5) Exit Game");
       System.out.print("Choose an option :");
    }
    
    private void displayPlayerPosition() //method to print out both players positions
    {
       //Player andy is on position 0
       System.out.println("Player " + player1.getName() + " is on position " + player1.getPosition());
       //Player david is on position 0
       System.out.println("Player " + player2.getName() + " is on position " + player2.getPosition());
    }
    
    private String gameResult() //method to show game result in the end
    {
       //** Congratulations, david have WON this game. **
       
       //initialised variables
       String winner = "";
       
       if (player1.getPosition() >= 50 && player2.getPosition() >= 50)
       {
           //output result message: "** It's a draw game, no one have WON this game. **"
           System.out.println("** It's a draw game, no one have WON this game. **");
           
           //set winner 
           winner = "both " + player1.getName() + " and " + player2.getName();
       }
       else if (player2.getPosition() >= 50)
       {
           System.out.println("");
           //output result message: "** Congratulations, player2 have WON this game."
           System.out.println("** Congratulations, " + player2.getName() + " have WON this game. **");
           
           //set winner
           winner = player2.getName();
           
           System.out.println("Game finished. You must start a new game");
           System.out.println("The last game was won by Player " + winner + "");
       }
       else if (player1.getPosition() >= 50)
       {
           System.out.println("");
           //output result message: "** Congratulations, player1 have WON this game."
           System.out.println("** Congratulations, " + player1.getName() + " have WON this game. **");
           
           //set winner
           winner = player1.getName();

           System.out.println("Game finished. You must start a new game");
           System.out.println("The last game was won by Player " + winner + "");
       }
       return winner;
    }

    /**
     *  Static Method to setup a main method
     *
     *  @param arg
     */
    public static void main(String[] arg)
    {
        Game game1 = new Game();
        game1.start();
    }

    private void movement(Player player,int move) //method to make players movement
    {
       //Player throw a dice and make movement
       int steps = 0;
       String curPosition = "";
       int oriPosition = 0;
       
       //player's move
       oriPosition = player.getPosition();
       steps = dice.generateRandomNumber(6);
       move = player.getPosition() + steps;
       
       curPosition = checkPenalty(player, move);
       //display Player's movement
       System.out.println("Player " + player.getName() + " rolled a " + steps + ", and moves from position " + oriPosition + " to " + curPosition);
      
    }
    
    private void play(String game) //method to play games
    {
        // initialise instance variables
        Scanner console = new Scanner(System.in);
        String iobuffer = "";
        char option = ' ';
        boolean playing = true;
        String winner = "";
        
        //display game name
        System.out.println("");
        System.out.println("This game is " + game);
        
        while (playing)
            {
                //print menu
                displayMainMenu();
                //insert case
                iobuffer = console.nextLine();
                System.out.println("");
                
                //check console.nextLine() is not null or blank
                if (checkBlank(iobuffer,"Option"))
                {   
                    //set option
                    option = iobuffer.charAt(0);
                    
                    //if option not in 1,2,3,4,5 Error : please insert from (1) to (5)!
                    if (checkOption(option))
                    {
                            //start switch
                            switch (option)
                            {
                                   case '1':
                                        //Start/Restart a Game, call setupNewplayers();
                                        setupNewPlayers();
                            
                                        //reset the winner=""
                                        winner = "";
                    
                                        break;
                    
                                   case '2':
    
                                        //if players have not been set up, show Error message!
                                        if (checkIsPlayersSetup())
                                            break;
                                            
                                        //if game finished and haven't start a new game, show Error message!
                                        if (checkLastGameFinished(winner))
                                            break;
                        
                                        //Play One Round                     
                                        playOneRound();
                        
                                        //display game result : ** Congratulations, david have WON this game. ** and set winner
                                        winner = gameResult();
                         
                                        break;
                        
                                    case '3':
   
                                        //if players have not been set up, show Error message!
                                        if (checkIsPlayersSetup())
                                            break;
                        
                                        //if game finished and haven't start a new game, show Error message!
                                        if (checkLastGameFinished(winner))
                                            break;
                                        
                                        //Display Players' Positions    
                                        displayPlayerPosition();
                                    
                                        break;
                            
                                    case '4':
                                        //Show menu
                                        playing = true;
                        
                                        break;
                            
                                    case '5':
                                        //Exit game
                                        playing = false;
                                        System.out.println("Game finished. You must start a new game");
                        
                                        break;
                            }
                    }
                }
            }
    }
   
   private void playOneRound() //method to play one round
   {
       /*  Play One Round
        *  andy rolled a 6, and moves from position 30 to 36
        *  david rolled a 5, and moves from position 45 to 50
        */
       
       //initialised variables, keep move flags for expansions
       int move1 = 0;
       int move2 = 0;
              
       //player1's move
       movement(player1,move1);
      
       //player2's move
       movement(player2,move2);
   }
   
   private void setupNewPlayers() //method to set up new players
   {
       //initialised variables 
       String namebuffer = "";
       Scanner console = new Scanner(System.in);
       
       //setup new players
       
       //insert names for 1st player
       System.out.println("please insert first player's name:");
       namebuffer = console.nextLine();
       
      //check console.nextLine() is not empty or blank
       while(checkBlank(namebuffer,"Player1's"))
            namebuffer = console.nextLine();
          
       //setPlayer1Name
       player1.setName(namebuffer);
       player1.setPosition(0);
                    
       System.out.println("Player1's name: " + player1.getName());
       
       //insert names for 2nd player
       System.out.println("");
       System.out.println("please insert second player's name:");
       
       namebuffer = "";
       namebuffer = console.nextLine();
       
       //check console.nextLine() is not empty or blank
       while(checkBlank(namebuffer,"Player2's"))
            namebuffer = console.nextLine();
       
       //setPlayer2Name                 
       player2.setName(namebuffer);
       player2.setPosition(0);
                    
       System.out.println("Player2's name: " + player2.getName());

    }
    
    
}