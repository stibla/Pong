package com.stiblasoft.pong;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GameView extends GLSurfaceView {
	private GameRenderer renderer;
	public GameView(Context context) {
		super(context);
		//android.util.Log.d("PongloopRunTime","GameView");		
		renderer = new GameRenderer(context);
		this.setRenderer(renderer);
	}
}