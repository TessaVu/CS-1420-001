/**
 * This is an animatable class that populates
 * and manages the game over graphic and state
 * of the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class GameOver implements Animatable
{
	/**
	 * Method that updates the effects.
	 * 
	 * @param timeElapsed	A double representing time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// Game is over, no need to update.
	}

	/**
	 * Method that draws the effects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		// Draw the game over graphic.
		g.drawImage(ResourceLoader.getLoader().getImage("game_over.png"), -200, -50, null);
	}
}
