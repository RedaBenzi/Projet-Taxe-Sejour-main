package com.example.demo.bean;


import javax.persistence.*;

@Entity
public class Quartiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double code;
    private String labelle;
    @ManyToOne
    private Secteur secteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
