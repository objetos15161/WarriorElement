import greenfoot.*;

/**
 * Clase Estaca que representa un obstaculo del nivel 3.
 * 
 * @author Omar Negrete.
 * @author Leonardo Hervert.
 * @version 06/Dic/2015.
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
    
    /**
     * Envia mensajes al mundo para disminuir la vida de Warrior si toca al Objeto
     * Suelo se elimina.
     */
  public void checkLimit()
    {
        if(isTouching(Warrior.class))
        {
            w.disminuyeVida(0);
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
