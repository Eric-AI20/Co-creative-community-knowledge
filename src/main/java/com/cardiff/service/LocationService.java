package com.cardiff.service;

import com.cardiff.entity.Location;
import com.cardiff.repository.LocationRepository;
import com.cardiff.service.iface.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    private LocationRepository locationRepository;

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAllLocationsForMap() {
        List<Location> all = locationRepository.findAll();
        if (all == null)
            System.out.printf("NUll");
        else
            System.out.printf("" + all.size());
        return all;
    }
}
