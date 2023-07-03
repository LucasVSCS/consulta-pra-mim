package com.br.consultapramim.domains;

import jakarta.persistence.*;

@Entity(name = "social_media")
public class SocialMedia {
    @Id
    @Column(name = "car_hunter_id", nullable = false)
    private Long id;

    @Column(name = "facebook_url", nullable = true)
    private String facebookUrl;

    @Column(name = "instagram_url", nullable = true)
    private String instagramUrl;

    @OneToOne
    @MapsId
    @JoinColumn(name = "car_hunter_id")
    private CarHunter carHunter;

    public SocialMedia(Long id, String facebookUrl, String instagramUrl, CarHunter carHunter) {
        this.id = id;
        this.facebookUrl = facebookUrl;
        this.instagramUrl = instagramUrl;
        this.carHunter = carHunter;
    }

    public SocialMedia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
