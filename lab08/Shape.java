/* Shape is a superclass with the
 * Rect and Circle child classes
 * inheriting from it. The program
 * includes a method to move the
 * shapes and two abstract methods:
 * isInside and draw.
 * @author		Tessa Vu
 * @course		CS 1420-001
 * @version		26 October 2021
*/

package lab08;
import java.awt.Graphics;
import java.awt.Color;

abstract public class Shape
{
    // Instance variables.
    // Protected int x and y.
    protected int x, y;
    
    // Protected Color object color.
    protected Color color;
	
    /**
     * Constructor - initializes x, y, and color.
     */
    public Shape(int x, int y, Color color)
    {
    	// Initialize x.
    	this.x = x;
    	
    	// Initialize y.
    	this.y = y;
    	
    	// Initialize color.
    	this.color = color;
    }

    /**
     * Changes the position of this shape by
     * the specified amount. Note that this does
     * not set the position absolutely, the deltas
     * specify how far to move the shape from its
     * current position.
     *
     * @param deltaX	how far to move the shape horizontally
     *
     * @param deltaY	how far to move the shape vertically
     */
    public void move(int deltaX, int deltaY)
    {
    	x = x + deltaX;
    	y = y + deltaY;
    }
    
    // Create abstraction methods.
    abstract public boolean isInside(int targetX, int targetY);

    abstract public void draw(Graphics g);
}
