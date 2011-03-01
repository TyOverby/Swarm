package com.prealpha.game.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.prealpha.game.GameObject;
import com.prealpha.util.Uti;

/**
 * @author ty
 * The standard Ship, main unit in the game
 */
public class Ship extends GameObject
{
	/**
	 * Constructs a ship at Vector2f(0,0) with a scale of 0.05f;
	 */
	public Ship() throws SlickException
	{
		super("assets/ship.jpg");
		this.scale = 0.05f;
	}
	
	/**
	 * Sets the position of the Ship to the coordinate pair p
	 */
	public void setPos(Vector2f p)
	{
		this.pos = p;
	}
	
	/**
	 * Tells the Ship to plot a course to point p
	 * @param p
	 */
	public void goTo(Vector2f p)
	{
		
	}
}
