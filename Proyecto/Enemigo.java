import greenfoot.*;

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    private Integer entero;
    private String archivo;
    private GreenfootImage img ;/*Cuadro */
    private GreenfootImage sprite;/* */
    private int[] tamX;
    private int[] tamY;
    private int[] attkX;
    private int[] attkY;
    private int[] killX;
    private int[] killY;
    //private int tamX = 0 , tamY = 0 ;/*Altura y anchura del enemigo*/  
    private int posX=0 , posY=0 ;/* Cuadro en el que se encuentra la imagen*/
    private int cont=0 , speed = 9 ;/*Velociudad en la que se muestra hace cambio de sprite*/
    private int numSpr=8;//, numSpr2=9;/*Es en la imagen que se encuentra el sprite sheet*/
    private int cont2=1 ;//, speed2 = 7 ;/*Velocidad en la que se muestra el cambio de sprite para el ataque*/
    private int cont3=0;/*Contador para hacer automatico de un ataque*/
    private int cont4=0;/*Contador de muerte de enemigo*/
    //private int vista ;/* direccion a la que apunta*/
    private String elemento; /* */
    private String ataque;
    private String morir;
    
    private String cadena="";
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemigo(String a,String e,String attk, String m)
    {
        this.archivo=a;
        this.elemento=e;
        this.ataque=attk;
        this.morir=m;
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void setataque(String unataque)
    {
        ataque=unataque;
    }
    public void spriteCaminar(int tamX[],int tamY[],int numImg)
    {
        img = new GreenfootImage(archivo);
       
        GreenfootImage sprite = new GreenfootImage(tamX[cont],tamY[cont]);
        cadena=Integer.toString(cont);
        archivo=elemento+cadena+".png";
        if(cont2>=speed)
        {
            if(cont<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont++;
            }
                else
                cont=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
        move(-1);
            //cont++; 
    }
    public void spriteAtacar(int attkX[],int attkY[],int numImg)
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(attkX[cont3],attkY[cont3]);
        cadena=Integer.toString(cont3);
        archivo=ataque+cadena+".png";
                if(cont2>=speed)
        {
            if(cont3<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont3++;
            }
                else
                cont3=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
            //cont++; 
    }
    public void spriteMorir(int killX[],int killY[],int numImg)
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(killX[cont4],killY[cont4]);
        cadena=Integer.toString(cont4);
        archivo=morir+cadena+".png";
        if(cont2>=speed)
        {
            if(cont4<numImg-1)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {
                cont4++;
            }
                else
                
                cont4=0;
            sprite.drawImage(img,0,0);
            setImage(sprite);
            cont2=0;
            
        }
        cont2++;
            //cont++; 
    }
    
    public void checkLimit( int y)
    {
     int x=getX();
     if(x<=50)
     {
         setLocation(750,y);
     }
    }
    
    public void reiniciaContador()
    {
        cont=0;
    }
}
