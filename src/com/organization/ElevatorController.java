/**
 * 
 */
package com.organization;

import java.util.ArrayList;

/**
 * @author glaw Logic controller for elevator functions
 */
public class ElevatorController {

  private int maxFloor;
  private int maxElevators;
  final static private int MIN_FLOOR = 1;
  ArrayList<Elevator> elevators;
  

  /**
   * @param maxFloor
   * @param maxElevators
   */
  public ElevatorController(int maxFloor, int maxElevators) {
    super();
    this.maxFloor = maxFloor;
    this.maxElevators = maxElevators;

    for (int x = 1; x <= maxElevators; x++) {
      elevators.add(new Elevator(x));
    }
  }

  /**
   * @param elevator
   * @param floor
   */
  public void moveToFloor(Elevator elevator, int floor){
    int currentFloor = elevator.getCurrentFloor();
    
    while (currentFloor <= floor) {
      System.out.println("Elevator " + elevator.getElevatorId() + " Floor: " + currentFloor);
      currentFloor++;
    }
    
    elevator.setCurrentFloor(floor);
  }

  /**
   * @param elevator
   */
  public void openDoor (Elevator elevator){
    if (!elevator.isDoorOpen()){
      elevator.setDoorOpen(true);
    }
  }
  
  
}
