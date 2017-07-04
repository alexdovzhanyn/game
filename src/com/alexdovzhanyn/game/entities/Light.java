package com.alexdovzhanyn.game.entities;

import org.lwjgl.util.vector.Vector3f;

/**
 * Light source with a location and color
 */
public class Light {

	// Location of the light in the xyz spectrum
	private Vector3f position;
	// Color of the light (probs rgb, idrk)
	private Vector3f colour;
	
	/**
	 * Create a new light with a position and a color
	 * @param position Vector3f with the position of the light
	 * @param colour Vectro3f with the color of the light
	 */
	public Light(Vector3f position, Vector3f colour) {
		this.position = position;
		this.colour = colour;
	}

	/**
	 * Retrieve the position of the light
	 * @return Vector3f containing the position of the light
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Set the position of the light
	 * @param position Vector3f containing the new position of the light
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	/** 
	 * Retrieve the color of the light
	 * @return Vector3f containing the color of the light
	 */
	public Vector3f getColour() {
		return colour;
	}

	/**
	 * Set the color of the light
	 * @param colour Vectro3f containing the new color of the light
	 */
	public void setColour(Vector3f colour) {
		this.colour = colour;
	}
	
	
	
}
