package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PhotoController {
    private final LocationService locationService;

    public PhotoController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/photo/{photoReference}")
    @ResponseBody
    byte[] locationImage(@PathVariable String photoReference) {
        return locationService.getPhotoData(photoReference);
    }

}
