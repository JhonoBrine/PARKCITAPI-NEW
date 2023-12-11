package com.cit.parkcit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.parkcit.repository.ParkingLotRepository;

import com.cit.parkcit.model.ParkingSlot;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingSlot> getAvailableParkingSlots(int parkingLotID) {
        List<ParkingSlot> result = parkingLotRepository.availableParkingSlots(parkingLotID);
        
        // Log the result
        result.forEach(System.out::println);

        return result;
    }
}
