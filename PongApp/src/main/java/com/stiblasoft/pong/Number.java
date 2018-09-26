package com.stiblasoft.pong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Number {

	FloatBuffer vertices;
	int[][] verticesPos = { {0,   0, 24,},
							{1,  24,  6,}, 
							{2,  30, 30,},
							{3,  60, 30,},
							{4,  90, 18,},
							{5, 108, 30,},
							{6, 138, 36,},
							{7, 174, 12,},
							{8, 186, 42,},
							{9, 228, 36,},};
			
	public Number() {
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(300 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());            
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] { 0.0f,   				   0.0f,  //0
        							1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                                                       
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                                                       
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                               
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                                                       
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //1
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //2
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //3
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //4
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,                                    
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //5
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //6
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //7
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //8
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio, //9
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*0*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*1*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*2*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*0,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*5*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*1,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*5*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio, 
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*3*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*2,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    1f/Game.NUMBER_SIZE*3,  1f/Game.NUMBER_SIZE*4*Game.displayRatio,
                                    });
        vertices.flip();  
        //android.util.Log.d("PongloopRunTime","Number");
	}

	public void draw(GL10 gl, int num1, int num2) {		
        gl.glColor4f(0.9f, 0.9f, 0.9f, 1);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);                                       
    	
        gl.glLoadIdentity();
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
        
        if (num1 < 10 && num1 >=0) {        
        	gl.glTranslatef(0.0f - 1f/Game.NUMBER_SIZE * 4, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
        	gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num1][1], verticesPos[num1][2]);
        } else if (num1 < 100 && num1 >=0) {
        	gl.glTranslatef(0.0f - 1f/Game.NUMBER_SIZE * 4, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
        	gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num1 % 10][1], verticesPos[num1 % 10][2]);
        	gl.glLoadIdentity();
        	gl.glTranslatef(0.0f - 1f/Game.NUMBER_SIZE * 8, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
        	gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num1 / 10][1], verticesPos[num1 / 10][2]);
        }
        
        gl.glLoadIdentity();
                
        if (num2 < 10 && num2 >=0) {   
	        gl.glTranslatef(0.0f + 1f/Game.NUMBER_SIZE, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
	        gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num2][1], verticesPos[num2][2]);
        } else if (num2 < 100 && num2 >=0) {
        	gl.glTranslatef(0.0f + 1f/Game.NUMBER_SIZE, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
        	gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num2 / 10][1], verticesPos[num2 / 10][2]);
        	gl.glLoadIdentity();
        	gl.glTranslatef(0.0f + 1f/Game.NUMBER_SIZE * 5, 1.0f - 1f/Game.NUMBER_SIZE*Game.displayRatio * 6 , 0.0f); 
        	gl.glDrawArrays(GL10.GL_TRIANGLES, verticesPos[num2 % 10][1], verticesPos[num2 % 10][2]);
        }
	}
}
