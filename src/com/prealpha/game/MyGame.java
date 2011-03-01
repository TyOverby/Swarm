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

import com.prealpha.game.entities.BgStar;
import com.prealpha.util.Point;
import com.prealpha.util.Uti;

public class MyGame extends BasicGame{

	private Screen winPos = null;
	private Rectangle gameSize = new Rectangle(0.0f,0.0f,2000,2000);
	
	Random rand = new Random();
	
	
	private BgStar[] bgStars;
	private GameObject plane;
	private GameObject uv;
	
	Input input;
	
	public MyGame()
	{
		super("Swarm");
	}

	public void init(GameContainer gc) throws SlickException 
	{	
		winPos = new Screen(0.0f,0.0f,gc.getWidth(),gc.getHeight(),gameSize);
		
		bgStars = new BgStar[(int)(Uti.getArea(gameSize)/7000)];
		for(int i=0;i<bgStars.length;i++)
		{
			bgStars[i] = new BgStar(gameSize,rand);
		}
		
		plane = new GameObject("assets/plane.png",new Point(50,300),1f,1f);
		uv = new GameObject("assets/uvTemplate.jpg",1f);
		
        gc.setShowFPS(false);
        
	}

	public void update(GameContainer gc, int delta) throws SlickException     
	{
		getInput(gc,delta);
	}
	public void getInput(GameContainer gc, int delta)
	{
		input = gc.getInput();
		winPos.setInput(input);
		input.addMouseListener(winPos);
		
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
        
        if(input.isKeyDown(Input.KEY_1))
        {
        	winPos.setMag(winPos.getMag()+0.005f);
        }
        if(input.isKeyDown(Input.KEY_2))
        {
        	winPos.setMag(winPos.getMag()-0.005f);
        }
        
        if(input.isKeyDown(Input.KEY_UP))
        {
        	float pos = winPos.getY()-1*delta; 
        	
        	winPos.setY(pos);
        }
        if(input.isKeyDown(Input.KEY_DOWN))
        {
        	float pos = winPos.getY()+1*delta;
        	
        	winPos.setY(pos);
        }
        if(input.isKeyDown(Input.KEY_LEFT))
        {
        	winPos.setX(winPos.getX()-1*delta);
        }
        if(input.isKeyDown(Input.KEY_RIGHT))
        {
        	winPos.setX(winPos.getX()+1*delta);
        }
        
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 
	{		
		for(BgStar bs:bgStars)
		{
			bs.draw(winPos);
		}
		
		//uv.draw(winPos);
		plane.draw(winPos);
		
		//g.draw(gameSize);
	}

	public static void main(String[] args) throws SlickException
	{		
		AppGameContainer app =new AppGameContainer(new MyGame());

		app.setDisplayMode(600,600, false);
		app.start();
	}
}