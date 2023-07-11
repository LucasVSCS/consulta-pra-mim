package com.br.consultapramim.application.domains.dtos;

import com.br.consultapramim.application.domains.CarHunter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarHunterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private UUID externalId;
    private String name;
    private String tradingName;
    private String email;
    private String logoUrl;
    private String serviceDescription;
    private SocialMediaDTO socialMedia = new SocialMediaDTO();
    private CityDTO city = new CityDTO();
    private List<PhoneDTO> phones = new ArrayList<>();
    private ServiceRangeDTO serviceRange = new ServiceRangeDTO();

    public CarHunterDTO(CarHunter carHunter) {
        // Dados do Consultor
        this.externalId = carHunter.getExternalId();
        this.name = carHunter.getName();
        this.tradingName = carHunter.getTradingName();
        this.email = carHunter.getEmail();
        this.logoUrl = carHunter.getLogoUrl();
        this.serviceDescription = carHunter.getServiceDescription();

        // Dados da cidade do Consultor
        this.city.setId(carHunter.getCity().getId());
        this.city.setName(carHunter.getCity().getName());
        this.city.setUfCode(carHunter.getCity().getUfCode());

        // Dados dos telefones do Consultor
        if (carHunter.getPhones() != null){
            carHunter.getPhones().forEach(phone -> {
                PhoneDTO phoneDTO = new PhoneDTO(phone);
                this.phones.add(phoneDTO);
            });
        }

        // Dados das redes sociais do Consultor
        if (carHunter.getSocialMedia() != null) {
            this.socialMedia.setFacebookUrl(carHunter.getSocialMedia().getFacebookUrl());
            this.socialMedia.setInstagramUrl(carHunter.getSocialMedia().getInstagramUrl());
        }

        // Dados do raio de atendimento do Consultor
        if (carHunter.getServiceRange() != null) {
            this.serviceRange.setSearchRadius(carHunter.getServiceRange().getSearchRadius());
            this.serviceRange.setYearMin(carHunter.getServiceRange().getYearMin());
            this.serviceRange.setYearMax(carHunter.getServiceRange().getYearMax());
            this.serviceRange.setPriceMin(carHunter.getServiceRange().getPriceMin());
            this.serviceRange.setPriceMax(carHunter.getServiceRange().getPriceMax());
            this.serviceRange.setBrandNew(carHunter.getServiceRange().getBrandNew());
        }
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public SocialMediaDTO getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMediaDTO socialMedia) {
        this.socialMedia = socialMedia;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public ServiceRangeDTO getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(ServiceRangeDTO serviceRange) {
        this.serviceRange = serviceRange;
    }
}
