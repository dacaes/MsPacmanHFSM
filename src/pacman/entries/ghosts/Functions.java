package pacman.entries.ghosts;

import pacman.game.Constants.GHOST;
import pacman.game.Game;

/**
 * Auxiliary class with common functions to calculate.
 * @author Carlos Bailón Pérez y Daniel Castaño Estrella
 *
 */
public final class Functions
{
	private final static int PILL_PROXIMITY=15;		//if Ms Pac-Man is this close to a power pill, back away
	private final static int PM_PROXIMITY=70;		//if Ms Pac-Man is this close...
	
	/**
	 * This helper function checks if Ms Pac-Man is close to an available power pill.
	 * @param game our game
	 * @return true or false
	 */
	public static boolean closeToPower(Game game)
    {
    	int[] powerPills=game.getPowerPillIndices();
    	
    	for(int i=0;i<powerPills.length;i++)
    	{
    		if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex())<PILL_PROXIMITY)
    			return true;
    	}
    	
        return false;
    }
	
	/**
	 * This helper function checks if current ghost is close to Ms Pac-Man.
	 * @param ghost current ghost
	 * @param game out game
	 * @return true or false
	 */
	public static boolean closeToMsPacman(GHOST ghost, Game game)
    {
		if(game.getShortestPathDistance(game.getGhostCurrentNodeIndex(ghost),game.getPacmanCurrentNodeIndex())<PM_PROXIMITY)
    		return true;

        return false;
    }
	
	/**
	 * This helper function checks the closest power pill to Ms Pac-Man.
	 * @param game our game
	 * @return node of the pill
	 */
	public static int nearestPilltoPM(Game game)
    {
		int[] powerPills=game.getPowerPillIndices();
		int distance_aux = game.getShortestPathDistance(powerPills[0],game.getPacmanCurrentNodeIndex());
		int pill = 0;
		
    	for(int i=1;i<powerPills.length;i++)
    	{
    		if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex()) < distance_aux)
    			pill = i;
    	}
    	
    	return powerPills[pill];
    }
	
	/**
	 * This helper function checks the farthest power pill to Ms Pac-Man.
	 * @param game our game
	 * @return node of the pill
	 */
	public static int farthestPilltoPM(Game game)
    {
		int[] powerPills=game.getPowerPillIndices();
		int distance_aux = game.getShortestPathDistance(powerPills[0],game.getPacmanCurrentNodeIndex());
		int pill = 0;
		
    	for(int i=1;i<powerPills.length;i++)
    	{
    		if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex()) > distance_aux)
    			pill = i;
    	}
    	
    	return powerPills[pill];
    }
	
	/**
	 * This helper function checks if there are power pills.
	 * @param game our game
	 * @return true or false
	 */
	public static boolean areTherePills(Game game)
    {
		int[] powerPills=game.getPowerPillIndices();
    	
    	for(int i=0;i<powerPills.length;i++)
    	{
    		if(game.isPowerPillStillAvailable(i))
    			return true;
    	}
    	
        return false;
    }
}
