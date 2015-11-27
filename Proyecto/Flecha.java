import greenfoot.*;

/**
 * Write a description of class flecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flecha extends Actor
{
    /**
     * Act - do whatever the flecha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private ElementWorld w;
    public Flecha()
    {
        
    }

    public void act() 
    {
        // Add your action code here.
        ElementWorld element= (ElementWorld)getWorld();
        Golem gol = element.dimeGolem();
        Soldado sol = element.dimeSoldado();
        setLocation(getX()+5,getY());
        if(getY()<=0)
            element.removeObject(this);

        if(isTouching(Golem.class)) 
        {
              gol.disminuyeVida(); 
            
       }
       if(isTouching(Soldado.class))
       {
           sol.disminuyeVida();
       }
    }  
}