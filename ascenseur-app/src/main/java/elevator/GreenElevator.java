package elevator;


import java.util.ArrayList;
import java.util.LinkedHashMap;

import floor.Floor;


public class GreenElevator extends Elevator {

	private static int GreenElevatorNumber = 0;
	private static String elevatorColor = "green";
	private static int maxWeight = 1000;
	 

	public GreenElevator(LinkedHashMap<Floor, Integer> reachableFloors, Dispatcher d) {
		super(GreenElevator.elevatorColor, GreenElevator.maxWeight, ++GreenElevatorNumber, reachableFloors);
	}
}
	 

