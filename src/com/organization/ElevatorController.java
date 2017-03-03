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
   *          Elevator can request any floor
   */
  public void moveToFloor(Elevator elevator, int floor) {
    // In the case where we used a moving occupied elevator we'll need a way to
    // resume to original destination
    // haven't figured that out yet.

    // Requested floor must not exceed max floor or be less than bottom floor.
    if (floor > maxFloor) {
      floor = maxFloor;
    }

    if (floor < MIN_FLOOR) {
      floor = MIN_FLOOR;
    }

    int currentFloor = elevator.getCurrentFloor();

    // Report current floor as elevator moves
    while (currentFloor <= floor) {
      System.out.println("Elevator " + elevator.getElevatorId() + " Floor: " + currentFloor);
      currentFloor++;
      // Set the floors passed by this car
      elevator.setFloorsPassed(elevator.getFloorsPassed() + 1);
    }

    elevator.setCurrentFloor(floor);

    // Set the number or trips for this car
    elevator.setTrips(elevator.getTrips() + 1);
    // Check to see if the car is due for maintenance
    if (elevator.getTrips() >= 100) {
      elevator.setInMaintenanceMode(true);
      // we can either always check for maintenance mode when selecting best
      // elevator or remove it
      // from the array and provide a way to reintroduce it.
    }
  }

  /**
   * @param floor
   * @return Elevator Uses the position of all elevators in comparison to
   *         current floor to find nearest.
   */
  public Elevator getClosestElevator(int floor) {
    // I don't like this method because it is doing too many iterations and
    // returning in multiple places
    // but I don't have time to refactor it now.

    // I'm making a copy of the arraylist so I can work with an array that has
    // cars in maintenance removed
    ArrayList<Elevator> activeElevators = new ArrayList<>();
    for (Elevator elevator : elevators) {
      if (!elevator.isInMaintenanceMode()) {
        activeElevators.add(elevator);
      }
    }
    Elevator closestElevator = null;
    int diff = 0;
    while (null == closestElevator) {
      for (Elevator elevator : activeElevators) {
        if (elevator.getCurrentFloor() == floor) {
          return elevator;
        }
      }
      for (Elevator elevator : activeElevators) {
        if (elevator.isOccupied() && elevator.isMovingUp() && elevator.getDestinationFloor() > floor) {
          return elevator;
        } else if (elevator.isOccupied() && !elevator.isMovingUp() && elevator.getDestinationFloor() < floor) {
          return elevator;
        }
      }

      for (Elevator elevator : activeElevators) {
        if (elevator.isOccupied()) {
          continue;
        }
        if (getFloorDiff(floor, elevator.getCurrentFloor()) < diff) {
          diff = getFloorDiff(floor, elevator.getCurrentFloor());
          closestElevator = elevator;
        }
      }
    }
    return closestElevator;
  }

  private int getFloorDiff(int pos1, int pos2) {
    // some logic to tell me the diff between 2 floors
    return Math.abs(pos1 - pos2);
  }

  /**
   * @param elevator
   */
  public void openDoor(Elevator elevator) {
    // Set and report door status
    elevator.setDoorOpen(true);
    System.out.println("Elevator " + elevator.getElevatorId() + " door is open");
  }

  /**
   * @param elevator
   */
  public void closeDoor(Elevator elevator) {
    // Set and report door status
    elevator.setDoorOpen(false);
    System.out.println("Elevator " + elevator.getElevatorId() + " door is open");
  }
}
