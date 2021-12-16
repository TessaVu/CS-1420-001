/**
 * This is a class that displays the bomb
 * mine within the menu.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class BombMineMenu extends Bomb
{
	// Fields.
	private GameState state;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state, x, y		Takes in the GameState and x and y points.
     * @return None.
     */
	public BombMineMenu(GameState state, int x, int y)
	{
		super(x, y);
		this.state = state;
	}
	
    /**
     * Method that updates the bomb mine menu.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		if(state.getMouseX() >= x && state.getMouseX() < x + 10 
				&& state.getMouseY() >= y && state.getMouseY() < y + 30 && state.isMouseClicked())
		{
			state.addGameObject(new BombMineMoving(state));
		}
	}

    /**
     * Method that draws the bomb mine menu.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g, GameView v)
	{
		v.drawCenteredImage(g, "bigSalt.png", x, y, 0.2);
	}
}
