package CSS.css;


public class game
{
    //game board
        private char[][] board;
        
    //round
        private int round;
    
    //player
        private Player p1;
        private Player p2;

    /** constructor
     */
    public game()
    {
        //table
            board = new char[3][3];
            cleanGame();
    }

    public game(Player p1, Player p2)
    {
        //table
            board = new char[3][3];
            cleanGame();
        
        //players
            this.p1 = p1;
            this.p2 = p2;
    }

    /** moveP1
     * para: 
     *      - (int) row: row index
     *      - (int) col: column index
     * var:
     *      - n/a
     * function:
     *      - record player move on the board
     * description:
     *      1. change cell to player icon
     *      2. increase round
     * return:
     *      - void
     */
    public void moveP1(int row, int col)
    {
        board[row][col] = p1.getIcon();
        round++;
    }

    /** moveP2
     * para: 
     *      - (int) row: row index
     *      - (int) col: column index
     * var:
     *      - n/a
     * function:
     *      - record player move on the board
     * description:
     *      1. change cell to player icon
     *      2. increase round
     * return:
     *      - void
     */
    public void moveP2(int row, int col)
    {
        board[row][col] = p2.getIcon();
        round++;
    }

    /** moveCheck
     * para: 
     *      - (int) row: row index
     *      - (int) col: column index
     * var:
     *      - (char) cell: cell value
     * function:
     *      - check if cell is available
     * description:
     *      1. check if cell exist
     *      2. check if cell occupied
     * return:
     *      - (boolean)
     *          + true: cell exist and unoccupied
     *          + false: game is either not exist or already occupied
     */
    public boolean moveCheck(int row, int col)
    {
        //check if move in range
        if ((row < 3) && (col < 3))
        {
            char cell = board[row][col];
            
            //check if move occupied
            if ((cell == ' '))
            {
                return true;
            }
        }
        return false;
    }

    /** display
     * para:
     *      - n/a
     * var:
     *      - n/a   
     * function:
     *      - print board
     * description:
     *      1. clean console
     *      2. use nested loop to print each cell
     * return:
     *      - void
     */
    public void display()
    {
        //clean console screen
        System.out.print('\u000C');

        //print board
        for (int i = 0; i < 3; i++) //row
        {
            for (int j = 0; j < 3; j++) //column
            {
                System.out.print("[" + board[i][j] + "]");
            }
            //next row
            System.out.println();
        }
    }

    /** cleanGame
     * para:
     *      - n/a
     * var:
     *      - n/a
     * function:
     *      - reset all cell and round count
     * description:
     *      1. fill all cell with ' ' and change round count (round) to 0
     * return:
     *      - void
     */
    public void cleanGame()
    {
        //reset board
        for (int i = 0; i < 3; i++) //row
        {
            for (int j = 0; j < 3; j++) //column
            {
                board[i][j] = ' ';
            }
        }

        //reset round count
        this.round = 0;
    }
    
    /** gameEnd
     * para: 
     *      - n/a
     * var:
     *      - n/a
     * function:
     *      - check if the game is over
     * description:
     *      1. check if game is over by 1 of 2 factors
     *          + no more cells available
     *          + a player win
     * return:
     *      - (boolean) 
     *          + true: game is over
     *          + false: game is not over
     */
    public boolean gameEnd()
    {
        //out of spaces
        if (round == 9) 
        {
            return true;
        }
        //player win
        else if(playerWin(lastPlayer())) 
        {
            return true;
        }

        return false;
    }

    /** lastPlayer()
     * para:
     *      - n/a
     * var:
     *      - n/a
     * function:
     *      - find whose playing
     * description:
     *      - find which player is playing base on the latest count
     * return:
     *      - (Player) last player
     */
    private Player lastPlayer()
    {
        if (this.round % 2 == 0)
        {
            return p2;
        }
        else
        {
            return p1;
        }
    }

    /** playerWin()
     * para:
     *      - (Player) player: player with latest move
     * var:
     *      - (char) icon: placeholder for player's icon
     *      - (int) count: number of repeats
     * function:
     *      - check if an icon repeat 3 time consecutively
     * description:
     *      1. check for repeat by rows
     *      2. check for repeat by columns
     *      3. check for repeat by downward diagnal (top left - bottom right)
     *      4. check for repeat by upward diagnal (top right - bottom left)
     * return:
     *      - (boolean)
     *          + true: repeat 3 times
     *          + false: repeat < 3 
     */
    private boolean playerWin(Player player)
    {
        //icon
            char icon = player.getIcon();
            
        //number of repeating
            int count = 0;

        //check each row   
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (board[row][col] == icon)
                {
                    count++;
                }
            }
 
            if (count == 3)
            {
                return true;
            }
            else 
            {
                //reset count
                count = 0;
            }
        }

        //check each col
        for (int col = 0; col < 3; col++)
        {
            for (int row = 0; row < 3; row++)
            {
                if (board[row][col] == icon)
                {
                    count++;
                }
            }

            if (count == 3)
            {
                return true;
            }
            else
            {
                //reset count
                count = 0;
            }
        }

        //check top left - bottom right
        for (int row = 0; row < 3; row++)
        {
            if (board[row][row] == icon)
            {
                count++;
            }
        }
        if (count == 3)
        {
            return true;
        }
        else
        {
            //reset count
            count = 0;
        }

        //check top right - bottom left
        for (int row = 0; row < 3; row++)
        {
            if (board[row][2 - row] == icon)
            {
                count ++;
            }
        }
        if (count == 3)
        {
            return true;
        }
       
        return false;
    }

    /** getter 
     */
    public Player getP1()
    {
        return this.p1;
    }
    public Player getP2()
    {
        return this.p2;
    }
    public int getRound()
    {
        return this.round;
    }

    /** seter
     */
    public void setP1(Player p1)
    {
        this.p1 = p1;
    }
    public void setP2(Player p2)
    {
        this.p2 = p2;
    }
}
