package de.tum.hack.secretsanta.model;

public class Location {
    private final String name;
    private final String address;
    private final String photoUrl;

    public Location(String name, String address, String photoUrl) {
        this.name = name;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}