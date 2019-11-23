package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.BeforeClass;
import org.junit.Test;
import elevator.Dispatcher;
import elevator.Elevator;
import exceptions.FirstFloorExeption;
import exceptions.LastFloorExeption;
import exceptions.UnreachableFloor;
import floor.Floor;
import main.SystemInit;
import user.Student;
import user.User;

public class ElevatorTest {

	static List<Elevator> greens, yellows, reds;
	static SystemInit syst;
	static Dispatcher dispatch;
	 
	@BeforeClass
	public static void init() {		
		syst = SystemInitTest.systToTest;
		dispatch = syst.dispatcheur;
		
		greens = dispatch.getListElevator().get("green");
		yellows = dispatch.getListElevator().get("yellow");
		reds = dispatch.getListElevator().get("red");
	}
	 
	 
	@Test
	public void ElevatorAttributesTest() throws LastFloorExeption, FirstFloorExeption {
		// Check 'elevatorNumber' attribute
		for(int i = 1 ; i < yellows.size()+1 ; i++) {
			System.out.println(yellows.get(i-1).getElevatorNumber());
		}
		for(int i = 1 ; i < reds.size()+1 ; i++) {
			System.out.println(reds.get(i-1).getElevatorNumber());
		}
		for(int i = 1 ; i < greens.size()+1 ; i++) {
			assertEquals(i,  greens.get(i-1).getElevatorNumber());
		}
			 
		Elevator green1 = greens.get(0);
		Elevator yellow1 = yellows.get(0);
		Elevator red1 = reds.get(0);
		
		assertEquals("green", green1.getColor());
		assertEquals(null, green1.getDirection());
		assertEquals(1000, green1.getMaxWeight());			//TODO : put the real weight
		assertEquals(0, green1.getPosition().getFloorNumber());
		green1.goUp();
		assertEquals(4, green1.getPosition().getFloorNumber());
		assertEquals("up", green1.getDirection());
		green1.goDown();
		assertEquals(0, green1.getPosition().getFloorNumber());
		assertEquals("down", green1.getDirection());
		
		assertEquals("yellow", yellow1.getColor());
		assertEquals(null, yellow1.getDirection());
		assertEquals(1000, yellow1.getMaxWeight());			//TODO : put the real weight
		
		assertEquals("red", red1.getColor());
		assertEquals(null, red1.getDirection());
		assertEquals(1000, red1.getMaxWeight());			//TODO : put the real weight
		
		
		
	}

 
	@Test
	public void floorToElevatorAndExitTest() throws FirstFloorExeption, LastFloorExeption {
		Elevator greenElevator = greens.get(0);

		PriorityQueue<User> pq = new PriorityQueue<>();
		
		User u1 = new Student("David", "Ekchajzer", 21, 75, false, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		User u2 = new Student("Mathieu", "Ridet", 21, 75, false, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		
		pq.add(u1);
		pq.add(u2);
		
		try {
			greenElevator.floorToElevator(pq);
		} catch (UnreachableFloor e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(!greenElevator.getPassengers().isEmpty());
		assertEquals(2, greenElevator.getPassengers().size());
		
		// On va à l'étage suivant : le 4 (destination finale de nos 2 users)
		greenElevator.goUp();
		greenElevator.exit();
		
		assertEquals(0, greenElevator.getPassengers().size());
	}
	
}
