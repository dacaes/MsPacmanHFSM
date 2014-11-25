package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public final class MachineMain extends Machine
{
	protected State current_state;
	protected EnumMap<eStates, State> myStates; 
//	private Logger log;
	
	@Override
	public EnumMap<GHOST, MOVE> update(EnumMap<GHOST, MOVE> myMoves, GHOST ghost, Game game)
	{
		current_state_name = current_state.next(current_machine_name, game, ghost);	
		
//		if(ghost == GHOST.BLINKY)
//			log.info("máquina de " + ghost + " estoy en estado " + current_state_name);
		
		current_state = myStates.get(current_state_name);
		current_state.action(current_machine_name, myMoves, game, ghost);
		return myMoves;
	}
	
	public MachineMain()
	{
		super();
	}
	
	@Override
	protected void init()
	{
//		log = Logger.getLogger(StateChase.class.getName()); 
		current_machine_name = eMachines.MAIN;
		
		myStates = new EnumMap<eStates, State>(eStates.class);
		myStates.put(eStates.AGRESSIVE, new StateAgressive());
		myStates.put(eStates.DEFENSIVE, new StateDefensive());
		
		current_state_name = eStates.AGRESSIVE;
		current_state = myStates.get(current_state_name);
	}
	
}
