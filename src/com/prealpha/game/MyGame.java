package com.prealpha.game;

import java.awt.Font;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import com.prealpha.game.entities.BgStar;
import com.prealpha.util.Point;
import com.prealpha.util.Size;
import com.prealpha.util.Uti;

public class MyGame extends BasicGame{

	private Rectangle winPos = null;
	private Rectangle gameSize = new Rectangle(0.0f,0.0f,1000,1000);
	
	Random rand = new Random();
	
	TrueTypeFont trueTypeFont = null;	
	
	private BgStar[] bgStars;
	private GameObject plane;
	
	public MyGame()
	{
		super("Swarm");
	}

	public void init(GameContainer gc) throws SlickException 
	{	
		winPos = new Rectangle(0.0f,0.0f,gc.getWidth(),gc.getHeight());
		
		bgStars = new BgStar[(int)(Uti.getArea(gameSize)/7000)];
		for(int i=0;i<bgStars.length;i++)
		{
			bgStars[i] = new BgStar(gameSize,rand);
		}
		
		
		plane = new GameObject("assets/plane.png",1f);
		
		Font font = new Font("Verdana", Font.BOLD, 16);
        trueTypeFont = new TrueTypeFont(font, true);
        
        gc.setShowFPS(false);
        
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
		
		plane.draw(winPos);
		
		trueTypeFont.drawString(0, 0, winPos.getX()+","+winPos.getY(),Color.red);
		
	}

	public static void main(String[] args) throws SlickException
	{		
		AppGameContainer app =new AppGameContainer(new MyGame());

		app.setDisplayMode(600,600, false);
		app.start();
	}
}