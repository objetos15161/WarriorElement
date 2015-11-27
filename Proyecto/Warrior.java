import greenfoot.*;

/**
 * Write a description of class Warrior here.
 * 
 * @author Negrete Montalvo Raul Omar, Hervert Morales Leonardo Iván  
 * @version 10-Nov-15
 */
public class Warrior extends Actor
{
    private int posY=0; /*Imagen Actual en el sprite sheet cuando camina*/
    private int tamX=54,tamY=99; /*Altura y Anchura del personaje*/
    private int posX=0,posX2; /*Imagen Actual en el sprite sheet cuando ataca*/
    private int attkX=75,attkY=82; /*Altura y Anchura del cuadro del personaje*/

    private int numSpr=9,sprAt=8,cont=0,cont2=0,cont3,speed=8,speed2=9;
    private int vista=0;
    private int direccion=0;
    private GreenfootImage img;
    private GreenfootImage sprite;
    private String elemento="NoArmor";
    private String archivo = "Armadura/NoArmorRight.png";
    private ElementWorld w;
    private int nivel;
    private Vida vida; 
    /**
     * Constructor de clase Warrior, Jugador que se mueve en el mun
     * 
     * 
     */
    public Warrior(int level)
    {

        img = new GreenfootImage(archivo);
        sprite = new GreenfootImage(tamX,tamY);
        sprite.drawImage(img,0,0);
        setImage(sprite);
        posX2=attkX*sprAt;
        nivel=level;

        vida= new Vida();
    }

    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    protected void addedToWorld(World world)
    {
        
        w = (ElementWorld) world;
        w.addObject(vida,201,41,false); 

    }

    /**
     * 
     */
    public void spriteNormal()
    {
        img = new GreenfootImage(archivo);
        GreenfootImage sprite = new GreenfootImage(tamX,tamY);
        //si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
        revisaVista(elemento);
        if(cont>=speed)//si contador supera speed se cambia la imagen de la animacion
        {

            if(posY > -(tamY*(numSpr-1)))
                posY -= tamY;
            else
                posY = 0;
            sprite.drawImage(img,0,posY);
            setImage(sprite);
            cont=0;
        }
        cont++;
    }

    /**
     * 
     */
    public void spriteAtaque()
    {
        for(cont3=0;cont3<=300;cont3++)
        {
            img = new GreenfootImage(archivo);
            GreenfootImage sprite = new GreenfootImage(attkX,attkY);
            revisaVista(elemento);
            if(direccion==0)

            {
                if(cont2>=speed2)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
                {
                    if(posX > -(attkX*(sprAt-1)))
                        posX = posX - attkX;
                    else
                        posX = 0;

                    sprite.drawImage(img,posX,0);
                    setImage(sprite);
                    cont2=0;
                }
            }
            else
            if(cont2>=speed2)//si el contador es mayor a la velocidad de animacion se cambia a la imagen siguiente
            {

                if(posX2 >= (attkX*(sprAt-1)))
                    posX2 -= attkX;
                else
                    posX2 = attkX*sprAt;

                sprite.drawImage(img,posX,0);
                setImage(sprite);
                cont2=0;
            }
            cont2++;
        }
    }

