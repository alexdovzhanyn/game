package com.alexdovzhanyn.game.engineTester;

import org.lwjgl.opengl.Display;

import com.alexdovzhanyn.game.renderEngine.DisplayManager;
import com.alexdovzhanyn.game.renderEngine.Loader;
import com.alexdovzhanyn.game.renderEngine.RawModel;
import com.alexdovzhanyn.game.renderEngine.Renderer;
import com.alexdovzhanyn.game.shaders.StaticShader;

public class MainGameLoop {

	public static void main(String[] args) {
		// Initialize our display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertices = { 
			-0.5f, 0.5f, 0f, 
			-0.5f, -0.5f, 0f, 
			0.5f, -0.5f, 0f, 
			0.5f, 0.5f, 0f
		};
		
		int[] indices = {
			0, 1, 3,
			3, 1, 2
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		// Actual main game loop, only run unless game is shut off
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			//game logic
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		// We should only get here when the game is closed.
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
