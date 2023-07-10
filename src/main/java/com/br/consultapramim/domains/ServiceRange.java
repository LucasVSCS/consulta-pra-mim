package com.br.consultapramim.domains;

import com.br.consultapramim.domains.dtos.ServiceRangeDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "service_range")
public class ServiceRange implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_hunter_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "car_hunter_id")
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
    private boolean brandNew;

    public ServiceRange(ServiceRangeDTO serviceRange, CarHunter carHunter) {
        this.searchRadius = serviceRange.getSearchRadius();
        this.yearMin = serviceRange.getYearMin();
        this.yearMax = serviceRange.getYearMax();
        this.priceMin = serviceRange.getPriceMin();
        this.priceMax = serviceRange.getPriceMax();
        this.brandNew = serviceRange.getBrandNew();
        this.carHunter = carHunter;
    }

    public ServiceRange() {

    }

    public ServiceRange(ServiceRangeDTO serviceRange) {
        this.searchRadius = serviceRange.getSearchRadius();
        this.yearMin = serviceRange.getYearMin();
        this.yearMax = serviceRange.getYearMax();
        this.priceMin = serviceRange.getPriceMin();
        this.priceMax = serviceRange.getPriceMax();
        this.brandNew = serviceRange.getBrandNew();
    }

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

    public boolean getBrandNew() {
        return brandNew;
    }

    public void setBrandNew(boolean brandNew) {
        this.brandNew = brandNew;
    }
}
