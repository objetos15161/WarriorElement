import greenfoot.*;

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Enemigo
{
    private int[] tamX = new int[7];
    private int[] tamY = new int[7];
    private int[] attkX = new int[6];
    private int[] attkY = new int[6];
    private int[] killX = new int[2];
    private int[] killY = new int[2];
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dragon()
    {
        super("Enemigo/DragonCaminar0.png","Enemigo/DragonCaminar","Enemigo/DragonAtacar","Enemigo/DragonMorir");
        inicializaTam();

    }
    public void act() 
    {
        spriteCaminar(tamX,tamY,7);
    } 
        public void inicializaTam()
    {
        tamX[0]=36; 
        tamX[1]=52; 
        tamX[2]=55; 
        tamX[3]=58; 
        tamX[4]=41;
        tamX[5]=55;
        tamX[6]=58; 
         

        tamY[0]=65;
        tamY[1]=70;
        tamY[2]=62;
        tamY[3]=60;
        tamY[4]=79;
        tamY[5]=59;
        tamY[6]=57;
        
        attkX[0]=43; 
        attkX[1]=47;
        attkX[2]=48;
        attkX[3]=49;
        attkX[4]=69;
        attkX[5]=71;

        attkY[0]=68;
        attkY[1]=82;
        attkY[2]=84;
        attkY[3]=86;
        attkY[4]=46;
        attkY[5]=49;
        
        killX[0]=36;
        killX[1]=43;
        
        killY[0]=65;
        killY[1]=48; 
        
    }
}