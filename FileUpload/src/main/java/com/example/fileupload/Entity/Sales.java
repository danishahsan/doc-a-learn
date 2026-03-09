package com.example.fileupload.Entity;

import com.example.fileupload.Util.Items;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Sales {

    String region;
    String rep;

    Items item;
    Integer units;

    Double cost;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Double getUnitCost() {
        return cost;
    }

    public void setUnitCost(Double unitCost) {
        this.cost = unitCost;
    }
}
