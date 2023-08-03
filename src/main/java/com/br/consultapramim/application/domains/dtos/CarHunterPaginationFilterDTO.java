package com.br.consultapramim.application.domains.dtos;

import java.io.Serial;
import java.io.Serializable;

public class CarHunterPaginationFilterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String tradingName;
    private Integer status;
    private Long cityId;
    private String serviceDescription;
    private Integer searchRadius;
    private Integer yearMin;
    private Integer yearMax;
    private Double priceMin;
    private Double priceMax;
    private Integer brandNew;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
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

    public Integer getBrandNew() {
        return brandNew;
    }

    public void setBrandNew(Integer brandNew) {
        this.brandNew = brandNew;
    }
}
