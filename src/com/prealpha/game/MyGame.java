package com.prealpha.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.prealpha.util.Point;
import com.prealpha.util.Size;
import com.prealpha.util.Utilities;

public class MyGame extends BasicGame{

	private Rectangle winPos = null;
	private Rectangle gameSize = new Rectangle(0.0f,0.0f,900,700);
	
	private GameObject land = null;
	private GameObject plane;
	
	public MyGame()
	{
		super("Slick2DPath2Glory - SimpleGame");
	}

	public void init(GameContainer gc) throws SlickException 
	{
		//gc.setMinimumLogicUpdateInterval(50);
		
		winPos = new Rectangle(0.0f,0.0f,gc.getWidth(),gc.getHeight());
		
		land = new GameObject("assets/land.jpeg");
		plane = new GameObject("assets/plane.png");
	}

	public void update(GameContainer gc, int delta) throws SlickException     
	{
		getInput(gc,delta);
        
	}
	public void getInput(GameContainer gc, int delta)
	{
		Input input = gc.getInput();
		 
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
 
            plane.pos.setX(plane.pos.getX()+ hip * Math.sin(Math.toRadians(rotation)));
            plane.pos.setY(plane.pos.getY()- hip * Math.cos(Math.toRadians(rotation)));
        }
        
        if(input.isKeyDown(Input.KEY_UP))
        {
        	float pos = winPos.getY()+1*delta;
        	
        	float newPos = Utilities.dontGoOver(0, pos);
        	
        	winPos.setY(newPos);
        }
        if(input.isKeyDown(Input.KEY_DOWN))
        {
        	float pos = winPos.getY()-1*delta;
        	float newPos = Utilities.dontGoUnder(-300, pos);
        	System.out.println(pos);
        	winPos.setY(newPos);
        }
        if(input.isKeyDown(Input.KEY_LEFT))
        {
        	winPos.setX(winPos.getX()+1*delta);
        }
        if(input.isKeyDown(Input.KEY_RIGHT))
        {
        	winPos.setX(winPos.getX()-1*delta);
        }
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		Point offset = new Point(winPos.getX(),winPos.getY());
		
		land.draw(offset);
		plane.draw(offset);
	}

	public static void main(String[] args) throws SlickException
	{		
		AppGameContainer app =new AppGameContainer(new MyGame());

		app.setDisplayMode(800,600, false);
		app.start();
	}
}