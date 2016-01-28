package com.focinfi.youzi.beans;

import javax.sql.StatementEvent;
import java.util.List;
import java.util.Map;

/**
 * Created by Antony on 16/1/22.
 */
public class TouristRegionBean {
    private String id;
    private String name;
    private String level;
    private int price;
    private String location;
    private String openTime;
    private Double longitude;
    private Double latitude;
    private String desc;
    private List<String> pictureUrls;
    private String voiceUrl;
    private String videoUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getDesc() {
        return desc;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public TouristRegionBean setId(String id) {
        this.id = id;
        return this;
    }

    public TouristRegionBean setName(String name) {
        this.name = name;
        return this;
    }

    public TouristRegionBean setLevel(String level) {
        this.level = level;
        return this;
    }

    public TouristRegionBean setPrice(int price) {
        this.price = price;
        return this;
    }

    public TouristRegionBean setLocation(String location) {
        this.location = location;
        return this;
    }

    public TouristRegionBean setOpenTime(String openTime) {
        this.openTime = openTime;
        return this;
    }

    public TouristRegionBean setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public TouristRegionBean setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public TouristRegionBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public TouristRegionBean setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
        return this;
    }

    public TouristRegionBean setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public TouristRegionBean setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
