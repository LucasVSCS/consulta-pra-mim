package com.br.consultapramim.application.domains;

import com.br.consultapramim.application.domains.dtos.CarHunterInsertDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "car_hunter")
public class CarHunter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_car_hunter")
    @SequenceGenerator(name = "sq_car_hunter", sequenceName = "sq_car_hunter", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "trading_name", nullable = false)
    private String tradingName;
    @Column(name = "email")
    private String email;
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "service_description", columnDefinition = "TEXT")
    private String serviceDescription;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "external_id", insertable = false, updatable = false, unique = true)
    private UUID externalId;
    @OneToOne(mappedBy = "carHunter", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SocialMedia socialMedia;
    @OneToOne(mappedBy = "carHunter", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ServiceRange serviceRange;
    @OneToMany(mappedBy = "carHunter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id")
    private City city;

    public CarHunter(CarHunterInsertDTO carHunter) {
        this.name = carHunter.getName();
        this.tradingName = carHunter.getTradingName();
        this.email = carHunter.getEmail();
        this.serviceDescription = carHunter.getServiceDescription();
        this.isActive = false;
    }

    public CarHunter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public ServiceRange getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(ServiceRange serviceRange) {
        this.serviceRange = serviceRange;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
