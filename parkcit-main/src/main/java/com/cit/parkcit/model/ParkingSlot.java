package com.cit.parkcit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_slot")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parkingSlotID;

    @ManyToOne
    @JoinColumn(name = "parking_lotid", nullable = false)
    private ParkingLot parkingLot;

    @JsonProperty("isEmployee")
    private boolean isEmployee;
    
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    // Constructors, getters, and setters

    public ParkingSlot() {
    }

    public ParkingSlot(ParkingLot parkingLot, boolean isEmployee, boolean isAvailable) {
        this.parkingLot = parkingLot;
        this.isEmployee = isEmployee;
        this.isAvailable = isAvailable;
    }

    // Getters and setters

    public int getParkingSlotID() {
        return parkingSlotID;
    }

    public void setParkingSlotID(int parkingSlotID) {
        this.parkingSlotID = parkingSlotID;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
