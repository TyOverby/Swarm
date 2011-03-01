package com.prealpha.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author ty
 * Any item drawn to the screen is a GameObject.
 * It extends the Image class to make for easy drawing.
 */
public class GameObject extends Image
{	
	
	public Vector2f pos;
	public float scale;
	public float zIndex;
	
	public Color color = Color.white;
	
	/**
	 * 
	 * @param filePath The local path to the texture
	 * @throws SlickException
	 */
	public GameObject(String filePath) throws SlickException
	{
		super(filePath);
		this.pos = new Vector2f();
		this.scale = 1f;
		this.zIndex = 1f;
	}
	/**
	 * 
	 * @param filePath The local path to the texture
	 * @param scale Size modification from (0,1] decreasing the size and from [1,infinity) increasing 
	 * @param zIndex The distance the object moves when the screen moves 1 pixel.
	 * @throws SlickException
	 */
	public GameObject(String filePath,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = new Vector2f();
		this.scale = scale;
		this.zIndex = zIndex;
		
		this.setCenterOfRotation(this.getWidth()/2.0f*scale, this.getHeight()/2.0f*scale);
	}
	/**
	 * @param filePath The local path to the texture
	 * @param pos The position that the object is created at
	 * @param scale Size modification from (0,1] decreasing the size and from [1,infinity) increasing 
	 * @param zIndex zIndex The distance the object moves when the screen moves 1 pixel.
	 * @throws SlickException
	 */
	public GameObject(String filePath,Vector2f pos,float scale,float zIndex) throws SlickException
	{
		super(filePath);
		this.pos = pos;
		this.scale = scale;
		this.zIndex = zIndex;
		
		this.setCenterOfRotation(this.getWidth()/2.0f*scale, this.getHeight()/2.0f*scale);
	}

	/**
	 * Draws the object
	 */
	public void draw()
	{
		//draws object at x,y with scale
		super.draw(this.pos.getX(),this.pos.getY(),this.scale);
	}
	
	/**
	 * This method checks if the object is inside the Rectangle box, with the Screen offset
	 * @param box The Rectangle that it check if it is inside
	 * @param offset The Screen Offset that it gets magnification from
	 * @return
	 */
	public boolean isIn(Rectangle box,ViewPoint offset)
	{		
		
		
		float magScale = (float)1/offset.getZoom();
		
		
		this.setCenterOfRotation(this.getWidth()/2.0f*this.scale/magScale, this.getHeight()/2.0f*this.scale/magScale);
		
		float offX = box.getX()*magScale*zIndex;
		float offY = box.getY()*magScale*zIndex;
		
		float objWidth = this.getWidth();//*scale/magScale;
		float objHeight = this.getHeight();//*scale/magScale;
		
		//System.out.println(obj);
		
		boolean isInLeft = this.pos.getX()+objWidth>=offX;
		boolean isInRight = this.pos.getX()<= offX+box.getWidth();
		
		boolean isInTop = this.pos.getY()+objHeight>=offY;
		boolean isInBottom = this.pos.getY() <= offY+box.getHeight(); 
		
		return (isInLeft && isInRight && isInTop && isInBottom);
	}
	
	/**
	 * Smart Draw.  Draws the object only if it is in the viewport
	 * @param offset
	 */
	public void draw(ViewPoint offset)
	{	
		float magScale = 1/offset.getZoom();
		
		float offX = offset.getX()*zIndex;
		float offY = offset.getY()*zIndex;
		
		
		
		if(isIn(offset,offset))
		{
			super.draw(this.pos.getX()/magScale-offX,this.pos.getY()/magScale-offY,this.scale/magScale,this.color);
		}
		else
		{
			//System.out.println(offset.getMag());
			//don't render it.
		}
	}
}
