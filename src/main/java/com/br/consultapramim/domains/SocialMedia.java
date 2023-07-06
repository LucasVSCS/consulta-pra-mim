package com.br.consultapramim.domains;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "social_media")
public class SocialMedia implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    private CarHunter carHunter;
    @Column(name = "facebook_url")
    private String facebookUrl;
    @Column(name = "instagram_url")
    private String instagramUrl;

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public CarHunter getCarHunter() {
        return carHunter;
    }

    public void setCarHunter(CarHunter carHunter) {
        this.carHunter = carHunter;
    }
}
