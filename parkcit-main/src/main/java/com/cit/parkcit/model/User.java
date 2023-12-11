package com.cit.parkcit.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Temporal(TemporalType.DATE)
    private Date userBirthDate;

    @Temporal(TemporalType.DATE)
    private Date userJoinedDate;

    private String userFName;
    private String userLName;
    private boolean hasMiddleName;
    private String userMName;
    private String stickerGeneratedID;

    @ManyToMany
    @JoinTable(
        name = "user_vehicle",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "userTypeID")
    private UserType userType;

    // Constructors, getters, and setters

    public User() {
    }

    public User(UserType userType, Date userBirthDate, Date userJoinedDate, String userFName, String userLName, boolean hasMiddleName, String userMName, String stickerGeneratedID) {
        this.userBirthDate = userBirthDate;
        this.userJoinedDate = userJoinedDate;
        this.userFName = userFName;
        this.userLName = userLName;
        this.hasMiddleName = hasMiddleName;
        this.userMName = userMName;
        this.userType = userType;
        this.stickerGeneratedID = stickerGeneratedID;
    }

    // Getters and setters...

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Date getUserJoinedDate() {
        return userJoinedDate;
    }

    public void setUserJoinedDate(Date userJoinedDate) {
        this.userJoinedDate = userJoinedDate;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public boolean isHasMiddleName() {
        return hasMiddleName;
    }

    public void setHasMiddleName(boolean hasMiddleName) {
        this.hasMiddleName = hasMiddleName;
    }

    public String getUserMName() {
        return userMName;
    }

    public void setUserMName(String userMName) {
        this.userMName = userMName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * @return String return the stickerGeneratedID
     */
    public String getStickerGeneratedID() {
        return stickerGeneratedID;
    }

    /**
     * @param stickerGeneratedID the stickerGeneratedID to set
     */
    public void setStickerGeneratedID(String stickerGeneratedID) {
        this.stickerGeneratedID = stickerGeneratedID;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
