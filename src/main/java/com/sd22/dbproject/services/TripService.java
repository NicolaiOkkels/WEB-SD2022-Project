package com.sd22.dbproject.services;

import com.sd22.dbproject.entities.Location;
import com.sd22.dbproject.entities.Trip;
import com.sd22.dbproject.repositories.TripRepository;
import com.sd22.dbproject.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    public Trip addTrip(Trip trip) {
       return tripRepository.save(trip);
    }

    public Trip findTripById(int id) {
        return tripRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteTripById(int id) {
        tripRepository.deleteById(id);
    }

    public Trip updateTrip(Trip trip){
        return tripRepository.save(trip);
    }
}
