package com.cit.parkcit.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTypeID")
    private int userTypeID;

    @Column(name = "userType")
    private String userType;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;

    public UserType(){}

    public UserType(String userType){
        this.userType = userType;
    }

    // Constructors, getters, setters, and other methods...

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // You can add additional methods or annotations as needed.
}
