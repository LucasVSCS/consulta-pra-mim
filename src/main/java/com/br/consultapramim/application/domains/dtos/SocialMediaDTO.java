package com.br.consultapramim.application.domains.dtos;

import java.io.Serial;
import java.io.Serializable;

public class SocialMediaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String facebookUrl;
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
}
