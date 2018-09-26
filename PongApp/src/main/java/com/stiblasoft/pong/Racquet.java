package com.stiblasoft.pong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Racquet {
	FloatBuffer vertices;
	
	public Racquet() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());            
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] {    0.0f,   				  	0.0f,
                                       1f/Game.RACQUET_HEIGHT,  0.0f,
                                       1f/Game.RACQUET_HEIGHT,  1f/(Game.RACQUET_WIDTH),
                                       0.0f,   					1f/(Game.RACQUET_WIDTH)});
        vertices.flip();    
        //android.util.Log.d("PongloopRunTime","Racquet");
	}
	
	public void draw(GL10 gl, float deltaTime, float ballPosY) {		
				
        gl.glColor4f(1, 1, 1, 1);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); 
        
    	gl.glLoadIdentity();
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
        if((Game.racquetPosY > -1f + (1f/Game.RACQUET_WIDTH)/2 & Game.racquetDir == -1 & Game.touchPosY < Game.racquetPosY)			
		|| (Game.racquetPosY <  1f - (1f/Game.RACQUET_WIDTH)/2 & Game.racquetDir ==  1 & Game.touchPosY > Game.racquetPosY))
        	{
        		if(java.lang.Math.abs(Game.racquetPosY - Game.touchPosY) < Game.RACQUET_SPEED * deltaTime)
        			Game.racquetPosY = Game.touchPosY;
        		else
        			Game.racquetPosY += Game.racquetDir * Game.RACQUET_SPEED * deltaTime;
        		
        	}
        gl.glTranslatef(1.0f - 1f/Game.RACQUET_HEIGHT - 1f/Game.PLAYING_AREA, Game.racquetPosY-(1f/Game.RACQUET_WIDTH)/2, 0.0f); 
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);       
        
        gl.glLoadIdentity();
        if (java.lang.Math.abs(Game.racquetOppPosY - ballPosY) > Game.RACQUET_SPEED * deltaTime)
        	{
        		Game.racquetOppPosY += (Game.racquetOppPosY - ballPosY) > 0 ? -1f * Game.RACQUET_SPEED * deltaTime : Game.RACQUET_SPEED * deltaTime;
        	} else {
                Game.racquetOppPosY -= (Game.racquetOppPosY - ballPosY);
        	}
        
        if(Game.racquetOppPosY < -1f + (1f/Game.RACQUET_WIDTH)/2) Game.racquetOppPosY = -1f + (1f/Game.RACQUET_WIDTH)/2;
        if(Game.racquetOppPosY >  1f - (1f/Game.RACQUET_WIDTH)/2) Game.racquetOppPosY =  1f - (1f/Game.RACQUET_WIDTH)/2;
        
        gl.glTranslatef(- 1.0f + 1f/Game.PLAYING_AREA, Game.racquetOppPosY-(1f/Game.RACQUET_WIDTH)/2, 0.0f); 
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);       
	}
}
