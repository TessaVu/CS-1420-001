/**
 * This is a class that displays the bomb
 * mine and drags it with the mouse after
 * the menu item is clicked.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class BombMineMoving implements Animatable
{
	// Fields.
	private GameState state;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state		A GameState object.
     * @return None.
     */
	public BombMineMoving(GameState state)
	{
		this.state = state;
	}
	
    /**
     * Method that updates the bomb mine movement.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		Path p = ResourceLoader.getLoader().getPath("path.txt");
		Point q = new Point(state.getMouseX(), state.getMouseY());
		
		if(state.isMouseClicked() && p.distanceToNearestPathNode(q) < 2500 && state.getCredits() >= 2000)
		{
			state.removeGameObject(this);
			
			// If it is in a valid position, add to the game.
			if(state.getMouseX() <= 585)
			{
				state.addGameObject(new BombMine(state, state.getMouseX(), state.getMouseY()));
				state.changeCredits(-2000);
			}
		}
	}

    /**
     * Method that draws the bomb mine.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g, GameView v)
	{
		v.drawCenteredImage(g, "bigSalt.png", state.getMouseX(), state.getMouseY(), 0.2);
	}
}
