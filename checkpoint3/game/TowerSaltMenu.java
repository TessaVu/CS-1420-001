/**
 * This is a class that displays the salt tower
 * in the menu section of the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public class TowerSaltMenu implements Animatable
{
	// Fields.
	private GameState state;
	private int x, y;
	
    /**
     * Constructor method that initializes the parameters.
     * 
     * @param state, x, y		Takes in the GameState and x and y points.
     * @return None.
     */
	public TowerSaltMenu(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
	
    /**
     * Method that updates the salt tower menu.
     * 
     * @param timeElapsed		The time passed.
     * @return None.
     */
	public void update(double timeElapsed)
	{
		if(state.getMouseX() >= x && state.getMouseY() < x + 50 && state.getMouseY() >= y && state.getMouseY() < y + 50 && state.isMouseClicked())
		{
			state.addGameObject(new TowerSaltMoving(state));
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
		g.drawImage(ResourceLoader.getLoader().getImage("salt.png"), x, y, null);
	}
}
