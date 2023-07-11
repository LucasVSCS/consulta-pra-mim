package com.br.consultapramim.application.domains.dtos;

import com.br.consultapramim.application.domains.Phone;

import java.io.Serial;
import java.io.Serializable;

public class PhoneDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String areaCode;
    private String number;
    private boolean isWhatsapp;

    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone) {
        this.areaCode = phone.getAreaCode();
        this.number = phone.getNumber();
        this.isWhatsapp = phone.isWhatsapp();
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
}
