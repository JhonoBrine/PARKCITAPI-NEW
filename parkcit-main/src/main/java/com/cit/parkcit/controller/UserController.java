package com.cit.parkcit.controller;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cit.parkcit.model.User;
import com.cit.parkcit.model.Vehicle;
import com.cit.parkcit.model.UserType;
import com.cit.parkcit.repository.UserRepository;
import com.cit.parkcit.repository.VehicleRepository;
import com.cit.parkcit.repository.UserTypeRepository;
import com.cit.parkcit.lib.Common;
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
	private final VehicleRepository vehicleRepository;

    @Autowired
    public UserController(UserRepository userRepository, VehicleRepository vehicleRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
		this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        usersIterable.forEach(userList::add);
        return userList;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setStickerGeneratedID(Common.getRandomId(10));
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        if (!userRepository.existsById(userId)) {
            return ResponseEntity.notFound().build();
        }
        user.setUserID(userId);
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        if (!userRepository.existsById(userId)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/vehicle")
	public ResponseEntity<Set<Vehicle>> getVehiclesByUserId(@PathVariable Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);

		return optionalUser.map(user -> ResponseEntity.ok(user.getVehicles()))
						.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/{userId}/add-vehicle")
    public ResponseEntity<User> addVehicleToUser(@PathVariable Integer userId, @RequestBody Vehicle vehicle) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Save the vehicle before associating
            Vehicle savedVehicle = vehicleRepository.save(vehicle);

            // Now associate the saved vehicle with the user
            user.getVehicles().add(savedVehicle);

            // Update the user in the database
            User updatedUser = userRepository.save(user);

            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}/set-user-type/{userTypeId}")
    public ResponseEntity<User> setUserTypeForUser(@PathVariable Integer userId, @PathVariable Integer userTypeId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<UserType> optionalUserType = userTypeRepository.findById(userTypeId);

        if (optionalUser.isPresent() && optionalUserType.isPresent()) {
            User user = optionalUser.get();
            UserType userType = optionalUserType.get();

            // Set UserType for the user
            user.setUserType(userType);

            // Save the updated user (this will perform an update)
            User updatedUser = userRepository.save(user);

            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
