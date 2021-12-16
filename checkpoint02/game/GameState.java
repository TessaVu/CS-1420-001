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
    List<Animatable> gameObjects;
    List<Animatable> objectsToRemove;
    List<Animatable> objectsToAdd;
    
    /**
     * Constructor that initializes game objects as
     * a new array list of Animatables.
     * 
     * @param None.
     */
    public GameState()
    {
    	gameObjects = new ArrayList<Animatable>();
    	objectsToRemove = new ArrayList<Animatable>();
    	objectsToAdd = new ArrayList<Animatable>();
    }
    
    /**
     * Method that adds game objects given an Animatable.
     * 
     * @param a		An Animatable object.
     */
    public void addGameObject(Animatable a)
    {
    	objectsToAdd.add(a);
    }
    
    /**
     * Method that removes game objects given an Animatable.
     * 
     * @param a		An Animatable object.
     */
    public void removeGameObject(Animatable a)
    {
    	objectsToRemove.add(a);
    }
    
    /**
     * Method that updates game objects.
     * 
     * @param None.
     */
    public void updateAll()
    {
    	// Update everything.
    	for(Animatable a : gameObjects)
    		a.update(0);
    	
    	// Remove things that need removing.
    	gameObjects.removeAll(objectsToRemove);
    	objectsToRemove.clear();
    	
    	gameObjects.addAll(objectsToAdd);
    	objectsToAdd.clear();
    }
    
    /**
     * Method that draws all game objects.
     * 
     * @param g		A Graphics object.
     */
    public void drawAll(Graphics g)
    {
    	for(Animatable a : gameObjects)
    		a.draw(g);    	
    }
}
