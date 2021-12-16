/**
 * A GameState object represents the current 'state' of the game. This
 * includes things like score, tower positions, etc., but also includes
 * smaller details like mouse location and mouse click information (that
 * we have recorded). Also, this object will hold a List of all the 
 * things that move, update, or interact with the screen. 
 * 
 * The idea is that everything that is unique about a single game's 
 * session is here. If you were to save everything stored here to a file, and
 * then reload it later, the game would be in exactly the same 'state'
 * as it was before.
 * 
 * There is exactly one GameState object for the entire game. (It's
 * purpose is to hold the data that changes as the game changes.)
 * 
 * @author Tessa Vu
 * @version Fall 2021
 */

package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameState 
{
	// Fields.
//	double totalTime;
	private List<Animatable> gameObjects; // Active objects.
	private List<Animatable> objectsToRemove; // Objects to remove.
	private List<Animatable> objectsToAdd; // Objects to add.
    private int mouseX, mouseY;
    private boolean mouseClicked;
    private boolean gameOver;
    private boolean gamePlaying;
    private int credits;
    private int score;
    private int life;
    
    /**
     * Constructor that initializes game objects as
     * a new array list of Animatables.
     * 
     * @param None.
     * @return None.
     */
    public GameState()
    {
    	gameObjects = new ArrayList<Animatable>();
    	objectsToRemove = new ArrayList<Animatable>();
    	objectsToAdd = new ArrayList<Animatable>();
    	
    	mouseX = mouseY = 0;
    	mouseClicked = false;
    	
    	score = 0;
    	credits = 1000;
    	life = 2;
    	
    	gameOver = false;
    }
    
    /**
     * Method that adds game objects given an Animatable.
     * 
     * @param a		An Animatable object.
     * @return None.
     */
    public void addGameObject(Animatable a)
    {
    	objectsToAdd.add(a);
    }
    
    /**
     * Method that removes game objects given an Animatable.
     * 
     * @param a		An Animatable object.
     * @return None.
     */
    public void removeGameObject(Animatable a)
    {
    	objectsToRemove.add(a);
    }
    
    /**
     * Method that sets the mouse's location in x, y coordinates.
     * 
     * @param x, y		x and y positions.
     * @return None.
     */
    public void setMouseLocation(int x, int y)
    {
    	mouseX = x;
    	mouseY = y;
//    	System.out.println("X: " + x + ", Y: " + y);
    }
    
    /**
     * A getter method that retrieves the x position of the mouse.
     * 
     * @param None.
     * @return int		Returns mouse position at x.
     */
    public int getMouseX()
    {
    	return mouseX;
    }
    
    /**
     * A getter method that retrieves the y position of the mouse.
     * 
     * @param None.
     * @return int		Returns mouse position at y.
     */
    public int getMouseY()
    {
    	return mouseY;
    }
    
    /**
     * A method that uses a boolean to determine of the mouse was clicked.
     * 
     * @param None.
     * @return boolean		Represents if the mouse has been clicked or not.
     */
    public boolean isMouseClicked()
    {
    	return mouseClicked;
    }
    
    /**
     * A method that sets the mouse click.
     * 
     * @param None.
     * @return None.
     */
    public void setMouseClicked()
    {
    	mouseClicked = true;
//    	System.out.println("Clicked.");
    }
    
    /**
     * A method that allows the mouse click to be consumed.
     * 
     * @param None.
     * @return None.
     */
    public void consumeMouseClick()
    {
    	mouseClicked = false;
    }
    
    /**
     * Method that gets the life count.
     * 
     * @param None.
     * @return int		Represents the life count.
     */
	public int getLife()
	{
		return life;
	}
	
	/**
	 * Method that changes the life. If it drops below
	 * 0, the game state will end the game at the end
	 * of the next update.
	 * 
	 * @param delta		Represents the change in life count.
	 * @return None.
	 */
	public void changeLife(int delta)
	{
		life += delta;
	}
	
    /**
     * Method that gets the score count.
     * 
     * @param None.
     * @return int		Represents the score.
     */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Method that changes the score, which can be negative.
	 * 
	 * @param delta		Represents the change in score.
	 * @return None.
	 */
	public void changeScore(int delta)
	{
		score += delta;
	}

    /**
     * Method that gets the credit count.
     * 
     * @param None.
     * @return int		Represents the credits.
     */
	public int getCredits()
	{
		return credits;
	}
	
	/**
	 * Method that changes the credits.
	 * 
	 * @param delta		Represents the change in credits.
	 * @return None.
	 */
	public void changeCredits(int delta)
	{
		credits += delta;
	}
    
    /**
     * Method that updates game objects.
     * 
     * @param timeElapsed	A double that represents time passed.
     * @return None.
     */
    public void updateAll(double timeElapsed)
    {
    	// Update everything.
    	if(!gameOver)
    	{
    		for(Animatable a : gameObjects)
    		{
    			a.update(timeElapsed);
    		}
    		
    		// Check for game end.
	    	if(life <= 0)
	    	{
	    		life = 0;
	    		gameOver = true;
	    		addGameObject(new EffectGameOver());
	    	}
	    	
	    	// Remove things that need removing.
	    	gameObjects.removeAll(objectsToRemove);
	    	objectsToRemove.clear();
	    	
	    	// Add things that need adding.
	    	gameObjects.addAll(objectsToAdd);
	    	objectsToAdd.clear();
    	}
    }
    
    /**
     * Method that draws all game objects.
     * 
     * @param g		A Graphics object.
     * @return None.
     */
    public void drawAll(Graphics g)
    {
    	for(Animatable a : gameObjects)
    		a.draw(g);    	
    }
}
