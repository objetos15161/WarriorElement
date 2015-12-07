import greenfoot.*;

/**
 * Clase Obstaculo.
 * 
 * @author Omar Negrete. 
 * @author Leonardo Hervert. 
 * @version 20/Nov/2015
 */
public class Obstaculo extends Actor
{
    private ElementWorld w;
    /**
     * Act - do whatever the Obstaculo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    /**
     * Envia un mensaje para disminuir la vida de Warrior.
     */
    public void checkTouch()
    {       
        
        if (isTouching(Warrior.class))
        {                  
             w.disminuyeVida(0);
                        
        }      
    }
    
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
      w = (ElementWorld) world;
    }
}
