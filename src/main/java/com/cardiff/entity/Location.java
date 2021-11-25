package com.cardiff.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "locations")
public class Location extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 9, scale = 3)
    private BigDecimal latitude;

    @Column(precision = 9, scale = 3)
    private BigDecimal longitude;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }




}

