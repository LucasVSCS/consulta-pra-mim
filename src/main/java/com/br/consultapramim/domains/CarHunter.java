package com.br.consultapramim.domains;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "car_hunter")
public class CarHunter  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_hunter_sequence", sequenceName = "sq_car_hunter")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "trading_name", nullable = false)
    private String tradingName;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "logo_url", nullable = true)
    private String logoUrl;

    @Column(name = "service_description", nullable = true)
    private String serviceDescription;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public CarHunter(Long id, String name, String tradingName, String email, String logoUrl, String serviceDescription, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.tradingName = tradingName;
        this.email = email;
        this.logoUrl = logoUrl;
        this.serviceDescription = serviceDescription;
        this.isActive = isActive;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
