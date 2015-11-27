import greenfoot.*;

/**
 * Write a description of class Golem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Golem extends Enemigo
{
    private int[] tamX = new int[12];
    private int[] tamY = new int[12];
    private int[] attkX = new int[5];
    private int[] attkY = new int[5];
    private int[] killX = new int[6];
    private int[] killY = new int[6];
    
    private int vida=20;
    private ElementWorld w;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    /**
     * Act - do whatever the Golem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Golem()
    {
        super("Enemigo/GolemCaminar0.png","Enemigo/GolemCaminar","Enemigo/GolemAtacar","Enemigo/GolemMorir");
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
          //reiniciaContador();
          spriteAtacar(attkX,attkY,4);
          w.disminuyeVida(2);
        }
        else
         {
          spriteCaminar(tamX,tamY,11);
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
    
     /**
     * Inicializacion de los tamaños de los arreglos.
     */
    public void inicializaTam()
    {
        tamX[0]=75; 
        tamX[1]=77; 
        tamX[2]=71; 
        tamX[3]=71; 
        tamX[4]=70;
        tamX[5]=71;
        tamX[6]=75; 
        tamX[7]=80;
        tamX[8]=93;
        tamX[9]=93;
        tamX[10]=84;
        tamX[11]=79;

        tamY[0]=110;
        tamY[1]=104;
        tamY[2]=99;
        tamY[3]=98;
        tamY[4]=98;
        tamY[5]=99;
        tamY[6]=108;
        tamY[7]=100;
        tamY[8]=109;
        tamY[9]=110;
        tamY[10]=110;
        tamY[11]=112;
        
        attkX[0]=74; 
        attkX[1]=78;
        attkX[2]=78;
        attkX[3]=91;
        attkX[4]=94;
        

        attkY[0]=109;
        attkY[1]=113;
        attkY[2]=114;
        attkY[3]=110;
        attkY[4]=108;
        
        killX[0]=87;
        killX[1]=100;
        killX[2]=100;
        killX[3]=100;
        killX[4]=114;
        killX[5]=120;
        
        
        killY[0]=114;
        killY[1]=108;
        killY[2]=96;
        killY[3]=74;
        killY[4]=74;
        killY[5]=74;
        
        
        
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
