package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.entries.ghosts.HFSM.Machine.eMachines;
import pacman.entries.ghosts.HFSM.Machine.eStates;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/**
 * Abstract class for the states of the FSM AI.
 * @author Carlos Bailón Pérez y Daniel Castaño Estrella
 *
 */
public abstract class State
{
	/**
	 * Function that switch to the next state if it's needed.
	 * @param current_machine_name name of the current machine
	 * @param game our game
	 * @param ghost current ghost
	 * @return next state
	 */
	abstract eStates next(eMachines current_machine_name, Game game, GHOST ghost);
	
	/**
	 * Function that implements the next action of the state
	 * @param current_machine_name name of the current machine
	 * @param myMoves the moves of the current ghost
	 * @param game our game
	 * @param ghost current ghost
	 * @return next state myMoves
	 */
	abstract EnumMap<GHOST, MOVE> action(eMachines current_machine_name, EnumMap<GHOST, MOVE> myMoves, Game game, GHOST ghost);
}
