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
  private boolean occupied = false;
  private boolean movingUp = false;
  private int destinationFloor = 1;
  private int trips = 0;
  private boolean inMaintenanceMode = false;
  
  public boolean isInMaintenanceMode() {
    return inMaintenanceMode;
  }

  public void setInMaintenanceMode(boolean inMaintenanceMode) {
    this.inMaintenanceMode = inMaintenanceMode;
  }

  public int getTrips() {
    return trips;
  }

  public void setTrips(int trips) {
    this.trips = trips;
  }

  
  public int getFloorsPassed() {
    return floorsPassed;
  }

  public void setFloorsPassed(int floorsPassed) {
    this.floorsPassed = floorsPassed;
  }

  private int floorsPassed = 0;
      

  public int getDestinationFloor() {
    return destinationFloor;
  }

  public void setDestinationFloor(int destinationFloor) {
    this.destinationFloor = destinationFloor;
  }

  public boolean isMovingUp() {
    return movingUp;
  }

  public void setMovingUp(boolean movingUp) {
    this.movingUp = movingUp;
  }

  public boolean isOccupied() {
    return occupied;
  }

  public void setOccupied(boolean occupied) {
    this.occupied = occupied;
  }

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
