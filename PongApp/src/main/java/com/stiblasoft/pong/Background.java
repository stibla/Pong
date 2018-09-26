package com.stiblasoft.pong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Background  {
	FloatBuffer vertices;
	
	public Background() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());            
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] {    0.0f,   								0.0f,
                                       1f/Game.PROPORTION_OF_CENTER_LINES,  0.0f,
                                       1f/Game.PROPORTION_OF_CENTER_LINES,  1f/(Game.NO_OF_CENTER_LINES),
                                       0.0f,   								1f/(Game.NO_OF_CENTER_LINES)});
        vertices.flip();         
        //android.util.Log.d("PongloopRunTime","Background");
	}
	
	public void draw(GL10 gl) {		
        gl.glColor4f(1, 1, 1, 1);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
                
        for(int i=1;i <= Game.NO_OF_CENTER_LINES;i++) {
        	gl.glLoadIdentity();	        
	        gl.glTranslatef(0.0f-1f/Game.PROPORTION_OF_CENTER_LINES/2, 1f/Game.NO_OF_CENTER_LINES*i*2 - 1.0f - 1f/Game.NO_OF_CENTER_LINES*2, 0.0f); 
	        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        }        
	}
}
