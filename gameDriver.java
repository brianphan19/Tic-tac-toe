package CSS.css;

import java.util.Scanner;

public class gameDriver
{
    public static game game;

    public static void main(String[] args)
    {
        //declare objects
            Player p1 = new Player('x');
            Player p2 = new Player('o');
            game = new game(p1, p2);   

        //run game
        while (!game.gameEnd())
        {
            //print board game
            game.display();
            
            //decide which player is playing base on round count
            if (game.getRound() % 2 == 0)
            {
                player1(game);
            }
            else
            {
                player2(game);
            }          
        }

        // //print winner
        game.display();
        victor(game);
        
        //test
        // int[] row = {0, 0, 0, 1, 0, 2};
        // int[] col = {0, 0, 1, 0, 2, 0};
        // int[] diag1 = {0, 0, 1, 1, 2, 2};
        // int[] diag2 = {0, 2, 1, 1, 2, 0};
        // int[] notEnd = {0, 0, 1, 1, 2, 0};
        // int[] full = {0, 0, 0, 1, 0, 2, 1, 0, 1, 1, 1, 2, 2, 0, 2, 1, 
        //              2, 2};
        // testWin(game, full);
    }

    /** player 1
     * para:
     *      - (game) game: game object
     * var:
     *      - (Scanner) kb: console input stream
     *      - (int) row: row index
     *      - (int) col: column index
     * function:
     *      - ask for player move and initiate the move
     * description:
     *      1. ask for move index 
     *      2. check if move is valid, if:
     *          + valid: proceed to step 3
     *          + invalid: repeat step 1
     *      3. initiate the move
     */
    public static void player1(game game)
    {
        //declare 
            Scanner kb = new Scanner(System.in);
            int row;
            int col;

        // ask for user input
        do
        {
            System.out.println("\nPlayer 1: enter your move index " +
                            "<row> <column>");

            row = kb.nextInt();
            col = kb.nextInt();
        }
        //check if move is valid
        while (!game.moveCheck(row, col));

        //initiate move
        game.moveP1(row, col);
    }

    /** player 2
     * para:
     *      - (game) game: game object
     * var:
     *      - (Scanner) kb: console input stream
     *      - (int) row: row index
     *      - (int) col: column index
     * function:
     *      - ask for player move and initiate the move
     * description:
     *      1. ask for move index 
     *      2. check if move is valid, if:
     *          + valid: proceed to step 3
     *          + invalid: repeat step 1
     *      3. initiate the move
     */
    public static void player2(game game)
    {
        //declare 
            Scanner kb = new Scanner(System.in);
            int row;
            int col;

        // ask for user input
        do
        {
            System.out.println("\nPlayer 2: enter your move index " +
                             "<row> <column>");
            row = kb.nextInt();
            col = kb.nextInt();
        }
        //check if move is valid
        while (!game.moveCheck(row, col));

        //initiate move
        game.moveP2(row, col);
    }

    /** victor
     * para:
     *      - (game) game: game object
     * var:
     *      - n/a
     * function: 
     *      - declare whether a draw or a win
     * description:
     *      1. check whether its a draw
     *          + draw: print draw
     *          + not draw: ignore and proceed
     *      2. print the winner base on latest round count
     * return:
     *      - void
     */
    public static void victor(game game)
    {   
        if (game.getRound() == 9) //when no more space to play
        {
            System.out.println("Draw!");
        }
        else //decide which player base on the latest round count
        {
            if (game.getRound() % 2 == 0)
            {
                System.out.println("Player 2 win!");
            }
            else
            {
                System.out.println("Player 1 win!");
            }
        }
    }
    
    public static void testWin (game game, int[] array)
    {
        game.cleanGame();
        
        for (int i = 0; i < array.length; i += 2)
        {
            game.moveP1(array[i], array[i+1]);
        }
        
        game.display();
        System.out.println("Game end: " + game.gameEnd());
    }
}
