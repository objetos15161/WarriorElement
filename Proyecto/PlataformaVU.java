import greenfoot.*;

/**
 * Write a description of class PlataformaVU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlataformaVU extends Obstaculo
{
    private ElementWorld w;
    
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int y=getY();
        int x=getX();      
        
        setLocation(x,y-1); 
        checkLimit();
        
    }
    
    public void checkLimit()
    {
        int y=getY();
        if(isTouching(Pico.class) || y<10)
        {
            w.removeObject(this);
        }
        
    }
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */protected void addedToWorld(World world)
    {
      w = (ElementWorld) world;
    }
    
}
