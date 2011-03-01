package com.prealpha.game;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;

public class Screen extends Rectangle implements MouseListener
{
	private final float INIT_WIDTH;
	private final float INIT_HEIGHT;
	
	private float mag;
	private final int SPEED = 10000;
	
	private Input input;
	private Rectangle gameRect;
	
	public Screen(float x, float y, float width, float height,Rectangle gameRect)
	{
		super(x, y, width, height);	
		this.INIT_WIDTH = width;
		this.INIT_HEIGHT = height;
		this.mag = 1;
		this.gameRect = gameRect;
	}
	public float getMag() 
	{
		return mag;
	}
	public void setMag(float mag) 
	{
		this.mag = mag;
		this.setWidth(INIT_WIDTH/mag);
		this.setHeight(INIT_HEIGHT/mag);
	}
	public void changeMag(int delta,int mouseX,int mouseY)
	{
		//delta /= 100;
		//setMag(getMag()+delta);
		
		setMag(getMag()+(float)delta/500);
		
		float targetX = mouseX-this.x*getMag();
		float targetY = mouseY-this.y*getMag();
		
		this.setX(targetX);
		this.setY(targetY);
	}

	
	@Override
	public void mouseWheelMoved(int change) 
	{
		changeMag(change,this.input.getMouseX(),this.input.getMouseY());
	}
	
	@Override
	public void setInput(Input input) {
		this.input = input;
		
	}
	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}
}
