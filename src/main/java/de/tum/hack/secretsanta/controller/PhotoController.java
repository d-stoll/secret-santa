package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.service.LocationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PhotoController {
    private final LocationService locationService;

    public PhotoController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/photo/{photoReference}.jpg", method = RequestMethod.GET,
        produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    byte[] locationImage(@PathVariable String photoReference) {
        return locationService.getImageData(photoReference);
    }

}
