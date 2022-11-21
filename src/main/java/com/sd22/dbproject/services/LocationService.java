package com.sd22.dbproject.services;

import com.sd22.dbproject.entities.Location;
import com.sd22.dbproject.repositories.LocationRepository;
import com.sd22.dbproject.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Location addLocation(Location location) {
       return locationRepository.save(location);
    }

    public Location findLocationById(int id) {
        return locationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }
    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }
}
