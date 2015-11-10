import greenfoot.*;

/**
 * Write a description of class Warrior here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warrior extends Actor
{
    private int posY=0,posY2=0,tamX=54/*de cada sprite*/,tamY=99;
    private int NUMSPR=9,cont=0,speed=8;
    private int vista=0;
    private GreenfootImage img;
    private GreenfootImage spr;
    private String archivo = "Armadura/ArmorEarthRight.png";

    /**
     * Act - do whatever the Warrior wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     */
    public Warrior()
    {
         img = new GreenfootImage(archivo);
         spr = new GreenfootImage(tamX,tamY);
        spr.drawImage(img,0,0);
        setImage(spr);
    }
    public void spriteNormal()
    {
         img = new GreenfootImage(archivo);
        GreenfootImage spr = new GreenfootImage(tamX,tamY);
        //si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
        revisaVista();
        if(cont>=speed)//si contador supera speed se cambia la imagen de la animacion
        {
            
            if(posY > -(tamY*(NUMSPR-1)))
            posY -= tamY;
            else
            posY = 0;
            spr.drawImage(img,0,posY);
            setImage(spr);
            cont=0;
        }
        cont++;
    }
    public void act() 
    {
        int y=getY();
        int x=getX();
        if(y<360)
        {
           setLocation(x,360); 
        }
        if(y>510)
        {
            setLocation(x,510);
        }
        
        move();

    }    
    
    public void move()
    {
        int positionX,positionY;
        positionX=getX();
        positionY=getY(); 
        if(Greenfoot.isKeyDown("Right"))
        {
            vista=0;
            spriteNormal();
            setLocation(positionX+1,positionY);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            vista=1;
            spriteNormal();
            setLocation(positionX-1,positionY);
            
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            vista=3;
            spriteNormal();
            setLocation(positionX,positionY-1);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            vista=2;
            spriteNormal();            
            setLocation(positionX,positionY+1);
        }
    }
    public void revisaVista()
    {
        if(vista==1)
        {
            archivo = "Armadura/" + "NoArmorLeft"+".png"; 

        }
        if(vista==0)
        {
            archivo = "Armadura/NoArmorRight.png";

        }            
        if(vista==2)
        {
            archivo = "Armadura/NoArmorFront.png";            

        }
        if(vista==3)
        {
            archivo = "Armadura/NoArmorBack.png";            
        }
    }
}
