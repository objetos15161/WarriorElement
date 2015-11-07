import greenfoot.*;

/**
 * Write a description of class ElementWorld here.
 * 0,
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElementWorld extends ScrollWorld
{
    private Warrior jugador;
    /**
     * Constructor for objects of class ElementWorld.
     * 
     * 
     */
    public ElementWorld()
    {
        super(800,600,1,3720,600);
        jugador = new Warrior();
        addObject(jugador,30,450);
        addCameraFollower(jugador,30, 450);


    }
    public void act()
    {
        
    }
}
