package com.br.consultapramim.domains;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="city")
public class City implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "city_sequence", sequenceName = "sq_city", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ibge_code", nullable = false)
    private String ibgeCode;

    @Column(name = "uf_code", nullable = false)
    private String ufCode;

    @Column(name = "slug", nullable = false)
    private String slug;

    public City(Long id, String name, String ibgeCode, String ufCode, String slug) {
        this.id = id;
        this.name = name;
        this.ibgeCode = ibgeCode;
        this.ufCode = ufCode;
        this.slug = slug;
    }

    public City() {

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

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getUfCode() {
        return ufCode;
    }

    public void setUfCode(String ufCode) {
        this.ufCode = ufCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
