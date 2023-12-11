package com.cit.parkcit.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleID;

    private String vehicleType;
    private String vehiclePlateNo;
    private String vehicleName;
    private String vehicleColor;

    @ManyToMany(mappedBy = "vehicles")
    private Set<User> users = new HashSet<>();

    // Constructors, getters, and setters

    public Vehicle() {
    }

    public Vehicle(String vehicleType, String vehiclePlateNo, String vehicleName, String vehicleColor) {
        this.vehicleType = vehicleType;
        this.vehiclePlateNo = vehiclePlateNo;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
    }

    // Getters and setters...

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }

    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
