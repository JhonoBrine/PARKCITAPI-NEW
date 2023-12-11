package com.cit.parkcit.controller;

import com.cit.parkcit.model.ParkingLot;
import com.cit.parkcit.model.ParkingSlot;
import com.cit.parkcit.repository.ParkingLotRepository;
import com.cit.parkcit.service.ParkingLotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingLotService parkingLotService;

    // Get all parking lots
    @GetMapping
    public List<ParkingLot> getAllParkingLots() {
        return (List<ParkingLot>) parkingLotRepository.findAll();
    }

    // Get a specific parking lot by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParkingLot> getParkingLotById(@PathVariable("id") int id) {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(id);
        return optionalParkingLot.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new parking lot
    @PostMapping
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLot parkingLot) {
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);
        return ResponseEntity.ok(savedParkingLot);
    }

    // Update a parking lot
    @PutMapping("/{id}")
    public ResponseEntity<ParkingLot> updateParkingLot(@PathVariable("id") int id, @RequestBody ParkingLot updatedParkingLot) {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(id);

        if (optionalParkingLot.isPresent()) {
            ParkingLot existingParkingLot = optionalParkingLot.get();
            existingParkingLot.setParkingLotName(updatedParkingLot.getParkingLotName());
            existingParkingLot.setParkingSlotTotal(updatedParkingLot.getParkingSlotTotal());
            existingParkingLot.setParkingSlotAvailable(updatedParkingLot.getParkingSlotAvailable());

            ParkingLot savedParkingLot = parkingLotRepository.save(existingParkingLot);
            return ResponseEntity.ok(savedParkingLot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a parking lot
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingLot(@PathVariable("id") int id) {
        if (parkingLotRepository.existsById(id)) {
            parkingLotRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/available-slots/{id}")
    public ResponseEntity<List<ParkingSlot>> availableParkingSlots(@PathVariable("id") int parkingLotID) {
        List<ParkingSlot> availableSlots = parkingLotService.getAvailableParkingSlots(parkingLotID);

        if (availableSlots.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(availableSlots);
        }
    }



}
