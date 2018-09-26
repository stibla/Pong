package com.stiblasoft.pong;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import com.stiblasoft.pong.Game.GameState;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView.Renderer; 

public class GameRenderer implements Renderer  {
	private Background background;
	private Racquet racquet;
	private Ball ball; 
	private Number number;
    private long startTime; 
    private Texture win;
    private Texture menu;
    private Texture menuBtnStart;
    private Texture menuBtnExit;
    private Context context;
		
	public GameRenderer(Context context) {		
		
		background = new Background(); 
		racquet = new Racquet();
		ball = new Ball();
		number = new Number();
		
		win = new Texture(1.0f/Game.WIN_TEXT_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.win_transparent).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.win_transparent).getHeight(),
					1.0f/Game.WIN_TEXT_SIZE*Game.displayRatio);
		menu = new Texture(1.0f/Game.MENU_TEXT_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getHeight(), 
				    1.0f/Game.MENU_TEXT_SIZE*Game.displayRatio);
		menuBtnStart = new Texture(1.0f/Game.MENU_BUTTON_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.start_btn).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.start_btn).getHeight(), 
				    1.0f/Game.MENU_BUTTON_SIZE*Game.displayRatio);		
		menuBtnExit = new Texture(1.0f/Game.MENU_BUTTON_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.exit_btn).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.exit_btn).getHeight(), 
			        1.0f/Game.MENU_BUTTON_SIZE*Game.displayRatio);
		this.context = context;
		
		//android.util.Log.d("PongloopRunTime","GameRenderer");
	}

	@Override
	public void onDrawFrame(GL10 gl) {     
		float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
        startTime = System.nanoTime();
        gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		switch(Game.state) {
			case Menu:				
				menu.draw(gl, 
						0.0f - 1.0f/Game.MENU_TEXT_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getHeight()/2, 
						0.5f - 1.0f/Game.MENU_TEXT_SIZE*Game.displayRatio/2);				
				menuBtnStart.draw(gl, 
						0.0f - 1.0f/Game.MENU_TEXT_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getHeight()/2, 
						- 0.5f + 1.0f/Game.MENU_BUTTON_SIZE*Game.displayRatio/2);
				menuBtnExit.draw(gl, 
						0.0f + 1.0f/Game.MENU_TEXT_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.background).getHeight()/2 
						         - 1.0f/Game.MENU_BUTTON_SIZE*BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.exit_btn).getWidth()/BitmapFactory.decodeResource(context.getResources(), com.stiblasoft.pong.R.drawable.exit_btn).getHeight(), 
						- 0.5f + 1.0f/Game.MENU_BUTTON_SIZE*Game.displayRatio/2);
				break;
			case Initialized:	
				ball.resetBall(1);
				Game.score = 0;
				Game.scoreOpos = 0;
				Game.racquetOppPosY = 0;
				Game.racquetPosY = 0;
				Game.state = GameState.Running;
				break;
			case Running:				
				background.draw(gl);
				number.draw(gl, Game.scoreOpos, Game.score);		
				racquet.draw(gl, deltaTime, ball.ballPosY);			
				if(((System.nanoTime() - Game.startInitializingTime) / 1000000000.0f) > Game.INITIALIZED_DELAY) {
					ball.draw(gl, deltaTime);
				}
				break;
			case Finished:
				background.draw(gl);
				number.draw(gl, Game.scoreOpos, Game.score);		
				racquet.draw(gl, deltaTime, ball.ballPosY);		
				int whoWin = (Game.score > Game.scoreOpos) ? 1 : -1;
				win.draw(gl, (whoWin*1f - whoWin*1f/Game.PLAYING_AREA)/2 - 1.0f/Game.WIN_TEXT_SIZE, 0.0f - 1.0f/Game.WIN_TEXT_SIZE*Game.displayRatio/2);
				break;
			default:
				break;
		}
        //android.util.Log.d("PongloopRunTime", String.valueOf(deltaTime));
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) { 
		 gl.glViewport(0, 0, width, height); 
	     gl.glMatrixMode(GL10.GL_PROJECTION);
	     gl.glLoadIdentity();
	     gl.glOrthof(0, 1, 0, 1, 1, -1);
	     //android.util.Log.d("PongloopRunTime", "GameRenderer.onSurfaceChanged: " + width + "x" + height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) { 
		Game.racquetDir = 0; 
		Game.racquetPosY = 0; 
		Game.racquetOppPosY = 0;
		Game.touchPosY = 0;
		Game.score = 0;
		Game.scoreOpos = 0;
		startTime = System.nanoTime();
		win.createTexture(gl, context, com.stiblasoft.pong.R.drawable.win_transparent);
		menu.createTexture(gl, context, com.stiblasoft.pong.R.drawable.background);
		//menu.createTexture(gl, context, "background.png");
		menuBtnStart.createTexture(gl, context, com.stiblasoft.pong.R.drawable.start_btn);
		menuBtnExit.createTexture(gl, context, com.stiblasoft.pong.R.drawable.exit_btn);
		//android.util.Log.d("PongloopRunTime", "GameRenderer.onSurfaceCreated");
	}
}
