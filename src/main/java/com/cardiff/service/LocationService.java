package com.cardiff.service;

import com.cardiff.domain.LatLng;
import com.cardiff.domain.LocationResponse;
import com.cardiff.entity.Location;
import com.cardiff.entity.Project;
import com.cardiff.repository.LocationRepository;
import com.cardiff.service.iface.ILocationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LocationService implements ILocationService {
    private LocationRepository locationRepository;

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAllLocationsForMap() {

        return populateProjectDescriptionForMap(locationRepository.findAll());
    }


    @Override
    public LatLng getCoordinatesForAddress(String address) {
        LatLng latLng = null;
        try {
            address.replace(" ", "%20");
            String url = "https://open.mapquestapi.com/geocoding/v1/address?key=GeVVrZ56KA0LHyOdR7jj9t8YAoeWstCd&location=" + address;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<LocationResponse> request = new HttpEntity<>(httpHeaders);

            ResponseEntity<LocationResponse> response = restTemplate
                    .exchange(url, HttpMethod.GET, request, LocationResponse.class);
            LocationResponse body = response.getBody();

            Gson gson = new Gson();
            System.out.println(gson.toJson(response));
            AtomicReference<String> mapUri = new AtomicReference<>();
            Optional<LatLng> location = body.getResults().stream().map(result -> {
                mapUri.set(result.getLocations().get(0).getMapUrl());
                return result.getLocations().get(0).getLatLng();
            }).findAny();

            if (location.isPresent()) {
                location.get().setMapUrl(mapUri.get());
                latLng = location.get();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLng;
    }


    private List<Location> populateProjectDescriptionForMap(List<Location> locations) {

        locations.stream().forEach(location -> {
            if (location.getProjectId() != null) {
                Project projectById = projectService.getProjectById(location.getProjectId());
                location.setProjectDescription(projectById.getDescription());
            }
        });
        System.out.println(new Gson().toJson(locations));
        return locations;
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }
}
