package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;

import pacman.entries.ghosts.Functions;
import pacman.entries.ghosts.HFSM.Machine.eMachines;
import pacman.entries.ghosts.HFSM.Machine.eStates;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public final class StateChase extends State
{
	@Override
	eStates next(eMachines current_machine_name, Game game, GHOST ghost)
	{
		if(Functions.closeToMsPacman(ghost, game))	//approach Ms Pac-Man if she is near
			return eStates.CHASE;
		else
			return eStates.PATROL;
	}

	@Override
	EnumMap<GHOST, MOVE> action(eMachines current_machine_name, EnumMap<GHOST, MOVE> myMoves, Game game, GHOST ghost)
	{
		myMoves.put(ghost,game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
				game.getPacmanCurrentNodeIndex(),game.getGhostLastMoveMade(ghost),DM.PATH));

		
		return myMoves;
	}
}
