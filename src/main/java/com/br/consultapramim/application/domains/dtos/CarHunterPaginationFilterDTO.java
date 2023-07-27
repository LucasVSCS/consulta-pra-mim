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
}
