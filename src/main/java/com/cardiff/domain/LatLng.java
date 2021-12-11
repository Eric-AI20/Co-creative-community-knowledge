
package com.cardiff.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

public class LatLng {

    private Double lng;
    private Double lat;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
