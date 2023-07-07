package com.br.consultapramim.domains.dtos;

import java.io.Serial;
import java.io.Serializable;

public class CarHunterPaginationFilterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String tradingName;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
