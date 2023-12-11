package com.cit.parkcit.repository;

import org.springframework.data.repository.CrudRepository;

import com.cit.parkcit.model.ParkingSlot;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, Integer> {

}