package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.model.Location;
import de.tum.hack.secretsanta.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    Location randomLocation() {
        return locationService.findLocationInMunich();
    }

    @GetMapping("/photo/{photoReference}")
    byte[] locationImage(@PathVariable String photoReference) {
        return locationService.getPhotoData(photoReference);
    }
}
