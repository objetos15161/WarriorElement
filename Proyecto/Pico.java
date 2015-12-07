import greenfoot.*;

/**
 * Clase simple que representa un obstaculo que daña bajo cualquier circunstancia a Warrior.
 * 
 *@author Omar Negrete.
 * @author Leonardo Hervert.
 * @version 06/Dic/2015.
 */
public class Pico extends Obstaculo
{
    /**
     * Act revisa en todo momento si esta tocando a Warrior.
     */
    public void act() 
    {
        checkTouch();
    }    
}
