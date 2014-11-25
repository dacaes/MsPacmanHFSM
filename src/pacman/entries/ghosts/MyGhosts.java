package pacman.entries.ghosts;

import java.util.EnumMap;

import pacman.controllers.Controller;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{	
//	private Logger log;
	private EnumMap<GHOST, MOVE> myMoves = new EnumMap<GHOST, MOVE>(GHOST.class);
	
	private EnumMap<GHOST, MachineMain> myMachines = new EnumMap<GHOST, MachineMain>(GHOST.class);
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue)
	{	
		//MainMachine myMainMachine = new MainMachine();
		myMoves.clear();
		//Place your game logic here to play the game as the ghosts
		for(GHOST ghost : GHOST.values())	//for each ghost
		{			
			if(game.doesGhostRequireAction(ghost))		//if ghost requires an action
			{
				myMachines.get(ghost).update(myMoves, ghost, game);
				
//				if(ghost == GHOST.BLINKY)
//					log.info(""+myMoves);
			}
		}
		
		return myMoves;
	}
	
	public MyGhosts()
	{
//		log = Logger.getLogger(StateChase.class.getName()); 
		
		MachineMain BlinkyMachine = new MachineMain();
		MachineMain PinkyMachine = new MachineMain();
		MachineMain InkyMachine = new MachineMain();
		MachineMain SueMachine = new MachineMain();
		
		myMachines.put(GHOST.BLINKY, BlinkyMachine);
		myMachines.put(GHOST.PINKY, PinkyMachine);
		myMachines.put(GHOST.INKY, InkyMachine);
		myMachines.put(GHOST.SUE, SueMachine);
	}
}