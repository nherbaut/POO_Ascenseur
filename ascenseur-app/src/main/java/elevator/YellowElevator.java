package elevator;


import java.util.ArrayList;
import java.util.LinkedHashMap;

import floor.Floor;


public class YellowElevator extends Elevator {

	private static int YellowElevatorNumber = 0;
	private static String elevatorColor = "yellow";
	private static int maxWeight = 1000;
	
 
	public YellowElevator(LinkedHashMap<Floor, Integer> reachableFloors, Dispatcher d) {
		super(YellowElevator.elevatorColor, YellowElevator.maxWeight, ++YellowElevatorNumber, reachableFloors);
	}

}
