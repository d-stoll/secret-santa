package de.tum.hack.secretsanta.service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import de.tum.hack.secretsanta.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

@Service
public class LocationService {

    private final GeoApiContext context;
    private static final LatLng MUNICH_LAT_LNG = new LatLng(48.137154, 11.576124);

    public LocationService(@Value("${GOOGLE_MAPS_API_KEY}") java.lang.String googleMapsApiKey) {
        this.context = new GeoApiContext.Builder()
                .apiKey(googleMapsApiKey)
                .build();
    }

    public Location findLocationInMunich() {
        try {
            var searchResults = PlacesApi.textSearchQuery(context, "points of interest",
                            MUNICH_LAT_LNG)
                    .radius(15000)
                    .await()
                    .results;
            Random r = new Random();
            var placeResult = searchResults[r.nextInt(searchResults.length)];

            String serverAddress = InetAddress.getLoopbackAddress().getHostAddress();
            String serverPort = InetAddress.getLoopbackAddress().getHostName();

            var photoUrl =  serverAddress + serverPort + "/photo/" + placeResult.photos[0].photoReference;

            return new Location(placeResult.name, placeResult.formattedAddress, photoUrl);
        } catch(IOException | InterruptedException | ApiException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public byte[] getPhotoData(java.lang.String photoReference) {
        try {
            return PlacesApi.photo(context, photoReference)
                    .maxHeight(700)
                    .maxWidth(1000)
                    .await().imageData;
        } catch(IOException | InterruptedException | ApiException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
