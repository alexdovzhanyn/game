package com.alexdovzhanyn.game.renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 120;
	
	public static void createDisplay(){
		// Specify version of openGL that we want to use
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			// Initialize our display
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("My 3D Game");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		// Tell openGL where within the viewport it is allowed to render.
		// In our case, this is the whole window.
		GL11.glViewport(0,0,WIDTH,HEIGHT);
		
	};
	
	public static void updateDisplay(){
		Display.sync(FPS_CAP);
		Display.update();
	};
	
	public static void closeDisplay(){};

}
