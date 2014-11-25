package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.entries.ghosts.Functions;
import pacman.entries.ghosts.HFSM.Machine.eMachines;
import pacman.entries.ghosts.HFSM.Machine.eStates;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class StateAgressive extends State
{
	private MachineAgressive myMachineAgressive;
	
	@Override
	eStates next(eMachines current_machine_name, Game game, GHOST ghost)
	{
		if(game.getGhostEdibleTime(ghost)>0 || Functions.closeToPower(game))	//retreat from Ms Pac-Man if edible or if Ms Pac-Man is close to power pill
			return eStates.DEFENSIVE;
		else
			return eStates.AGRESSIVE;
	}

	@Override
	EnumMap<GHOST, MOVE> action(eMachines current_machine_name, EnumMap<GHOST, MOVE> myMoves, Game game, GHOST ghost)
	{
		myMachineAgressive.update(myMoves, ghost, game);
		
		return myMoves;
	}
	
	public StateAgressive()
	{	
		myMachineAgressive = new MachineAgressive();
	}
}
