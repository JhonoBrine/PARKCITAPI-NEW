package com.cit.parkcit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parkingLotID;

    private String parkingLotName;
    private int parkingSlotTotal;
    private int parkingSlotAvailable;

    // Constructors, getters, and setters

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotName, int parkingSlotTotal, int parkingSlotAvailable) {
        this.parkingLotName = parkingLotName;
        this.parkingSlotTotal = parkingSlotTotal;
        this.parkingSlotAvailable = parkingSlotAvailable;
    }

    // Getters and setters

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getParkingSlotTotal() {
        return parkingSlotTotal;
    }

    public void setParkingSlotTotal(int parkingSlotTotal) {
        this.parkingSlotTotal = parkingSlotTotal;
    }

    public int getParkingSlotAvailable() {
        return parkingSlotAvailable;
    }

    public void setParkingSlotAvailable(int parkingSlotAvailable) {
        this.parkingSlotAvailable = parkingSlotAvailable;
    }
}
