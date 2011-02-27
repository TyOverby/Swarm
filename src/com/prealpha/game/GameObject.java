package com.prealpha.game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.prealpha.util.Point;

public class GameObject extends Image
{	
	
	public Point pos;
	public float scale;
	public float zIndex;
	
	public GameObject(String filePath) throws SlickException
	{
		super(filePath);
		this.pos = new Point();
		this.scale = 1.0f;
		this.zIndex = 1.0f;
		
	}
	public GameObject(String filePath,Point p,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = p;
		this.scale = scale;
		this.zIndex = zIndex;
	}
	public GameObject(String filePath,float x, float y,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = new Point(x,y);
		this.scale = scale;
		this.zIndex = zIndex;
	}
	
	public void draw(Point offset)
	{		
		super.draw(this.pos.getX()+offset.getX(),this.pos.getY()+offset.getY(),this.scale);
	}
}
