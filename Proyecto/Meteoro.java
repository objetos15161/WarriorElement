import greenfoot.*;

/**
 * Write a description of class Meteoro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteoro extends Obstaculo
{
    private ElementWorld w;

    /**
     * Act - do whatever the Meteoro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x=getX();
        int y=getY();
        setLocation(x-1,y+2);      
        checkTouching();
    }  

        public void checkTouching()
    {       
        int x=getX();
        int y=getY();
        if (isTouching(Warrior.class))
        {                  
             w.disminuyeVida(4);
             w.removeObject(this);             
        } 
        else
        {
            if(y>=550)
             {
              w.removeObject(this);
             }
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


