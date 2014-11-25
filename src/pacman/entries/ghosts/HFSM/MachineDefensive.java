package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class MachineDefensive extends Machine
{
	protected State current_state;
	protected EnumMap<eStates, State> myStates; 
//	private Logger log;
	
	@Override
	public EnumMap<GHOST, MOVE> update(EnumMap<GHOST, MOVE> myMoves, GHOST ghost, Game game)
	{
		current_state_name = current_state.next(current_machine_name, game, ghost);
		
//		if(ghost == GHOST.BLINKY)
//			log.info("máquina de " + ghost + " estoy en SUBestado " + current_state_name);
		
		current_state = myStates.get(current_state_name);
		current_state.action(current_machine_name, myMoves, game, ghost);
		return myMoves;
	}
	
	public MachineDefensive()
	{
		super();
	}
	
	@Override
	protected void init()
	{
//		log = Logger.getLogger(StateChase.class.getName());
		current_machine_name = eMachines.DEFENSIVE;
		
		myStates = new EnumMap<eStates, State>(eStates.class);
		myStates.put(eStates.ESCAPE, new StateEscape());
		myStates.put(eStates.PATROL, new StatePatrol());
		
		current_state_name = eStates.ESCAPE;
		current_state = myStates.get(current_state_name);
	}
}
