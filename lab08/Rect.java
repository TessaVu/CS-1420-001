/* Rect is a class used to generate a
 * rectangle shape that inherits from
 * the Shape class with an isInside
 * method.
 * @author		Tessa Vu
 * @professor	Dr. Jensen
 * @course		CS 1420-001
 * @version		26 October 2021
*/

package lab08;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Rectangle objects represent a rectangle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Peter Jensen
 * @version Spring 2021
 */
public class Rect extends Shape
{
    // Instance variables.
	// Declare private int height and width.
	private int height, width;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x		the x coordinate of this rectangle's position
     *
     * @param y		the x coordinate of this rectangle's position
     *
     * @param height	the height of this rectangle
     *              
     * @param width		the width of this rectangle
     *
     * @param color		the color of this rectangle
     */
    public Rect(int x, int y, int height, int width, Color color)
    {
	// Call the superclass constructor. This must be the first statement
	// in this constructor.
	super(x, y, color);
	
	// Save the size.
	this.height = height;
	this.width = width;
    }

    /**
     * Draws the rectangle at it's current position and color
     * to the specified graphics object.
     *
     * @param g		the graphics object (where to draw to)
     */
    public void draw(Graphics g)
    {
    	g.setColor(color);
    	g.fillRect(x, y, width, height);
    }
    
    /**
     * Returns true if the coordinates are within the rectangle.
     *
     * @param targetX	an x coordinate
     *
     * @param targetY	a y coordinate
     *
     * @return	true if the coordinates are within the shape
     */
    public boolean isInside(int targetX, int targetY)
    {
    	return targetX >= x &&
    	targetX < x + width &&
    	targetY >= y &&
    	targetY < y + height;
    }
}