import greenfoot.*;

/**
 * Write a description of class Thanatos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thanatos extends Enemigo
{
    private int[] tamX = new int[8];
    private int[] tamY = new int[8];
    private int[] attkX = new int[7];
    private int[] attkY = new int[7];
    private int[] killX = new int[5];
    private int[] killY = new int[5];
    
    private ElementWorld w;
    private VidaBoss vida;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    private int prueba=50;
    /**
     * Act - do whatever the Thanatos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Thanatos()
    {
        super("Enemigo/JefeCaminar0.png","Enemigo/JefeCaminar","Enemigo/JefeAtacar","Enemigo/JefeMorir");
        inicializaTam();
        
        vida=new VidaBoss();

    }
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
        
        w = (ElementWorld) world;
        w.estadoBoss();
        w.addObject(vida,606,43,false); 

    }
    
    public void act() 
    {
       if(prueba>0)
        {
        if(isTouching(Warrior.class))
        {
          spriteAtacar(attkX,attkY,6);
          w.disminuyeVida(2);
        }
        else
         {
          spriteCaminar(tamX,tamY,7);
          checkLimit();
         }        
        
       }
       else
       {
        //w.checkEnemigos();
        spriteMorir(killX,killY,4);
        if(t==1)
        {
         t=2;
         time.mark();
        }
         else
        {
            
             if(t==2 && time.millisElapsed()>2000)
         {
          
          w.removeObject(this);
         }
        }      
                       
      }
    }
    
    public void checkLimit()
    {
     int x=getX();
     if(x<=50)
     {
         setLocation(750,450);
     }
    }
    
    public void disminuyeVida(int tipo)
    {
        vida.disminuyeVida(tipo);
    }
   
       public void inicializaTam()
    {
        tamX[0]=70;         tamY[0]=121;
        tamX[1]=63;         tamY[1]=116;
        tamX[2]=71;         tamY[2]=112;
        tamX[3]=67;         tamY[3]=111;
        tamX[4]=62;         tamY[4]=110;
        tamX[5]=64;         tamY[5]=112;
        tamX[6]=74;         tamY[6]=119;
        tamX[7]=66;         tamY[7]=119;

        attkX[0]=74; 
        attkX[1]=68;
        attkX[2]=66;
        attkX[3]=179;
        attkX[4]=177;
        attkX[5]=169;
        attkX[6]=153;
        

        attkY[0]=127;
        attkY[1]=128;
        attkY[2]=128;
        attkY[3]=144;
        attkY[4]=143;
        attkY[5]=124;
        attkY[6]=124;
        
        killX[0]=112;
        killX[1]=116;
        killX[2]=108;
        killX[3]=119;
        killX[4]=119;
        
        
        killY[0]=123;
        killY[1]=120;
        killY[2]=101;
        killY[3]=89;
        killY[4]=69;
        
        
        
        
    }
}
