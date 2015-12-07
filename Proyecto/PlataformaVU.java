import greenfoot.*;

/**
 *  Clase simple que representa a una plataforma con movimiento vertical
 * hacia arriba.
 * 
 * @author Omar Negrete.
 * @author Leonardo Hervert.
 * @version 06/Dic/2015.
 */
public class PlataformaVU extends Obstaculo
{
    private ElementWorld w;
    
    /**
     * Act permite que la plataforma se mueva de abajo hacia arriba
     */
    public void act() 
    {
        int y=getY();
        int x=getX();      
        
        setLocation(x,y-1); 
        checkLimit();
        
    }
    
        /**
     *Envia un mensaje cuando toca a un objeto de la clase Pico para eliminarse. 
     */
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
