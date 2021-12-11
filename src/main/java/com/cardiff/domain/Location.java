
package com.cardiff.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

public class Location {

    private LatLng latLng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
