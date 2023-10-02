package CSS.css;


/**
 * Write a description of class board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private char icon;

    /** Constructor
     */
    public Player()
    {
        
    }
    public Player(char icon)
    {
        this.icon = icon;
    }
    
    
    /** getter
     */
    public char getIcon ()
    {
        return this.icon;
    }
    /** setter
     */
    public void changeIcon(char icon)
    {
        this.icon = icon;
    }
}
