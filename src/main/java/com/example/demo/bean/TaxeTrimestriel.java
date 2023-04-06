package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TaxeTrimestriel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateDePresentation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateApplication;

    private int annee;
    private int trimestre;
    private int nombreDeMoisRetard;
    private double nombreDeNuite;
    private double montantBase;
    private double montantRetard;
    private double montantMajoration;
    private double montantTotal;
    @ManyToOne
    private Locale locale;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private CategorieLocale categorieLocale;
    @ManyToOne
    private TauxTaxeTrimestriel tauxTaxeTrimestriel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDePresentation() {
        return dateDePresentation;
    }

    public void setDateDePresentation(LocalDateTime dateDePresentation) {
        this.dateDePresentation = dateDePresentation;
    }

    public LocalDateTime getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(LocalDateTime dateApplication) {
        this.dateApplication = dateApplication;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getNombreDeMoisRetard() {
        return nombreDeMoisRetard;
    }

    public void setNombreDeMoisRetard(int nombreDeMoisRetard) {
        this.nombreDeMoisRetard = nombreDeMoisRetard;
    }

    public double getNombreDeNuite() {
        return nombreDeNuite;
    }

    public void setNombreDeNuite(double nombreDeNuite) {
        this.nombreDeNuite = nombreDeNuite;
    }

    public double getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
    }

    public double getMontantRetard() {
        return montantRetard;
    }

    public void setMontantRetard(double montantRetard) {
        this.montantRetard = montantRetard;
    }

    public double getMontantMajoration() {
        return montantMajoration;
    }

    public void setMontantMajoration(double montantMajoration) {
        this.montantMajoration = montantMajoration;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public CategorieLocale getCategorieLocale() {
        return categorieLocale;
    }

    public void setCategorieLocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    public TauxTaxeTrimestriel getTauxTaxeTrimestriel() {
        return tauxTaxeTrimestriel;
    }

    public void setTauxTaxeTrimestriel(TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        this.tauxTaxeTrimestriel = tauxTaxeTrimestriel;
    }
}
