package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

/**
 * Abstract class for the machines of the FSM AI.
 * @author Carlos Bailón Pérez y Daniel Castaño Estrella
 *
 */
public abstract class Machine
{
	/**
	 * All the machines used in the AI.
	 * @author Carlos Bailón Pérez y Daniel Castaño Estrella
	 *
	 */
	public static enum eMachines{
		MAIN, AGRESSIVE, DEFENSIVE;
	}
	
	/**
	 * All the states used in the AI.
	 * @author Carlos Bailón Pérez y Daniel Castaño Estrella
	 *
	 */
	public static enum eStates{
		AGRESSIVE, DEFENSIVE, CHASE, ESCAPE, PATROL;
	}
	
	protected eMachines current_machine_name;
	protected eStates current_state_name;
	
	/**
	 * Constructor that calls the init function.
	 */
	public Machine() {
		init();
	}

	/**
	 * Function that initializes all the variables.
	 */
	protected abstract void init();

	/**
	 * Unique function of machine class. Called every time a ghost need to act.
	 * Set the current state with state.next() method and then call it's action function.
	 * @param myMoves the moves the ghost will do
	 * @param ghost current ghost
	 * @param game our game
	 * @return myMoves
	 */
	public abstract EnumMap<GHOST, MOVE> update(EnumMap<GHOST, MOVE> myMoves, GHOST ghost, Game game);
}
