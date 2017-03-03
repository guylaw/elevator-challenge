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
  private boolean doorOpen = false;
  private boolean doorClosed = true;
    
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
