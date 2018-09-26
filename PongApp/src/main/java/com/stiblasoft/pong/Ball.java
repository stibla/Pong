package com.stiblasoft.pong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import com.stiblasoft.pong.Game.GameState;

public class Ball {
	FloatBuffer vertices;
	public float ballPosY; 
	public float ballPosX;
	public double ballDirection = 0;
	private Random randomPos = new Random(); 
	
	public Ball() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());            
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] {    0.0f,   				0.0f,
                                       1f/Game.BALL_SIZE,  	0.0f,
                                       1f/Game.BALL_SIZE,  	1f/(Game.BALL_SIZE)*Game.displayRatio,
                                       0.0f,   				1f/(Game.BALL_SIZE)*Game.displayRatio});
        vertices.flip();     
        
        //android.util.Log.d("PongloopRunTime","Ball");
	}
	
	public void resetBall(int whoStart) {
		ballPosX = 0;
        ballPosY = 0;
        if(whoStart == 1)
        	ballDirection = java.lang.Math.PI + java.lang.Math.atan(Game.displayRatio) + (java.lang.Math.PI - 2 * java.lang.Math.atan(Game.displayRatio)) * randomPos.nextDouble() ;
        else
        	ballDirection = java.lang.Math.atan(Game.displayRatio) + (java.lang.Math.PI - 2 * java.lang.Math.atan(Game.displayRatio)) * randomPos.nextDouble() ;
	}
	
	public void draw(GL10 gl, float deltaTime) {
		
		ballPosX += java.lang.Math.sin(ballDirection) * Game.BALL_SPEED * deltaTime;
		ballPosY += java.lang.Math.cos(ballDirection) * Game.BALL_SPEED * Game.displayRatio * deltaTime;
		
		if((ballPosY + 1f/(Game.BALL_SIZE)/2*Game.displayRatio) > 1f) {
			ballDirection = java.lang.Math.PI - ballDirection;			
			ballPosY = 1f - 1f/(Game.BALL_SIZE)/2*Game.displayRatio; 
		}
		
		if((ballPosY - 1f/(Game.BALL_SIZE)/2*Game.displayRatio) < -1f) {
			ballDirection = java.lang.Math.PI - ballDirection;	
			ballPosY = 1f/(Game.BALL_SIZE)/2*Game.displayRatio - 1f; 
		}
		
		if((ballPosX + 1f/(Game.BALL_SIZE)/2 + 1f/Game.PLAYING_AREA) > 1f) {			
			ballDirection = 2*java.lang.Math.PI - ballDirection + 1f/Game.RACQUET_MOVE_SPEED_DIR_CHANGE*Game.racquetDir;	
			ballPosX = 1f - 1f/(Game.BALL_SIZE)/2 - 1f/Game.PLAYING_AREA;
			if(java.lang.Math.abs(Game.racquetPosY - ballPosY) > (1f/Game.RACQUET_WIDTH)/2 + 1f/(Game.BALL_SIZE)/2*Game.displayRatio) {
				Game.scoreOpos ++;
				if(Game.scoreOpos >= Game.MAX_SCORE && Game.scoreOpos > Game.score + 1) {
					Game.state = GameState.Finished;
				}
				Game.startInitializingTime = System.nanoTime();
				resetBall(1);
				return;
			}
		}			
		
		if((ballPosX - 1f/(Game.BALL_SIZE)/2 - 1f/Game.PLAYING_AREA) < -1f) {
			ballDirection = 2*java.lang.Math.PI - ballDirection;
			ballPosX = 1f/(Game.BALL_SIZE)/2 - 1f + 1f/Game.PLAYING_AREA;
			if(java.lang.Math.abs(Game.racquetOppPosY - ballPosY) > (1f/Game.RACQUET_WIDTH)/2 + 1f/(Game.BALL_SIZE)/2*Game.displayRatio) {
				Game.score ++;
				if(Game.score >= Game.MAX_SCORE && Game.score > Game.scoreOpos + 1) {
					Game.state = GameState.Finished;
				}
				Game.startInitializingTime = System.nanoTime();
				resetBall(-1);
				return;
			}			
		}
			
		if(ballDirection < 0) { 
			ballDirection += 2*java.lang.Math.PI;
		} 
		
		//android.util.Log.d("PongloopRunTime", "ballPosX=" + String.valueOf(ballPosX) + " ballPosY=" + String.valueOf(ballPosY) + " ballDirection=" + String.valueOf(ballDirection));		
		
        gl.glColor4f(1, 1, 1, 1);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);                       
    	gl.glLoadIdentity();
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
        gl.glTranslatef(ballPosX - 1f/(Game.BALL_SIZE)/2, ballPosY - 1f/(Game.BALL_SIZE)/2*Game.displayRatio, 0.0f);        
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
       
	}
}
