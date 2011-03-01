package com.prealpha.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.prealpha.util.Point;

public class GameObject extends Image
{	
	
	public Point pos;
	public float scale;
	public float zIndex;
	
	public Color color = Color.white;
	
	public GameObject(String filePath) throws SlickException
	{
		super(filePath);
		this.pos = new Point();
		this.scale = 1f;
		this.zIndex = 1f;
	}
	
	public GameObject(String filePath,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = new Point();
		this.scale = 1f;
		this.zIndex = zIndex;
		
		this.setCenterOfRotation(this.getWidth()/2.0f*scale, this.getHeight()/2.0f*scale);
	}
	public GameObject(String filePath,Point p,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = p;
		this.scale = scale;
		this.zIndex = zIndex;
		
		this.setCenterOfRotation(this.getWidth()/2.0f*scale, this.getHeight()/2.0f*scale);
	}
	public GameObject(String filePath,float x, float y,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = new Point(x,y);
		this.scale = scale;
		this.zIndex = zIndex;
		
		this.setCenterOfRotation(this.getWidth()/2.0f*scale, this.getHeight()/2.0f*scale);
	}
	
	public void draw()
	{
		super.draw(this.pos.getX(),this.pos.getY(),this.scale);
	}
	
	private boolean isIn(Screen offset)
	{		
		
		
		float magScale = (float)1/offset.getMag();
		
		
		this.setCenterOfRotation(this.getWidth()/2.0f*this.scale/magScale, this.getHeight()/2.0f*this.scale/magScale);
		
		float offX = offset.getX()*magScale*zIndex;
		float offY = offset.getY()*magScale*zIndex;
		
		float objWidth = this.getWidth();//*scale/magScale;
		float objHeight = this.getHeight();//*scale/magScale;
		
		//System.out.println(obj);
		
		boolean isInLeft = this.pos.getX()+objWidth>=offX;
		boolean isInRight = this.pos.getX()<= offX+offset.getWidth();
		
		boolean isInTop = this.pos.getY()+objHeight>=offY;
		boolean isInBottom = this.pos.getY() <= offY+offset.getHeight(); 
		
		return (isInLeft && isInRight && isInTop && isInBottom);
	}
	
	public void draw(Screen offset)
	{	
		float magScale = 1/offset.getMag();
		
		float offX = offset.getX()*zIndex;
		float offY = offset.getY()*zIndex;
		
		
		
		if(isIn(offset))
		{
			super.draw(this.pos.getX()/magScale-offX,this.pos.getY()/magScale-offY,this.scale/magScale,this.color);
		}
		else
		{
			System.out.println(offset.getMag());
			//don't render it.
		}
	}
}
