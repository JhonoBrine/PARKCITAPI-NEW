package com.cit.parkcit.controller;

import com.cit.parkcit.model.Vehicle;
import com.cit.parkcit.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }


    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer vehicleId) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        return optionalVehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer vehicleId, @RequestBody Vehicle vehicle) {
        if (!vehicleRepository.existsById(vehicleId)) {
            return ResponseEntity.notFound().build();
        }
        vehicle.setVehicleID(vehicleId);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer vehicleId) {
        if (!vehicleRepository.existsById(vehicleId)) {
            return ResponseEntity.notFound().build();
        }
        vehicleRepository.deleteById(vehicleId);
        return ResponseEntity.noContent().build();
    }
}
