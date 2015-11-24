import greenfoot.*;

/**
 * Write a description of class Estaca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estaca extends Obstaculo
{
    private ElementWorld w;
    /**
     * Act - do whatever the Estaca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int y=getY();
        int x=getX();
        setLocation(x,y+1);        
        checkLimit();
    } 
    
    public void checkLimit()
    {
        if(isTouching(Warrior.class))
        {
            w.disminuyeVida();
            w.removeObject(this); 
        }
        else        
        if(isTouching(Suelo.class))
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
