/**
 * The BombMine class is a type of tool
 * that is put on the map and destroys
 * all enemies within a certain distance
 * for five seconds.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.awt.Point;

public class BombMine extends Bomb
{
	// Fields.
	private GameState state;
	private double age;
	
	/**
	 * Constructor that initializes Bomb position.
	 * 
	 * @param x, y		Integers that represent the bomb location in x, y coordinates.
	 * @return None.
	 */
	public BombMine(GameState state, int x, int y)
	{
		super(x, y);
		this.state = state;
		
		age = 0;
	}
	
	/**
	 * Method that updates Bomb objects.
	 * 
	 * @param timeElapsed	A double that represents time passed.
	 * @return None.
	 */
	public void update(double timeElapsed)
	{
		age += timeElapsed;
		if(age > 5.0) // If age is greater than 10 seconds...
		{
			state.removeGameObject(this); // Remove the effect.
			return;
		}
		
		// Find the nearest enemy.
		Point p = new Point((int)x, (int)y);
		Enemy e = state.findNearestEnemy(p);
		
		// If there is an enemy within distance and it is a snail...
		if(e != null && e.getPosition().distance(p) < 200 && e instanceof EnemySnail)
		{
			// Remove the snail and effect and change the score and credits.
			e = (EnemySnail)e;
			state.removeGameObject(e);
			state.changeScore(100);
			state.changeCredits(100);
		}
		
		// If there is an enemy within distance and it is an SCargo...
		if(e != null && e.getPosition().distance(p) < 200 && e instanceof EnemySCargo)
		{
			// Remove the SCargo and effect and change the score and credits.
			e = (EnemySCargo)e;
			state.removeGameObject(e);
			state.changeScore(300);
			state.changeCredits(300);
		}
	}

	/**
	 * Method that draws Tower objects.
	 * 
	 * @param g, v		A Graphics object and GameView object respectively.
	 * @return None.
	 */
	public void draw(Graphics g, GameView v)
	{
		v.drawCenteredImage(g, "bigSalt.png", x, y, 0.2);
	}
}
