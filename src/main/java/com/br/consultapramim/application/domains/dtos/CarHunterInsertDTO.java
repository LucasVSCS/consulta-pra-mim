package com.br.consultapramim.application.domains.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarHunterInsertDTO implements Serializable {
    @NotBlank(message = "Campo Nome obrigatório")
    private String name;
    @NotBlank(message = "Campo Nome da empresa obrigatório")
    private String tradingName;
    @Email
    @NotBlank(message = "Campo Email obrigatório")
    private String email;
    @NotNull(message = "Campo Cidade obrigatório")
    private Long cityId;
    @NotBlank(message = "Campo Descrição do Serviço obrigatório")
    private String serviceDescription;
    private List<PhoneDTO> phones = new ArrayList<>();
    private SocialMediaDTO socialMedia;
    private ServiceRangeDTO serviceRange;
    private Boolean isActive;
    private String logoImage;

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

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
}
