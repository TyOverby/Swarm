package com.prealpha.util;

import java.util.Random;

import org.newdawn.slick.geom.Rectangle;

/**
 * @author ty
 * I don't even know...  Don't talk to me about this class...
 */
public class Uti 
{
	public static float clamp(float under, float var, float above)
	{
		if(var < under)
		{
			return under;
		}
		else if (var > above)
		{
			return above;
		}
		else
		{
			return var;
		}
	}
	
	public static float dontGoOver(float over, float var)
	{
		if(var>over)
		{
			return over;
		}
		else
		{
			return var;
		}
	}
	public static float dontGoUnder(float under, float var)
	{
		if(var<under)
		{
			return under;
		}
		else
		{
			return var;
		}
	}
	
	public static int randRange(Random r,int above, int below)
	{
		return r.nextInt(below-above+1)+above;
	}
	
	/**
	 * I don't even think that this method works... :P
	 * @param r
	 * @param above
	 * @param below
	 * @return
	 */
	public static float randRange(Random r,float above, float below)
	{
		float rFloat = r.nextFloat() * above + below;
	 	return rFloat;
		
	}
	
	public static float getArea(Rectangle r)
	{
		return r.getWidth()*r.getHeight();
	}
}
