import greenfoot.*;

/**
 * Write a description of class Arania here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arania extends Enemigo
{
    private int[] tamX = new int[3];
    private int[] tamY = new int[3];
    private int[] attkX = new int[3];
    private int[] attkY = new int[3];
    private int[] killX = new int[4];
    private int[] killY = new int[4];
    
    private int vida=20;
    private ElementWorld w;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    /**
     * Act - do whatever the Arania wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Arania()
    {
        super("Enemigo/AraniaCaminar0.png","Enemigo/AraniaCaminar","Enemigo/AraniaAtacar","Enemigo/AraniaMorir");
        inicializaTam();

    }
    public void act() 
    {
       int x=getX();
       int yW=w.coordenadasWarrior();
       if(vida>0)
        {
        if(isTouching(Warrior.class) && yW>500 && yW<550)
        {
          spriteAtacar(attkX,attkY,2);
          w.disminuyeVida(4);
        }
        else
         {
          spriteCaminar(tamX,tamY,2);
          checkLimit(525);
         }        
        
       }
       else
       {

        vida=-1;
        w.checkEnemigos();
        w.removeObject(this);              
      }
    }
    
    public void disminuyeVida()
    {
      vida--;
     
    }
    
    public void inicializaTam()
    {
        tamX[0]=74; 
        tamX[1]=64; 
        tamX[2]=62; 


        tamY[0]=48;
        tamY[1]=51;
        tamY[2]=39;
        
        attkX[0]=74; 
        attkX[1]=77;
        attkX[2]=77;

        attkY[0]=51;
        attkY[1]=51;
        attkY[2]=51;

        
        killX[0]=74;
        killX[1]=53;
        killX[2]=79;
        killX[3]=84;
        
        
        killY[0]=48;
        killY[1]=62;
        killY[2]=52;
        killY[3]=53;
        
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
