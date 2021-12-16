/**
 * A BlueCircle object is a blue circle drawn on
 * the frame and moves within the path boundaries
 * according to the points in the .txt file.
 * 
 * Tessa Vu
 * Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

class Snail implements Animatable
{
	// Fields.
	private double position;
	private GameState state;
	
	/**
	 * Constructor that takes a double and initializes it in the body.
	 * 
	 * @param p		Double value for position.
	 */
	public Snail(double p, GameState state)
	{
		position = p; // Assign the position as the parameter.
		this.state = state;
	}
	
	/**
	 * This method updates the ball position given a double representing the time elapsed.
	 * 
	 * @param timeElapsed		Double value for time elapsed.
	 */
	public void update(double timeElapsed)
	{
		position += 0.003; // Increment position by 0.003.
		
		if (position > 1) // If position is greater than 1, restart the position. This loops the blue ball back to the beginning.
		{
			state.removeGameObject(this);
//			state.addScore(-1);
		}
	}

	/**
	 * This method draws the ball and specifies the path to be taken.
	 * 
	 * @param g		A graphics object.
	 */
	public void draw(Graphics g)
	{
		// Figure out where the ball should be drawn.
    	Point p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position); // Specifies path points and gets the path's position.
    	
    	// Draw the snail.
    	g.drawImage(ResourceLoader.getLoader().getImage("snail.png"), p.x - 25, p.y - 20, null);
	}
}