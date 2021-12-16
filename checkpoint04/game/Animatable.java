/**
 * An Animatable is an interface that
 * updates the time elapsed and draws
 * graphics.
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;

public interface Animatable
{
	public void update(double timeElapsed);
	public void draw(Graphics g, GameView v);
}