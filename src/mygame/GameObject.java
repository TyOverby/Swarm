package mygame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameObject extends Image
{	
	public float scale = 1.0f;
	public double x = 50;
	public double y = 60;
	
	public GameObject(String filePath) throws SlickException
	{
		super(filePath);
	}
}
