package com.elenaciuca.home.exercises.elevators;

import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager{
	
	public static void main(String[]args) {
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(new Elevator(1)); 
		elevatorList.add(new Elevator(2)); 
		elevatorList.add(new Elevator(3)); 
		
		Manager instanceManager = new ManagerImpl(elevatorList);
		
		Elevator aux = instanceManager.callTheElevator(5); 
		System.out.println(aux.currentFloor);
	}
	
	@Override
	public String toString() {
		return "ManagerImpl [elevatorList=" + elevatorList + "]";
	}

	List<Elevator> elevatorList;
	

	public ManagerImpl(List<Elevator> elevatorList) {
		this.elevatorList = elevatorList;
	}

	public Elevator callTheElevator(int floor) {
		Elevator aux = null;
		int distance1;
		int distance2;
		

		for (Elevator elevator : elevatorList) {
			if(aux == null) {
				aux = elevator;
			}
			else {
				distance1 = Math.abs(floor - elevator.currentFloor);
				distance2 = Math.abs(floor - aux.currentFloor);
				if(distance1 < distance2)	{
					aux = elevator;
				}	
			}
		}
		return aux;
	}
}
