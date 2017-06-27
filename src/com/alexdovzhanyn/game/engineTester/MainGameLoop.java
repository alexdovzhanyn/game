package com.alexdovzhanyn.game.engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import com.alexdovzhanyn.game.entities.Camera;
import com.alexdovzhanyn.game.entities.Entity;
import com.alexdovzhanyn.game.entities.Light;
import com.alexdovzhanyn.game.models.RawModel;
import com.alexdovzhanyn.game.models.TexturedModel;
import com.alexdovzhanyn.game.renderEngine.DisplayManager;
import com.alexdovzhanyn.game.renderEngine.Loader;
import com.alexdovzhanyn.game.renderEngine.OBJLoader;
import com.alexdovzhanyn.game.renderEngine.Renderer;
import com.alexdovzhanyn.game.shaders.StaticShader;
import com.alexdovzhanyn.game.textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		// Initialize our display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("texture")));
		
		Entity entity = new Entity(staticModel, new Vector3f(0,0,-5), 0, 0, 0, 1);
		Light light = new Light(new Vector3f(0,100,-20), new Vector3f(1,1,1));
		Camera camera = new Camera();
		
		// Actual main game loop, only run unless game is shut off
		while(!Display.isCloseRequested()) {
			entity.increaseRotation(0, 0.5f, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		// We should only get here when the game is closed.
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
