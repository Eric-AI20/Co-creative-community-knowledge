package com.cardiff.service.iface;

import com.cardiff.entity.Location;

import java.util.List;

public interface ILocationService {
    List<Location> findAllLocationsForMap();
}
