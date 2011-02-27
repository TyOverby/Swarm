package mygame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MyGame extends BasicGame{

	private Image land = null;
	private GameObject plane;
	
	public MyGame()
	{
		super("Slick2DPath2Glory - SimpleGame");
	}

	public void init(GameContainer gc) throws SlickException 
	{
		land = new Image("assets/land.jpeg");
		plane = new GameObject("assets/plane.png");
	}

	public void update(GameContainer gc, int delta) 
	throws SlickException     
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
 
            plane.x+= hip * Math.sin(Math.toRadians(rotation));
            plane.y-= hip * Math.cos(Math.toRadians(rotation));
        }
 
        if(input.isKeyDown(Input.KEY_2))
        {
            plane.scale += (plane.scale >= 5.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*plane.scale, plane.getHeight()/2.0f*plane.scale);
        }
        if(input.isKeyDown(Input.KEY_1))
        {
            plane.scale -= (plane.scale <= 1.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*plane.scale, plane.getHeight()/2.0f*plane.scale);
        }
	}

	public void render(GameContainer gc, Graphics g) 
	throws SlickException 
	{
		land.draw(0, 0);
		plane.draw();
	}

	public static void main(String[] args) 
	throws SlickException
	{
		AppGameContainer app = 
			new AppGameContainer(new MyGame());

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}