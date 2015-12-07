import greenfoot.*;

/**
 * Clase que representa el ataque de la armadura de viento.
 * 
 * @author Leonardo Hervert. 
 * @author Omar Negrete.
 * @version 06/Nov/2015.
 */
public class Flecha extends Actor
{

    private SimpleTimer time;

    /**
     * Constructor de flecha.
     */
    public Flecha()
    {
        time=new SimpleTimer();
    }

    /**
     * Act de Flecha que inicializa variables de instancia y revisa condiciones
     * de colision.
     */
    public void act() 
    {

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