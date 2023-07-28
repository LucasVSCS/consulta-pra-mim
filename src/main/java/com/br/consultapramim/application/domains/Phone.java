package com.br.consultapramim.application.domains;

import com.br.consultapramim.application.domains.dtos.PhoneDTO;
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
    private boolean isWhatsapp;
    @ManyToOne
    @JoinColumn(name = "car_hunter_id", nullable = false)
    private CarHunter carHunter;

    public Phone(PhoneDTO phone) {
        this.areaCode = phone.getAreaCode();
        this.number = phone.getNumber();
        this.isWhatsapp = phone.getIsWhatsapp();
    }

    public Phone(PhoneDTO phone, CarHunter carHunter) {
        this.areaCode = phone.getAreaCode();
        this.number = phone.getNumber();
        this.isWhatsapp = phone.getIsWhatsapp();
        this.carHunter = carHunter;
    }

    public Phone() {

    }

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

    public boolean isWhatsapp() {
        return isWhatsapp;
    }

    public void setIsWhatsapp(boolean whatsapp) {
        isWhatsapp = whatsapp;
    }

    public CarHunter getCarHunter() {
        return carHunter;
    }

    public void setCarHunter(CarHunter carHunter) {
        this.carHunter = carHunter;
    }
}
