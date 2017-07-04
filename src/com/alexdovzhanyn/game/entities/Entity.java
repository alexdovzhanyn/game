package com.alexdovzhanyn.game.entities;

import org.lwjgl.util.vector.Vector3f;

import com.alexdovzhanyn.game.models.TexturedModel;

/**
 * An in-game object based on a model, position, rotation and scale
 */
public class Entity {

	// The model used to visually represent the object
	private TexturedModel model;
	// Location of the object in the xyz spectrum
	private Vector3f position;
	// Rotation of the object on the x-, y-, and z-axis
	private float rotX, rotY, rotZ;
	// The scale at which the model should be sized
	private float scale;
	
	/**
	 * Fetch the model attached to the object
	 * @return TexturedModel the 3d model with applied textures
	 */
	public TexturedModel getModel() {
		return model;
	}
	
	/**
	 * Change the position of the entity along the xyz axes
	 * @param dx float by which the x axis position should be increased
	 * @param dy float by which the y axis position should be increased
	 * @param dz float by which the z axis position should be increased
	 */
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	/**
	 * Change the rotation of the entity along the xyz axes
	 * @param dx float by which the x axis rotation should be increased
	 * @param dy float by which the y axis rotation should be increased
	 * @param dz float by which the z axis rotation should be increased
	 */
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}

	/**
	 * Change the model of the entity
	 * @param model the new textured model
	 */
	public void setModel(TexturedModel model) {
		this.model = model;
	}

	/**
	 * Retrieve the position of the entity
	 * @return Vector3f containing the position of the entity
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Set the position of the entity
	 * @param position Vector3f containing the new position of the entity
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	/**
	 * Retrieve the rotation along the x-axis of the entity
	 * @return float containing the rotation along the x-axis of the entity
	 */
	public float getRotX() {
		return rotX;
	}

	/**
	 * Set the rotation along the x-axis of the entity
	 * @param rotX float containing the new rotation along the x-axis of the entity
	 */
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	/**
	 * Retrieve the rotation along the y-axis of the entity
	 * @return float containing the rotation along the y-axis of the entity
	 */
	public float getRotY() {
		return rotY;
	}

	/**
	 * Set the rotation along the y-axis of the entity
	 * @param rotY float containing the new rotation along the y-axis of the entity
	 */
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	/**
	 * Retrieve the rotation along the z-axis of the entity
	 * @return float containing the rotation along the z-axis of the entity
	 */
	public float getRotZ() {
		return rotZ;
	}

	/**
	 * Set the rotation along the z-axis of the entity
	 * @param rotZ float containing the new rotation along the z-axis of the entity
	 */
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	/**
	 * Retrieve the scale of the entity in combination with the model
	 * @return float containing the scale
	 */
	public float getScale() {
		return scale;
	}

	/**
	 * Set the scale of the entity in combination with the model
	 * @param scale float containing the new scale
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}

	/**
	 * Create a new in-game model to be shown in game
	 * @param model TexturedModel the set up model with applied textures
	 * @param position Vector3f the position for displaying the model
	 * @param rotX float the rotation around the x-axis for displaying the model
	 * @param rotY float the rotation around the y-axis for displaying the model
	 * @param rotZ float the rotation around the z-axis for displaying the model
	 * @param scale float the scale at which the model should be displayed
	 */
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super();
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
}