    /**
     * 
     */
    public void act() 
    {
        int y=getY();
        int x=getX();
        if(nivel==1)
        {
            if(y<360)
            {
                setLocation(x,360); 
            }
            if(y>510)
            {
                setLocation(x,510);
            }
        }

        if(nivel==2)
        {
            if(y<490)
            {
                setLocation(x,490); 
            }
            if(y>560)
            {
                setLocation(x,560);
            }
        }

        if(nivel==3)
        {
            
            if(isTouching(Suelo.class))
            {
                if(y>280)
                {
                  setLocation(x,475); 
                }
                else
                {
                  setLocation(x,192);
                }
            }
            else
            {
                if(isTouching(PlataformaH.class))
               {
                move(1);
               }
               else
               {
                   if(isTouching(PlataformaVD.class))
                  {
                    setLocation(x,y+1);
                  }
                  else
                  {
                      if(isTouching(PlataformaVU.class))
                      {
                       setLocation(x,y-1);
                      }
                      else
                      {
                          setLocation(x,y+2);
                      }
                                  
                  }                  
                  
               }
                
            }
                
           
               
            }

         move();
         cambiaNivel();
       

        }

        
    /**
     * 
     */
    public void move()
    {
        int positionX,positionY;
        positionX=getX();
        positionY=getY(); 
        if(Greenfoot.isKeyDown("Right"))
        {
            direccion=0;
            vista=0;
            spriteNormal();
            setLocation(positionX+1,positionY);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            direccion=1;
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
        if(Greenfoot.isKeyDown("Space"))
        {
            cont=0;
            vista=4;
            spriteAtaque();
            setLocation(positionX,positionY);
            tryToKill();
            if(isTouching(Thanatos.class) && vista==4 && direccion==0 ) 
            {
              if(elemento == "ArmorEarth")
              {
                w.disminuyeVidaEnemigo(2);
                vista=0;
              }
              
              if(elemento== "ArmorFire")
              {
                w.disminuyeVidaEnemigo(4);
                vista=0;
              }
              
            }
            
            if(isTouching(Titan.class) && vista==4 && direccion==0)  
            {
              if(elemento == "ArmorWater")
              {
                w.disminuyeVidaEnemigo(1);
                vista=0;
              }
              
              if(elemento== "ArmorWind")
              {
                w.disminuyeVidaEnemigo(3);
                vista=0;
              }
            }
            /*else
            if(isTouching() && vista==4 && direccion==0 && elemento="ArmorEarth")
            {
              w.disminuyeVidaEnemigo();
              vista=0;
            }
            else
            if(isTouching() && vista==4 && direccion==0 && elemento="ArmorWint")
            {
              w.disminuyeVidaEnemigo();
              vista=0;
            }
            if(isTouching() && vista==4 && direccion==0 && elemento="ArmorWater")
            {
              w.disminuyeVidaEnemigo();
              vista=0;
            }*/
        }
    }

    /**
     * 
     */
    public void revisaVista(String elemento)
    {
        if(elemento=="NoArmor")
        {
            attkX=75;
            attkY=82;
        }
        if(elemento=="ArmorEarth")
        {
            attkX=68;
            attkY=95;
        }
        if(elemento=="ArmorFire")
        {
            attkX=75;
            attkY=95;
        }
        if(elemento=="ArmorWater")
        {
            attkX=78;
            attkY=113;
        }
        if(elemento=="ArmorWind")
        {
            attkX=65;
            attkY=111;
        }
        if(vista==0)
        {
            archivo = "Armadura/"+elemento+"Right.png";
        }
        if(vista==1)
        {
            archivo = "Armadura/"+elemento+"Left.png"; 
        }
        if(vista==2)
        {
            archivo = "Armadura/"+elemento+"Front.png";            
        }
        if(vista==3)
        {
            archivo = "Armadura/"+elemento+"Back.png";            
        }
        if(direccion==0 && vista==4)
        {

            archivo = "Armadura/"+elemento+"AttackRight.png";

        }
        if(direccion==1 && vista==4)
        {
            archivo = "Armadura/"+elemento+"AttackLeft.png";            
        }
    }

    /**
     * 
     */
    public void armaduraAgua()
    {
        elemento="ArmorWater";
    }

    /**
     * 
     */
    public void armaduraTierra()
    {
        elemento="ArmorEarth";
    }

    /**
     * 
     */
    public void armaduraViento()
    {
        elemento="ArmorWind";
    }

    /**
     * 
     */
    public void armaduraFuego()
    {
        elemento="ArmorFire";
    }

    public void cambiaNivel()
    {
        int x=getX();
        
          if(isTouching(Portal.class)&& vista==3)
          {
             if(nivel==1)
            {                        
              w.nivel2();
              nivel++;             
            }  
            else            
            if(nivel>1)
             {              
              w.nivel3();
              nivel=3;
             }
         }       
        
    }

    public void checkTouch(int tipo)
    {
        if(tipo==0)
        {
         vida.disminuyeVida();
        }
        
        if(tipo==1 && elemento!="ArmorWater" && elemento!="ArmorEarth")
        {
         vida.disminuyeVida();
        }
        
        if(tipo==2 && elemento!="ArmorEarth" && elemento!="ArmorWind")
        {
         vida.disminuyeVida();
        }
        
        if(tipo==3 && elemento!="ArmorWind" && elemento!="ArmorFire")
        {
         vida.disminuyeVida();
        }
        
        if(tipo==4 && elemento!="ArmorFire" && elemento!="ArmorWater")
        {
         vida.disminuyeVida();
        }
    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
        public void tryToKill()
    {
      if(nivel==1)
      {
            
        if(canSee(Hada.class) && elemento=="ArmorEarth")
        {
            ElementWorld mundo = (ElementWorld)getWorld();
            Hada h = mundo.dimeHada();
            h.disminuyeVida();            
        }
        
        if(canSee(Dragon.class) && elemento=="ArmorFire")
        {
            ElementWorld mundo = (ElementWorld)getWorld();
            Dragon d = mundo.dimeDragon();
            d.disminuyeVida();            
        }
        
      }
      
      if(nivel==2)
      {
          if(canSee(Golem.class) && elemento=="ArmorWind")
        {
            ElementWorld mundo = (ElementWorld)getWorld();
            Golem g = mundo.dimeGolem();
            g.disminuyeVida();            
        }
        
        if(canSee(Arania.class) && elemento=="ArmorWater")
        {
            ElementWorld mundo = (ElementWorld)getWorld();
            Arania a = mundo.dimeArania();
            a.disminuyeVida();            
        }
      }
    }

}
