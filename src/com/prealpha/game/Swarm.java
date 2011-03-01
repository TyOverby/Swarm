package com.prealpha.game;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.prealpha.game.entities.BgStar;
import com.prealpha.game.entities.Ship;
import com.prealpha.util.Uti;

/**
 * @author ty
 * Base class for the game. Contains all game logic.
 */
public class Swarm extends BasicGame{

	private ViewPoint viewPort = null;
	private Rectangle gameSize = new Rectangle(0.0f,0.0f,1000,1000);
	
	Random rand = new Random();
	
	//init all game objects
	private Ship[] ships;
	private BgStar[] bgStars;
	private GameObject plane;
	private GameObject uv;
	
	//set up the input for use in multiple methods
	Input input;
	
	public Swarm()
	{
		super("Swarm");
	}
	
	/**
	 * Runs once in the beginning of the game
	 */
	public void init(GameContainer gc) throws SlickException 
	{	
		//set the Window position to 0,0 with a height and witdth equal to that of the Window
		viewPort = new ViewPoint(0.0f,0.0f,gc.getWidth(),gc.getHeight());
		
		//Make a new array of Stars with a length of the area of the gameSize divided by 7000
		bgStars = new BgStar[(int)(Uti.getArea(gameSize)/7000)];
		//Initialize all of the Background Stars
		for(int i=0;i<bgStars.length;i++)
		{
			//init the star with a predefined Random (for speed) and gameSize (to tell it where to place them)
			bgStars[i] = new BgStar(gameSize,rand);
		}
		
		ships = new Ship[20];
		//initialize all of the Ships
		for(int i=0;i<ships.length;i++)
		{
			ships[i] = new Ship();
			ships[i].setPos(new Vector2f(50,50));
		}
		
		//make the plane and UV objects
		plane = new GameObject("assets/plane.png",new Vector2f(50,300),1f,1f);
		uv = new GameObject("assets/uvTemplate.jpg");
		
        gc.setShowFPS(false);
        
        //set up the mouse event listener
        input = gc.getInput();
		viewPort.setInput(input);
		//added listener for the window scaling and such
		input.addMouseListener(viewPort);
	}
	/**
	 * Runs every update loop
	 */
	public void update(GameContainer gc, int delta) throws SlickException     
	{
		getInput(gc,delta);
	}
	public void getInput(GameContainer gc, int delta)
	{
		//Input for the Plane
        if(input.isKeyDown(Input.KEY_A))
        {
            plane.rotate(-0.2f * delta);
        }
 
        if(input.isKeyDown(Input.KEY_D))
        {
            plane.rotate(0.2f * delta);
        }
 
        if(input.isKeyDown(Input.KEY_W))
        {
            float hip = 0.4f * delta;
 
            float rotation = plane.getRotation();
 
            plane.pos.x =(float) (plane.pos.getX()+ hip * Math.sin(Math.toRadians(rotation)));
            plane.pos.y =(float) (plane.pos.getY()- hip * Math.cos(Math.toRadians(rotation)));
        }
        
        //input for Zooming
        if(input.isKeyDown(Input.KEY_1))
        {
        	viewPort.setZoom(viewPort.getZoom()+0.003f);
        }
        if(input.isKeyDown(Input.KEY_2))
        {
        	viewPort.setZoom(viewPort.getZoom()-0.005f);
        }
        if(input.isKeyDown(Input.KEY_ENTER))
        {
        	String form = "["+viewPort.getWidth()+","+viewPort.getHeight()+"] ("+viewPort.getX()+","+viewPort.getY()+") ;" +viewPort.getZoom();
        	System.out.println(form);
        }
        
        //input for scrolling
        if(input.isKeyDown(Input.KEY_UP))
        {
        	float pos = viewPort.getY()-1*delta; 
        	if(pos>=0)
        	{
        		viewPort.setY(pos);
        	}
        }
        if(input.isKeyDown(Input.KEY_DOWN))
        {
        	float pos = viewPort.getY()+1*delta;
        	if(pos+viewPort.getHeight()<=gameSize.getHeight())
        	{
        		viewPort.setY(pos);
        	}
        }
        if(input.isKeyDown(Input.KEY_LEFT))
        {
        	float pos = viewPort.getX()-1*delta;
        	if(pos>=0)
        	{
        		viewPort.setX(pos);
        	}
        }
        if(input.isKeyDown(Input.KEY_RIGHT))
        {
        	float pos = viewPort.getX()+1*delta;
        	if(pos+viewPort.getWidth()<=gameSize.getWidth())
        	{
        		viewPort.setX(pos);
        	}
        }
        
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 
	{		
		//draw all of the stars
		for(BgStar bs:bgStars)
		{
			bs.draw(viewPort);
		}
		
		
		//draw the UV projection
		//uv.draw(winPos);
		
		//draw all of the ships
		for(Ship s: ships)
		{
			s.draw(viewPort);
		}
		
		//draw the plane
		plane.draw(viewPort);
		
		//g.draw(gameSize);
	}

	public static void main(String[] args) throws SlickException
	{		
		AppGameContainer app =new AppGameContainer(new Swarm());

		app.setDisplayMode(600,600, false);
		app.start();
	}
}