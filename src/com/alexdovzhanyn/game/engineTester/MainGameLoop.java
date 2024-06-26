package com.alexdovzhanyn.game.engineTester;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import com.alexdovzhanyn.game.entities.Camera;
import com.alexdovzhanyn.game.entities.Entity;
import com.alexdovzhanyn.game.entities.Light;
import com.alexdovzhanyn.game.models.RawModel;
import com.alexdovzhanyn.game.models.TexturedModel;
import com.alexdovzhanyn.game.renderEngine.DisplayManager;
import com.alexdovzhanyn.game.renderEngine.Loader;
import com.alexdovzhanyn.game.renderEngine.MasterRenderer;
import com.alexdovzhanyn.game.renderEngine.OBJLoader;
import com.alexdovzhanyn.game.terrain.Terrain;
import com.alexdovzhanyn.game.textures.ModelTexture;

/**
 * Main class of the game
 */
public class MainGameLoop {

	public static void main(String[] args) {
		// Initialize our display
		DisplayManager.createDisplay();	
		Loader loader = new Loader();
		
		// Load tree model and apply textures to it
		RawModel model = OBJLoader.loadObjModel("tree", loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("lowPolyTree")));
		ModelTexture texture = staticModel.getTexture();
		texture.setShineDamper(100);
		texture.setReflectivity(1);
		
		// List to contain all entities (trees) that will be instantiated
		List<Entity> entities = new ArrayList<Entity>();
		
		// Loop 200 times to create 200 trees
		for (int i = 0; i < 200; i++) {
			// Create a tree entity at a x and z coordinate on the terrain
			Entity tempEntity = new Entity(staticModel, new Vector3f((int) (Math.random() * 100 * (Math.random() > 0.5 ? 1 : -1)), 0, (int) -(Math.random() * 100)), 0, 0, 0, 1);
			
			System.out.println(tempEntity.getPosition());
			
			entities.add(tempEntity);
			
			System.out.println(entities.size());
		}
		
		// This is the entity we're rendering
//		Entity entity = new Entity(staticModel, new Vector3f(0,0,-25), 0, 0, 0, 1);
		
		// Our two terrains
		Terrain terrain = new Terrain(-1, -1, loader, new ModelTexture(loader.loadTexture("green")));
		Terrain terrain2 = new Terrain(0, -1, loader, new ModelTexture(loader.loadTexture("green")));
		
		// Light and camera
		Light light = new Light(new Vector3f(3000, 2000, 2000), new Vector3f(1,1,1));
		Camera camera = new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		
		// Actual main game loop, only run unless game is shut off
		while(!Display.isCloseRequested()) {
			// Call the move function to handle any camera related input
			camera.move();
			
			// Process the terrain
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			
			// Process all entities
			for (Entity entity:entities) {
				renderer.processEntity(entity);
			}

			// Process light & camera
			renderer.render(light, camera);
			// Update everything on the screen
			DisplayManager.updateDisplay();
		}
		
		// We should only get here when the game is closed
		// Get rid of all the active components and close the display
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
