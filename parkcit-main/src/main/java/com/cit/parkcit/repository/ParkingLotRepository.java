package com.cit.parkcit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cit.parkcit.model.ParkingLot;
import com.cit.parkcit.model.ParkingSlot;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {
    @Query(value = "SELECT ps FROM ParkingSlot ps " +
            "JOIN ps.parkingLot pl " +
            "WHERE ps.isAvailable = true AND pl.parkingLotID = :parkingLotID")
    List<ParkingSlot> availableParkingSlots(@Param("parkingLotID") int parkingLotID);
}

