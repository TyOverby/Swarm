package com.prealpha.util;

public class Size 
{
	private float width; 
	private float height;
	
	
	public Size()
	{
		this.width = 0;
		this.height = 0;
	}
	public Size(float x,float y)
	{
		this.width = x;
		this.height = y;
	}

	public float getWidth() 
	{
		return width;
	}
	public float getY() 
	{
		return height;
	}

	public void setWidth(float x) 
	{
		this.width = x;
	}
	public void setHeight(float y) 
	{
		this.height = y;
	}
	public void setWidth(double x) 
	{
		this.width = (float)x;
	}
	public void setHeight(double y) 
	{
		this.height = (float)y;
	}
}
