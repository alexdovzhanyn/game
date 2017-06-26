package com.alexdovzhanyn.game.renderEngine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Loader {
	
	// Just here for memory management, we'll use this to remove VAOs and VBOs from memory
	// when the game is terminated.
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();

	public RawModel loadToVAO(float[] positions, int[] indices) {
		int vaoID = createVAO();
		bindIndicesBuffer(indices);
		
		storeDataInAttributeList(0, positions);
		unbindVAO();
		
		return new RawModel(vaoID, indices.length);
	}
	
	private int createVAO(){
		// Initialize vertex array
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		
		// Bind vertex array before we can use it
		GL30.glBindVertexArray(vaoID);
		
		return vaoID;
		
	}
	
	private void bindIndicesBuffer(int[] indices){
		// Initialize empty buffer
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		
		// Bind buffer before use ... ELEMENT_ARRAY_BUFFER tells openGL to
		// use this buffer as the indices array buffer
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		
		IntBuffer buffer = storeDataInIntBuffer(indices);
		
		// Push our indices buffer to memory
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	private IntBuffer storeDataInIntBuffer(int[] data) {
		// Create a new buffer that will be used for indeies VBO
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		
		// Add our data to the buffer and flip it to make it readable
		buffer.put(data);
		buffer.flip();
		
		return buffer;
	}
	
	private void storeDataInAttributeList(int attributeNumber, float[] data){
		// Initialize buffer
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		
		// Bind buffer before we can use/modify it
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		
		// Create a VBO with our data and store it in memory
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
		// Store this new VBO into a VAO
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
		
		// We're now done with this VBO, it's safe to unbind it
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
	}
	
	private void unbindVAO(){
		// Binding to 0 just unbinds
		GL30.glBindVertexArray(0);
	}
	
	private FloatBuffer storeDataInFloatBuffer(float[] data){
		// VBO needs to be a float buffer, so create a new one the size of the data we have, and pass that in
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		
		buffer.put(data);
		
		// Reverse order of the buffer so we can read from it
		buffer.flip();
		
		return buffer;
	}
	
	public void cleanUp() {
		for (int vao:vaos) {
			GL30.glDeleteVertexArrays(vao);
		}
		
		for (int vbo:vbos) {
			GL15.glDeleteBuffers(vbo);
		}
	}
	
}
