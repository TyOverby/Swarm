package com.prealpha.game.entities;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.prealpha.game.GameObject;
import com.prealpha.util.Uti;

public class BgStar extends GameObject 
{
	Random r;
	
	public BgStar(Rectangle gs, Random r) throws SlickException {
		super("assets/bg_star.png");
		
		this.r = r;
		
		this.angle = r.nextInt(180);
		
		
		this.setPos(gs);
		this.setScale();
		this.setColor();
	}
	
	private void setPos(Rectangle gs)
	{
		int xPos = Uti.randRange(r,0, (int) gs.getWidth());
		int yPos = Uti.randRange(r,0, (int) gs.getHeight());
		this.pos.setX(xPos);
		this.pos.setY(yPos);
	}
	
	private void setScale()
	{
		this.scale = (r.nextFloat()+1)/10;
		this.zIndex = this.scale;
	}
	
	private void setColor()
	{
		final float DIFF = 3.5f;
		final float OPAC = 0.3f;
		
		
		
		float[] of = new float[3];
		for(int i=0;i<of.length;i++)
		{
			of[i] = r.nextFloat()/DIFF;
		}
		
		int num = r.nextInt(10);
		if(num<1)
		{
			this.color = new Color(of[0],of[1],(float) (1.0-of[2]),OPAC);			
		}
		else if(num <= 8)
		{
			this.color = new Color((float)(1.0-of[0]),(float)(1.0-of[1]),of[2],OPAC/2);
		}
		else
		{
			this.color = new Color((float)(1.0-of[0]),(float)(1.0-of[1]),(float)(1.0-of[2]),OPAC);
		}
	}
	
}
