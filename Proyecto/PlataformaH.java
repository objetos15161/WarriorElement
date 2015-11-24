import greenfoot.*;

/**
 * Write a description of class PlataformaH here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlataformaH extends Obstaculo
{
    private int dir=1;
    /**
     * Act - do whatever the PlataformaH wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
    
    public void checkDir()
    {
        if(isTouching(Suelo.class))
        {
            dir=dir*-1;
        }
    }
}
