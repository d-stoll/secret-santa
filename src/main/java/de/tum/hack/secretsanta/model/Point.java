package de.tum.hack.secretsanta.model;

import javax.persistence.*;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String title;
    private Float longitude;
    private Float latitude;
    private String description;
    private String photoUrl;
    private String photoCredit;
    private String urlWebsite;

    protected Point() {}

    public Point(String type, String title, Float longitude, Float latitude, String description, String photoUrl,
                 String photoCredit, String urlWebsite) {
        this.type = type;
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.photoUrl = photoUrl;
        this.photoCredit = photoCredit;
        this.urlWebsite = urlWebsite;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhotoCredit() {
        return photoCredit;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }
}
