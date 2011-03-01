package com.prealpha.game;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;

/**
 * @author ty
 * Viewpoint is what is displayed on the screen at any time. 
 * xPos,yPos,zoom,
 */
public class ViewPoint extends Rectangle implements MouseListener
{
	private final float INIT_WIDTH;
	private final float INIT_HEIGHT;
	
	private float zoom;
	private final int SPEED = 10000;
	
	private Input input;
	
	public ViewPoint(float x, float y, float width, float height)
	{
		super(x, y, width, height);	
		this.INIT_WIDTH = width;
		this.INIT_HEIGHT = height;
		this.zoom = 1;
	}
	public float getZoom() 
	{
		return zoom;
	}
	public void setZoom(float newZoom) 
	{
		if(newZoom<2 && newZoom>0.5f)
		this.zoom = newZoom;
		this.setWidth(INIT_WIDTH/newZoom);
		this.setHeight(INIT_HEIGHT/newZoom);
	}
	public void changeZoom(int delta,int mouseX,int mouseY)
	{
		//delta /= 100;
		//setMag(getMag()+delta);
		
		setZoom(getZoom()+(float)delta/500);
		
		float targetX = mouseX-this.x*getZoom();
		float targetY = mouseY-this.y*getZoom();
		
		this.setX(targetX);
		this.setY(targetY);
	}

	
	@Override
	public void mouseWheelMoved(int change) 
	{
		changeZoom(change,this.input.getMouseX(),this.input.getMouseY());
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
