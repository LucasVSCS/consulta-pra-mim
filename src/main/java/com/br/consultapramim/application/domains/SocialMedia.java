package com.br.consultapramim.application.domains;

import com.br.consultapramim.application.domains.dtos.SocialMediaDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "social_media")
public class SocialMedia implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_hunter_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "car_hunter_id")
    private CarHunter carHunter;
    @Column(name = "facebook_url")
    private String facebookUrl;
    @Column(name = "instagram_url")
    private String instagramUrl;

    public SocialMedia(SocialMediaDTO socialMedia, CarHunter carHunter) {
        this.facebookUrl = socialMedia.getFacebookUrl();
        this.instagramUrl = socialMedia.getInstagramUrl();
        this.carHunter = carHunter;
    }

    public SocialMedia() {
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
