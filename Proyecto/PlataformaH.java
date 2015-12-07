import greenfoot.*;

/**
 * Clase que representa una plataforma con movimiento horizontal.
 * 
 * @author Omar Negrete.
 * @author Leonardo Hervert.
 * @version 06/Dic/2015.
 */
public class PlataformaH extends Obstaculo
{
    private int dir=1;
    /**
     * Act genera movimiento a la izquierda o derecha segun la direccion.
     */
    public void act() 
    {
        if(dir==1)
        {
            move(1);
        }
        else
        {
            move(-1);
        }
        checkDir();
    } 
    
    
   /**
    * Detecta cuando se toca un objeto de tipo Suelo y modifica la direccion.
    */
    public void checkDir()
    {
        if(isTouching(Suelo.class))
        {
            dir=dir*-1;
        }
    }
}
