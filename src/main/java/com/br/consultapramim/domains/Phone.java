package com.br.consultapramim.domains;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_phone")
    @SequenceGenerator(name = "sq_phone", sequenceName = "sq_phone", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "area_code", nullable = false)
    private String areaCode;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "is_whatsapp", nullable = false)
    private Boolean isWhatsapp;
    @ManyToOne
    @JoinColumn(name = "car_hunter_id", nullable = false)
    private CarHunter carHunter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getWhatsapp() {
        return isWhatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        isWhatsapp = whatsapp;
    }

    public CarHunter getCarHunter() {
        return carHunter;
    }

    public void setCarHunter(CarHunter carHunter) {
        this.carHunter = carHunter;
    }
}
