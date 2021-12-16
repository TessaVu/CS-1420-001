/**
 * This is a class that moves the salt tower
 * when the user wants to click and place it in
 * the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSaltMoving implements Animatable
{
	// Fields.
	private GameState state;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state		A GameState object.
     * @return None.
     */
	public TowerSaltMoving(GameState state)
	{
		this.state = state;
	}
	
    /**
     * Method that updates the salt tower movement.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		Path p = ResourceLoader.getLoader().getPath("path.txt");
		Point q = new Point(state.getMouseX(), state.getMouseY());
				
		if(state.isMouseClicked()) // && p.distanceToNearestPathNode(q) > 30)
		{
			state.removeGameObject(this);
			
			// If it is in a valid position, add to the game.
			if(state.getMouseX() <= 560)
				state.addGameObject(new TowerSalt(state, state.getMouseX(), state.getMouseY()));
		}
	}

    /**
     * Method that draws the salt tower menu.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g)
	{
		g.drawImage(ResourceLoader.getLoader().getImage("salt.png"), state.getMouseX(), state.getMouseY(), null);
	}
}
