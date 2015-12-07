import greenfoot.*;

/**
 * Clase Meteoro que es un obstaculo que se presenta en el nivel 2.
 * 
 * @author Omar Negrete. 
 * @author Leonardo Hervert. 
 * @version 20/Nov/2015
 */
public class Meteoro extends Obstaculo
{
    private ElementWorld w;

    /**
     * Act de Meteoro.
     */
    public void act() 
    {
        int x=getX();
        int y=getY();
        setLocation(x-1,y+2);      
        checkTouching();
    }  

    /**
     * Envia mensajes para disminuir la vida de Warrior o en caso de no hacerlo
     * enviar mensaje para desaparecer.
     */    
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


