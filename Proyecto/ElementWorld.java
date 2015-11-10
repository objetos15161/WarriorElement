import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class ElementWorld extends SWorld
{

    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public ElementWorld()
    {    
        //super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        super(800,600,1,3720,600);
        // in the following statement, the main actor is placed at (400, 342) in scroll area coordinates
        addMainActor(new Warrior(), 30,450,250,300); // the last two int parameters are centered window x and y ranges
        GreenfootImage bg = new GreenfootImage("Bosque.png");
        setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects using scroll area coordinates
        
    }
}
