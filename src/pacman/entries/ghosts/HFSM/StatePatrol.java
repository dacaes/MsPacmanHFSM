package pacman.entries.ghosts.HFSM;

import java.util.EnumMap;
import java.util.Random;

import pacman.entries.ghosts.Functions;
import pacman.entries.ghosts.HFSM.Machine.eMachines;
import pacman.entries.ghosts.HFSM.Machine.eStates;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class StatePatrol extends State
{
	Random rnd=new Random();
	@Override
	eStates next(eMachines current_machine_name, Game game, GHOST ghost)
	{
		if(Functions.closeToMsPacman(ghost, game))	//if Ms Pac-Man is near
		{
			if(current_machine_name == eMachines.AGRESSIVE)
				return eStates.CHASE;	//approach her
			else
				return eStates.ESCAPE; //retreat from her
		}
		else
			return eStates.PATROL;
	}

	@Override
	EnumMap<GHOST, MOVE> action(eMachines current_machine_name, EnumMap<GHOST, MOVE> myMoves, Game game, GHOST ghost)
	{
		if(Functions.areTherePills(game))
		{
			if(current_machine_name == eMachines.AGRESSIVE)
			{
				myMoves.put(ghost,game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
						Functions.nearestPilltoPM(game),game.getGhostLastMoveMade(ghost),DM.PATH));
			}
			else
			{
				myMoves.put(ghost,game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
						Functions.farthestPilltoPM(game),game.getGhostLastMoveMade(ghost),DM.PATH));
			}
		}
		else
		{
			MOVE[] possibleMoves=game.getPossibleMoves(game.getGhostCurrentNodeIndex(ghost),game.getGhostLastMoveMade(ghost));
				myMoves.put(ghost,possibleMoves[rnd.nextInt(possibleMoves.length)]);
		}
		
		return myMoves;
	}
}
