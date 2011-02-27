package com.prealpha.util;

public class Point 
{
	private float x; 
	private float y;
	
	
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	public Point(float x,float y)
	{
		this.x = x;
		this.y = y;
	}

	public float getX() 
	{
		return x;
	}
	public float getY() 
	{
		return y;
	}

	public void setX(float x) 
	{
		this.x = x;
	}
	public void setY(float y) 
	{
		this.y = y;
	}
	public void setX(double x) 
	{
		this.x = (float)x;
	}
	public void setY(double y) 
	{
		this.y = (float)y;
	}
}
