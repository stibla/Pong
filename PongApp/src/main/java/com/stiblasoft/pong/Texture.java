package com.stiblasoft.pong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Texture {
	FloatBuffer vertices;
	FloatBuffer mTextureBuffer;
	int textureId;
	public int width;
    public int height;
    
	public Texture(float x, float y) {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * 2 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());            
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] {    0.0f, 	y,
        							   0.0f, 	0.0f,
        							   x, 		y,
        							   x, 		0.0f,
                                       });
        vertices.flip();             
        
        ByteBuffer tbb = ByteBuffer.allocateDirect(4 * 2 * 4);
        tbb.order(ByteOrder.nativeOrder());
        mTextureBuffer = tbb.asFloatBuffer();
        mTextureBuffer.put(new float[] {		        		            	            	
        		0.0f, 0.0f,
            	0.0f, 1.0f,
        		1.0f, 0.0f,
            	1.0f, 1.0f,	            	
            });
        mTextureBuffer.position(0);     	        	
	}
	
	public void draw(GL10 gl, float x, float y) {		
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);                
        gl.glLoadIdentity();	        
	    gl.glTranslatef(x, y, 0.0f); 	    
	    
	    gl.glEnable(GL10.GL_BLEND);	
	    gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	    gl.glEnable(GL10.GL_TEXTURE_2D); 				    	    	
	    
	    gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
	    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST); 
	    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR); 
    	gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);	
    	gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);	
    	
    	gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);			        	
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D); 	                    
	}
	
	public void createTexture(GL10 gl, Context context, int resource) 
    {
		int[] textureIds = new int[1];
        gl.glGenTextures(1, textureIds, 0);
        textureId = textureIds[0];
		Bitmap tempImage = BitmapFactory.decodeResource(context.getResources(), resource); 
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
    	GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, tempImage, 0);    
               
        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
    	width = tempImage.getWidth();
        height = tempImage.getHeight();
    	tempImage.recycle();    
    }
	
	/*public void createTexture(GL10 gl, Context context, String resource) 
    {
		int[] textureIds = new int[1];
        gl.glGenTextures(1, textureIds, 0);
        textureId = textureIds[0];
        
        AssetManager assManager = context.getAssets();
        InputStream in = null;
        try {
            in = assManager.open(resource);
            Bitmap tempImage = BitmapFactory.decodeStream(in);
 			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
	    	GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, tempImage, 0);    
	               
	        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
	    	width = tempImage.getWidth();
	        height = tempImage.getHeight();
	    	tempImage.recycle();    
	    	
	        } catch(IOException e) {
	            throw new RuntimeException("Couldn't load texture '" + resource +"'", e);
	        } finally {
	            if(in != null)
	                try { in.close(); } catch (IOException e) { }
	        }
	    }*/
}