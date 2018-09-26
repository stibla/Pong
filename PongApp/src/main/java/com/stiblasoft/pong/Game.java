package com.stiblasoft.pong; 

import android.app.Activity; 
import android.content.Context;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Bundle; 
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent; 
import android.view.Window;
import android.view.WindowManager;

public class Game extends Activity { 
	public static final int NO_OF_CENTER_LINES = 21;
	public static final int PROPORTION_OF_CENTER_LINES = 200;
	public static final int RACQUET_WIDTH = 4;
	public static final int RACQUET_HEIGHT = 40;
	public static final float RACQUET_SPEED = 1f;
	public static final int RACQUET_MOVE_SPEED_DIR_CHANGE = 3;
	public static final int PLAYING_AREA = 5;
	public static final float BALL_SPEED = 1f;
	public static final int BALL_SIZE = 20;	
	public static final int NUMBER_SIZE = 20;
	public static final float WIN_TEXT_SIZE = 3f;
	public static final float MENU_TEXT_SIZE = 3f;	
	public static final float MENU_BUTTON_SIZE = 8f;
	public static final int INITIALIZED_DELAY = 1;
	public static final int MAX_SCORE = 21;
	
	public static Display display;
	public static float racquetDir; 
	public static float racquetPosY; 
	public static float racquetOppPosY; 
	public static float touchPosY;
	public static float touchPosX;
	public static int score;
	public static int scoreOpos;
	public static long startInitializingTime; 

	public static float displayRatio = 1;
	GLSurfaceView view;
	
	public static GameState state;
	
	public enum GameState {
		Menu,
        Initialized,
        Running,		
        Finished,
        Paused,
        Idle
    }

    @Override 
    public void onCreate(Bundle savedInstanceState) { 
    	//android.util.Log.d("PongloopRunTime","Game.onCreate");
    	display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
	    Point outSize = new Point();
	    display.getSize(outSize);
	    displayRatio = (float)outSize.x / outSize.y;
	    state = GameState.Menu;
    	super.onCreate(savedInstanceState);       
        view = new GameView(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(view);                
    } 

   @Override 
    protected void onResume() { 
	  // android.util.Log.d("PongloopRunTime","Game.onResume");
        super.onResume(); 
        view.onResume();        
    } 

    @Override 
    protected void onPause() { 
    	//android.util.Log.d("PongloopRunTime","Game.onPause");
        super.onPause(); 
        view.onPause();        
    }
    
    @Override 
    public boolean onTouchEvent(MotionEvent event) {
    	Point outSize = new Point();
		Game.display.getSize(outSize);
		touchPosY = ((outSize.y) - event.getY() - outSize.y / 2) / (outSize.y / 2); 
		touchPosX = ((outSize.x) - event.getX() - outSize.x / 2) / (outSize.x / 2); 
		switch(Game.state) {
			case Menu:			
				switch(event.getAction()) {
					case MotionEvent.ACTION_DOWN:	
						if(touchPosX > 0 && touchPosY < 0) {
							Game.state = GameState.Initialized;
							Game.startInitializingTime = System.nanoTime();						
						}
						if(touchPosX < 0 && touchPosY < 0) {
							android.os.Process.killProcess(android.os.Process.myPid());
		                    System.exit(1);					
						}
						break;				          
					}    	
				break;
				
			case Finished:
				switch(event.getAction()) {
					case MotionEvent.ACTION_DOWN:	
					    Game.state = GameState.Initialized;
						Game.startInitializingTime = System.nanoTime();									
						break;				          
					}    	
				break;
				
			case Running:
				switch(event.getAction()) {
					case MotionEvent.ACTION_DOWN:
					case MotionEvent.ACTION_MOVE:
						if(touchPosY > Game.racquetPosY) {   
							Game.racquetDir = 1;
						} else if(touchPosY < Game.racquetPosY) {
							Game.racquetDir = -1;
						} else {
							Game.racquetDir = 0;
						}
						break;				          
			        case MotionEvent.ACTION_CANCEL:
			        case MotionEvent.ACTION_UP:
						Game.racquetDir = 0;
						break;
					}    	
			default:
				break;			
		}				
        return false; 
    }     
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(Game.state != GameState.Menu) {
        	Game.state = GameState.Menu;
        	return true;
        }               
        return super.onKeyDown(keyCode, event);
    }

}
