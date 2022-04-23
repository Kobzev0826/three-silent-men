package com.accumulator.three.silent.men;

public class GasStation {
    private String address;
    private String latitude;
    private String longtitude;
    private String name;
    private String country;
    private String phone;
    private String region;

    public GasStation() {
    }

    public GasStation(String address, String latitude, String longtitude, String name, String country, String phone, String region) {
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longtitude='" + longtitude + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
