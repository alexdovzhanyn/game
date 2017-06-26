package com.alexdovzhanyn.game.renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {
	
	public void prepare() {
		GL11.glClearColor(0.0f, 0.2f, 0.2f, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	public void render(RawModel model) {
		// Bind the model's VAO before we can do anything with it
		GL30.glBindVertexArray(model.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		
		// Render our model
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		
		// Disable and unbind our VAO
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
	
	

}
