/**
 * 
 */
package com.organization;

/**
 * @author glaw
 * Concrete class to represent elevator car object
 */
public class Elevator {
  private int elevatorId;
  private int currentFloor = 1;
  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  private boolean doorOpen = false;
    
  public boolean isDoorOpen() {
    return doorOpen;
  }

  public void setDoorOpen(boolean doorOpen) {
    this.doorOpen = doorOpen;
  }

  public Elevator(int elevatorId) {
    this.elevatorId = elevatorId;
  }

  public int getElevatorId() {
    return elevatorId;
  }

  public void setElevatorId(int elevatorId) {
    this.elevatorId = elevatorId;
  }



  

}
