package de.tum.hack.secretsanta.model;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String googleMapsPlaceId;
    private String googleMapsPhotoReference;

    protected Location() {}

    public Location(String googleMapsPlaceId, String googleMapsPhotoReference) {
        this.googleMapsPlaceId = googleMapsPlaceId;
        this.googleMapsPhotoReference = googleMapsPhotoReference;
    }

    public String getGoogleMapsPlaceId() {
        return googleMapsPlaceId;
    }

    public String getGoogleMapsPhotoReference() {
        return googleMapsPhotoReference;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", googleMapsPlaceId='" + googleMapsPlaceId + '\'' +
                ", googleMapsPhotoReference='" + googleMapsPhotoReference + '\'' +
                '}';
    }
}
