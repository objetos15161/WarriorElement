import greenfoot.*;
import java.awt.Color;

/**
 * Clase Titan (Jefe 2) que contiene las vidas y las condiciones de movimiento
 * 
 * @author Raul Omar Negrete Montalvo
 * @author Leonardo Ivan Hervert Morales 
 * @version 10-Nov-2015
 */
public class Titan extends Enemigo
{
    private int[] tamX = new int[13];
    private int[] tamY = new int[13];
    private int[] attkX = new int[8];
    private int[] attkY = new int[8];
    private int[] killX = new int[9];
    private int[] killY = new int[9];
    private ElementWorld w;
    private VidaBoss vida;
    private SimpleTimer time = new SimpleTimer();
    private int t=1;
    /**
     * Constructor del jefe de lava, donde se asignan los nombres de tus imagenes
     * y la inicializacion de sus imagenes.
     */
    public Titan()
    {
        super("Enemigo/JefeLavaCaminar0.png","Enemigo/JefeLavaCaminar","Enemigo/JefeLavaAtacar","Enemigo/JefeLavaMorir");
        inicializaTam();        
        vida=new VidaBoss();
    }
    /**
     * Este método iguala la variable mundo a el World de juego.
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
        w = (ElementWorld) world;
        w.estadoBoss();
        w.addObject(vida,606,43,false); 
    }
     /**
     * metodo Act() donde revisa si esta tocando al guerrero y
     * si esta tocando al guerrero disminuye su vida correspondiendo
     * a la armadura que lleva puesta. 
     */
    public void act() 
    {
       Color color=vida.dimeElemento();
       int v=vida.dimeVida();
       int yW=w.coordenadasWarrior();
       int x=getX();
       if(v>=12)
        {
        if(isTouching(Warrior.class)&& yW>500 && yW<550)
        {
          spriteAtacar(attkX,attkY,8);
          if(color == Color.BLACK)
          {
            w.disminuyeVida(4);
          }
          else
          {
            w.disminuyeVida(2);  
          }
        
        }
        else
         {
          spriteCaminar(tamX,tamY,12);
          checkLimit(525);
         }        
        
       }
       else
       {
        setLocation(x+50,525);
        
        if(t==1)
        {
         t=2;
         reiniciaContador();
         time.mark();
        }
         else
        {
            
             if(t==2 && time.millisElapsed()>400)
         {          
          w.removeObject(this);
          w.removeEstado();
          w.abrePortal();
         }
        } 
        
        spriteMorir(killX,killY,8);
                       
      }
    }
    /**
     * Checa los limites en X del enemigo.
     * Depende del mapa donde se encuentre.
     */
    public void checkLimit()
    {
     int x=getX();
     if(x<=50)
     {
         setLocation(750,450);
     }
    }
    /**
     * Disminuye la vida de Arania en 1 cada vez que es golpeada.
     * Depende de que tipo de elemento lo golpe.
     */
    public void disminuyeVida(int tipo)
    {
        vida.disminuyeVida(tipo);
    }
    /**
     * Inicializacion de los tamaños de los arreglos.
     */
       public void inicializaTam()
    {
        tamX[0]=74;         tamY[0]=102;
        tamX[1]=66;         tamY[1]=98;
        tamX[2]=68;         tamY[2]=98;
        tamX[3]=65;         tamY[3]=92;
        tamX[4]=64;         tamY[4]=92;
        tamX[5]=62;         tamY[5]=90;
        tamX[6]=65;         tamY[6]=94;
        tamX[7]=68;         tamY[7]=96;
        tamX[8]=71;         tamY[8]=100;
        tamX[9]=77;         tamY[9]=97;
        tamX[10]=76;        tamY[10]=99;
        tamX[11]=73;        tamY[11]=99;
        tamX[12]=70;        tamY[12]=98;
        
        attkX[0]=74;         attkY[0]=98;
        attkX[1]=66;         attkY[1]=102;
        attkX[2]=65;         attkY[2]=107;
        attkX[3]=64;         attkY[3]=109;
        attkX[4]=61;         attkY[4]=98;
        attkX[5]=61;         attkY[5]=94;
        attkX[6]=61;         attkY[6]=98;
        attkX[7]=61;         attkY[7]=99;        

        killX[0]=76;        killY[0]=109;
        killX[1]=76;        killY[1]=115;
        killX[2]=75;        killY[2]=110;
        killX[3]=75;        killY[3]=101;
        killX[4]=75;        killY[4]=92;
        killX[5]=75;        killY[5]=87;
        killX[6]=74;        killY[6]=77;
        killX[7]=74;        killY[7]=66;
        killX[8]=74;        killY[8]=66;

    }
    
}
