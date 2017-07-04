package com.alexdovzhanyn.game.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 * Class that provides the player perspective
 */
public class Camera {

	// Location of the camera in the xyz spectrum
	private Vector3f position = new Vector3f(0,1,0);
	// Rotation of the camera along the x-axis
	private float pitch;
	// Rotation of the camera along the y-axis
	private float yaw;
	// Rotation of the camera along the z-axis
	private float roll;
	
	/**
	 * 
	 */
	public Camera(){}
	
	/**
	 * Update the position of the camera based on keyboard input
	 */
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 0.1f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 0.1f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 0.1f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 0.1f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.y += 0.1f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.y -= 0.1f;
		}
		
	}

	/**
	 * Retrieve the position of the camera
	 * @return Vector3f containing the position of the camera
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Retrieve the pitch of the camera
	 * @return float containing the pitch of the camera
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Retrieve the yaw of the camera
	 * @return float containing the yaw of the camera
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Retrieve the roll of the camera
	 * @return float containing the roll of the camera
	 */
	public float getRoll() {
		return roll;
	}
	
	
}
