package com.prealpha.util;

public class Utilities 
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
}
