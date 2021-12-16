/**
 * This is a class that displays the pepper tower
 * in the menu section of the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class TowerPepperMenu extends Tower
{
	// Fields.
	private GameState state;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state, x, y		Takes in the GameState and x and y points.
     * @return None.
     */
	public TowerPepperMenu(GameState state, int x, int y)
	{
		super(x, y);
		this.state = state;
	}
	
    /**
     * Method that updates the pepper tower menu.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		if(state.getMouseX() >= x && state.getMouseX() < x + 10 
				&& state.getMouseY() >= y && state.getMouseY() < y + 30 && state.isMouseClicked())
		{
			state.addGameObject(new TowerPepperMoving(state));
		}
	}

    /**
     * Method that draws the pepper tower menu.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
	public void draw(Graphics g, GameView v)
	{
		v.drawCenteredImage(g, "pepper.png", x, y, 1.0);
	}
}