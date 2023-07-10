package com.br.consultapramim.domains.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarHunterInsertDTO implements Serializable {
    private String name;
    private String tradingName;
    private String email;
    private Long cityId;
    private List<PhoneDTO> phones = new ArrayList<>();
    private SocialMediaDTO socialMedia;
    private ServiceRangeDTO serviceRange;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public SocialMediaDTO getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMediaDTO socialMedia) {
        this.socialMedia = socialMedia;
    }

    public ServiceRangeDTO getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(ServiceRangeDTO serviceRange) {
        this.serviceRange = serviceRange;
    }
}
