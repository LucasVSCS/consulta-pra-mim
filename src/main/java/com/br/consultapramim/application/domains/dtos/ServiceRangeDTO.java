package com.br.consultapramim.application.domains.dtos;

import java.io.Serial;
import java.io.Serializable;

public class ServiceRangeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer searchRadius;
    private Integer yearMin;
    private Integer yearMax;
    private Double priceMin;
    private Double priceMax;
    private boolean brandNew;

    public Integer getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(Integer searchRadius) {
        this.searchRadius = searchRadius;
    }

    public Integer getYearMin() {
        return yearMin;
    }

    public void setYearMin(Integer yearMin) {
        this.yearMin = yearMin;
    }

    public Integer getYearMax() {
        return yearMax;
    }

    public void setYearMax(Integer yearMax) {
        this.yearMax = yearMax;
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Double priceMin) {
        this.priceMin = priceMin;
    }

    public Double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Double priceMax) {
        this.priceMax = priceMax;
    }

    public boolean getBrandNew() {
        return brandNew;
    }

    public void setBrandNew(boolean brandNew) {
        this.brandNew = brandNew;
    }
}
