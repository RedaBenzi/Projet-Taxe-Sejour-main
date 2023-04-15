package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class TaxeAnuelle {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int annee;
    private double montantBaseAnuelle;
    private double montantRetardAnuelle;
    private double montantMajorationAnuelle;
    private double  montantTotalAnuelle;
    @ManyToOne
    private TauxTaxeAnuelle  tauxTaxeAnuelle;


    public TauxTaxeAnuelle getTauxTaxeAnuelle() {
        return tauxTaxeAnuelle;
    }

    public void setTauxTaxeAnuelle(TauxTaxeAnuelle tauxTaxeAnuelle) {
        this.tauxTaxeAnuelle = tauxTaxeAnuelle;
    }

    public double getMontantBaseAnuelle() {
        return montantBaseAnuelle;
    }

    public void setMontantBaseAnuelle(double montantBaseAnuelle) {
        this.montantBaseAnuelle = montantBaseAnuelle;
    }

    public double getMontantRetardAnuelle() {
        return montantRetardAnuelle;
    }

    public void setMontantRetardAnuelle(double montantRetardAnuelle) {
        this.montantRetardAnuelle = montantRetardAnuelle;
    }

    public double getMontantMajorationAnuelle() {
        return montantMajorationAnuelle;
    }

    public void setMontantMajorationAnuelle(double montantMajorationAnuelle) {
        this.montantMajorationAnuelle = montantMajorationAnuelle;
    }

    public CategorieLocale getCategorieLocale() {
        return categorieLocale;
    }

    public void setCategorieLocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    @ManyToOne
    private Redevable redevable;

    @ManyToOne
    private CategorieLocale categorieLocale;

    @ManyToOne
    private Locale locale;

    public double getMontantTotalAnuelle() {
        return montantTotalAnuelle;
    }

    public void setMontantTotalAnuelle(double montantTotalAnuelle) {
        this.montantTotalAnuelle = montantTotalAnuelle;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        annee = annee;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public CategorieLocale getCategorieLocaleSejour() {
        return categorieLocale;
    }

    public void setCategorieLocaleSejour(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
