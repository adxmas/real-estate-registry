package com.example.realestateregistry.entity;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String owner;
    private double size;
    private double marketValue;
    @Column(nullable = false)
    private String propertyType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", market value: " + this.marketValue;
    }
}
