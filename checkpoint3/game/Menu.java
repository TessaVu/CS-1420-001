/**
 * This is a class that manages all menu
 * items put into the game.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu implements Animatable
{
	// Fields.
	private GameState state;
	private boolean objectsAdded;
	
	public Menu(GameState state)
	{
		this.state = state;
		this.objectsAdded = false;
	}
	
	@Override
	/**
	 * Method that updates Menu objects.
	 * 
	 * @param timeElapsed	A double that represents time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		// Is this the first update? If so, add the menu items.
		if(!objectsAdded)
		{
			state.addGameObject(new TowerSaltMenu(state, 610, 520));
			state.addGameObject(new TowerPepperMenu(state, 650, 525));
			objectsAdded = true;
		}
	}

	@Override
	/**
	 * Method that draws Menu objects.
	 * 
	 * @param g		A graphics object.
	 * @return None.
	 */
	public void draw(Graphics g)
	{
		// Draw menu.
		g.setColor(new Color(0.9f, 0.8f, 0.7f));
		g.fillRect(600,  0,  300, 600);
		
		// Draw menu image.
//		g.drawImage(ResourceLoader.getLoader().getImage("salt_crystals.png"), 600, 0, null);
		
		// Draw the score.
		g.setColor(Color.BLACK);
//		g.setFont(new Font("arial", Font.BOLD, 20));
		int score = state.getScore();
		g.drawString("Score: " + score, 620,  30);
		
		// Draw the credits.
		g.setColor(Color.BLACK);
		int credits = state.getCredits();
		g.drawString("Credits: " + credits, 620,  60);
		
		// Draw the lives.
		g.setColor(Color.BLACK);
		int life = state.getLife();
		g.drawString("Lives: " + life, 620,  90);
	}
}
