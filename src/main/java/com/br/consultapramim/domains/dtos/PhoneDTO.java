package com.br.consultapramim.domains.dtos;

import com.br.consultapramim.domains.Phone;

import java.io.Serial;
import java.io.Serializable;

public class PhoneDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String areaCode;
    private String number;
    private Boolean isWhatsapp;

    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone) {
        this.areaCode = phone.getAreaCode();
        this.number = phone.getNumber();
        this.isWhatsapp = phone.getWhatsapp();
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
}