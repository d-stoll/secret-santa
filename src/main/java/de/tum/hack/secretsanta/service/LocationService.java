package de.tum.hack.secretsanta.service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.RankBy;
import de.tum.hack.secretsanta.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Random;

@Service
public class LocationService {

    private final GeoApiContext context;

    private static final LatLng MUNICH_LAT_LNG = new LatLng(48.137154, 11.576124);
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class.getName());


    public LocationService(@Value("${GOOGLE_MAPS_API_KEY}") String googleMapsApiKey) {
        this.context = new GeoApiContext.Builder()
                .apiKey(googleMapsApiKey)
                .build();
    }

    public Location findLocationInMunich() {
        try {
            var searchResults = PlacesApi.nearbySearchQuery(context, MUNICH_LAT_LNG)
                    .rankby(RankBy.PROMINENCE)
                    .await()
                    .results;
            Random r = new Random();
            var placeResult = searchResults[r.nextInt(searchResults.length)];

            return new Location(placeResult.placeId, placeResult.photos[0].photoReference);
        } catch(IOException | InterruptedException | ApiException ex) {
            LOGGER.error(ex.toString());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
