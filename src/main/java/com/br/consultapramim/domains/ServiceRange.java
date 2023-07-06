package com.br.consultapramim.domains;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "service_range")
public class ServiceRange implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    private CarHunter carHunter;
    @Column(name = "search_radius")
    private Integer searchRadius;
    @Column(name = "year_min")
    private Integer yearMin;
    @Column(name = "year_max")
    private Integer yearMax;
    @Column(name = "price_min")
    private Double priceMin;
    @Column(name = "price_max")
    private Double priceMax;
    @Column(name = "brand_new")
    private Boolean brandNew;

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

    public CarHunter getCarHunter() {
        return carHunter;
    }

    public void setCarHunter(CarHunter carHunter) {
        this.carHunter = carHunter;
    }

    public Boolean getBrandNew() {
        return brandNew;
    }

    public void setBrandNew(Boolean brandNew) {
        this.brandNew = brandNew;
    }
}
