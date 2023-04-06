package com.example.demo.bean;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TauxTaxeAnuelle {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String reference;
    private LocalDateTime dateApplicationDebut;
    private LocalDateTime dateApplicationFin;
    private double pourcentageRetardAnnuelle;
    private double pourcentageMajorationAnnuelle;

    @ManyToOne
    private CategorieLocale categorieLocale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDateApplicationDebut() {
        return dateApplicationDebut;
    }

    public void setDateApplicationDebut(LocalDateTime dateApplicationDebut) {
        this.dateApplicationDebut = dateApplicationDebut;
    }

    public LocalDateTime getDateApplicationFin() {
        return dateApplicationFin;
    }

    public void setDateApplicationFin(LocalDateTime dateApplicationFin) {
        this.dateApplicationFin = dateApplicationFin;
    }

    public double getPourcentageRetardAnnuelle() {
        return pourcentageRetardAnnuelle;
    }

    public void setPourcentageRetardAnnuelle(double pourcentageRetardAnnuelle) {
        this.pourcentageRetardAnnuelle = pourcentageRetardAnnuelle;
    }

    public double getPourcentageMajorationAnnuelle() {
        return pourcentageMajorationAnnuelle;
    }

    public void setPourcentageMajorationAnnuelle(double pourcentageMajorationAnnuelle) {
        this.pourcentageMajorationAnnuelle = pourcentageMajorationAnnuelle;
    }

    public CategorieLocale getCategorieLocale() {
        return categorieLocale;
    }

    public void setCategorieLocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }
}