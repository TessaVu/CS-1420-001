/**
 * Path objects represent the path of travel for the adversaries in 
 * our Tower Defense game.  A path is just a series of sequential
 * line segments.  A game object's position on the path is specified
 * by a 'percentage', or amount of the path that has been completed.
 * The start of the path is 0% completed, the end of the path is 100%
 * completed.  (The range is 0.0 to 1.0 as a double.)
 * 
 * This class was completed as part of checkpoint #1.  (You shouldn't
 * need to change it.)
 * 
 * @author Peter Jensen
 * @version Fall 2021
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Path
{
	// Fields
	// Keep the path in an ArrayList object, the path is a list of points.
	
	List<Point> path;
	
	/**
	 * This constructor expects to build a path from a list of points.
	 * The points are usually specified in a file (although they could
	 * just be listed in a String).  For convenience, this class expects
	 * a Scanner object that is ready to scan the points from the file
	 * (or String, if debugging). 
	 * 
	 * The constructor uses the Scanner to scan integers.  The format 
	 * of the list of points is:
	 *    # of points (as a single integer, n)
	 *    xcoord0 ycoord0
	 *    xcoord1 ycoord1    
	 *    xcoord2 ycoord2
	 *    ... repeated n times total ...
	 *   
	 * @param in a Scanner ready to scan the path description from a File or String
	 */
	public Path (Scanner in)
	{
		// Build the list to hold the points.
		
		path = new ArrayList<Point>();
		
		// Grab the number of points.
		
		int size = in.nextInt();
		
		// Scan each point, build a point object, then add it to the path.
		
		for (int count = 0; count < size; count++)
			path.add(new Point(in.nextInt(), in.nextInt()));		
	}
	
	/**
	 * Returns the total length of this path.
	 * 
	 * @return the path length
	 */
	public double getPathLength ()
	{
		// Assume the list of points implies a list of segments.
		// There will be one less segment than point.  (The classic
		// 'fence post problem')  This is why it is critical that
		// the loop below ends -before- it reaches the last point.
		//
		// Loop through the segments and add up their lengths.
		
		double length = 0;
		for (int i = 0; i < path.size()-1; i++)
			length += path.get(i).distance(path.get(i+1));
		
		return length;
	}
	
	/**
	 * For debugging only.  Draw each path segment in a bright color.
	 * 
	 * @param g any Graphics object
	 */
	public void draw (Graphics g)
	{
		g.setColor(Color.RED);
		for (int i = 0; i < path.size()-1; i++)
			g.drawLine(path.get(i).x, path.get(i).y,  path.get(i+1).x, path.get(i+1).y);		
	}
	
	/**
	 * Given a percentage of distance traveled along the path, this method
	 * returns that location on the path (as a point, or x,y pair).
	 * 
	 * Percentages should only be in [0.0...1.0].  To prevent problems,
	 * this function will return the first point for percentages < 0, and
	 * this function will return the last point for percentages > 1.  
	 * 
	 * @param percent the distance traveled
	 * @return a Point object containing that x, y location
	 */
	public Point getPathPosition (double percent)
	{
		// Make sure the percentage is in bounds.
		
		if (percent < 0.0)
			percent = 0.0;
		else if (percent > 1.0)
			percent = 1.0;
		
		// Figure out how many pixels we've traveled down the path.
		
		double totalLength = getPathLength();
		double remainingLength = totalLength * percent;
		
		// Identify which segment contains the point of interest.  I chose to use
		// a 'break' statement to exit the loop, but many other loop patterns are
		// OK here.
		
		int segment = 0;
		double segmentLength;  // Initialized below.
		while (true)  // Loop until we break.
		{
			// See if the next segment would be too far.  If so, exit the loop.
			
			segmentLength = path.get(segment).distance(path.get(segment+1));
			if (segmentLength >= remainingLength)
				break;
			
			// Move on to the next segment.  (The length will be set up at
			// the start of the next loop iteration.)
			
			remainingLength -= segmentLength;
			segment++;
		}
		
		// Use the remaining length to calculate a percentage x along the current segment
		
		double segPercentage = remainingLength / segmentLength;
		
		// Given that you want a point x percentage along a single segment, you
		// want 100%-x% of the first point's location, and x% of the second point's location.
		
		Point p = new Point ((int) ((1-segPercentage)*path.get(segment).x + (segPercentage)*path.get(segment+1).x), 
				             (int) ((1-segPercentage)*path.get(segment).y + (segPercentage)*path.get(segment+1).y));
				             
	    return p;
		
	}
	
	/**
	 * Returns the distance from the specified point to
	 * the nearest point along the path (node point).
	 * @param p
	 * @return
	 */
	public double distanceToNearestPathNode(Point p)
	{
		double shortest = path.get(0).distance(p);
		for (Point q : path)
		{
			double distance = p.distance(q);
			if (distance < shortest)
				shortest = distance;
		}
		
		return shortest;
	}
}
