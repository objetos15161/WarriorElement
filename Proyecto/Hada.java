import greenfoot.*;

/**
 * Write a description of class Hada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Hada extends Enemigo
{
    private int[] tamX = new int[8];
    private int[] tamY = new int[8];
    private int[] attkX = new int[9];
    private int[] attkY = new int[9];
    private int[] killX = new int[7];
    private int[] killY = new int[7];
    
    private int vida=10;
    private ElementWorld w;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    /**
     * Act - do whatever the Hada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Hada()
    {
        super("Enemigo/HadaCaminar1.png","Enemigo/HadaCaminar","Enemigo/HadaAtacar","Enemigo/HadaMorir");
        
        inicializaTam();

    }
    
    public void act() 
    {
        int x=getX();
       if(vida>0)
        {
        if(isTouching(Warrior.class))
        {
          spriteAtacar(attkX,attkY,8);
          w.disminuyeVida(1);
        }
        else
         {
          spriteCaminar(tamX,tamY,7);
          checkLimit();
         }        
        
       }
       else
       {

        vida=-1;
        w.checkEnemigos();
        w.removeObject(this);              
      }
    }
    
    /*public void checkLimit()
    {
     int x=getX();
     if(x<=50)
     {
         setLocation(750,450);
     }
    }*/
    
   
    
     public void disminuyeVida()
    {
      vida--;
     
    }
    
    
    public void inicializaTam()
    {
        tamX[0]=57; 
        tamX[1]=58; 
        tamX[2]=59; 
        tamX[3]=59; 
        tamX[4]=125;
        tamX[5]=104;
        tamX[6]=95; 
        tamX[7]=68; 

        tamY[0]=95;
        tamY[1]=94;
        tamY[2]=75;
        tamY[3]=65;
        tamY[4]=80;
        tamY[5]=92;
        tamY[6]=84;
        tamY[7]=94;
        
        attkX[0]=57; 
        attkX[1]=60;
        attkX[2]=63;
        attkX[3]=65;
        attkX[4]=83;
        attkX[5]=95;
        attkX[6]=108;
        attkX[7]=110;
        attkX[8]=83;

        attkY[0]=94;
        attkY[1]=79;
        attkY[2]=74;
        attkY[3]=75;
        attkY[4]=77;
        attkY[5]=88;
        attkY[6]=114;
        attkY[7]=112;
        attkY[8]=77;
        
        killX[0]=57;
        killX[1]=61;
        killX[2]=58;
        killX[3]=59;
        killX[4]=63;
        killX[5]=73;
        killX[6]=78;
        
        killY[0]=94;
        killY[1]=83;
        killY[2]=94;
        killY[3]=76;
        killY[4]=64;
        killY[5]=50;
        killY[6]=29;
        
        
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
