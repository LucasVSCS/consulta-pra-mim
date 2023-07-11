package com.br.consultapramim.application.domains.dtos;

import java.io.Serial;
import java.io.Serializable;

public class CityDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String ufCode;

    public CityDTO(Long id, String name, String ufCode) {
        this.id = id;
        this.name = name;
        this.ufCode = ufCode;
    }

    public CityDTO() {
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

    public String getUfCode() {
        return ufCode;
    }

    public void setUfCode(String ufCode) {
        this.ufCode = ufCode;
    }
}
