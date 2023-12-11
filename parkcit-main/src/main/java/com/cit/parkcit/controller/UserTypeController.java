package com.cit.parkcit.controller;

import com.cit.parkcit.model.UserType;
import com.cit.parkcit.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-types")
public class UserTypeController {

    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeController(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    // Endpoint to get all user types
    @GetMapping
    public List<UserType> getAllUserTypes() {
        return (List<UserType>) userTypeRepository.findAll();
    }

    // Endpoint to get a user type by ID
    @GetMapping("/{userTypeId}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable Integer userTypeId) {
        Optional<UserType> optionalUserType = userTypeRepository.findById(userTypeId);
        return optionalUserType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to create a new user type
    @PostMapping
    public ResponseEntity<UserType> createUserType(@RequestBody UserType userType) {
        UserType savedUserType = userTypeRepository.save(userType);
        return ResponseEntity.ok(savedUserType);
    }

    // Endpoint to update an existing user type
    @PutMapping("/{userTypeId}")
    public ResponseEntity<UserType> updateUserType(@PathVariable int userTypeId, @RequestBody UserType userType) {
        if (!userTypeRepository.existsById(userTypeId)) {
            return ResponseEntity.notFound().build();
        }

        userType.setUserTypeID(userTypeId);
        UserType updatedUserType = userTypeRepository.save(userType);
        return ResponseEntity.ok(updatedUserType);
    }

    // Endpoint to delete a user type by ID
    @DeleteMapping("/{userTypeId}")
    public ResponseEntity<Void> deleteUserType(@PathVariable int userTypeId) {
        if (!userTypeRepository.existsById(userTypeId)) {
            return ResponseEntity.notFound().build();
        }

        userTypeRepository.deleteById(userTypeId);
        return ResponseEntity.noContent().build();
    }
}
