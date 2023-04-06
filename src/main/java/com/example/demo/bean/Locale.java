package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToOne
    private Rue rue;
    private int derniereAnneePaye;
    private int dernierTrimestrePaye;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private CategorieLocale categorieLocale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }


    public void setAnnee(int annee) {
        annee = annee;
    }

    public Rue getRue() {
        return rue;
    }

    public void setRue(Rue rue) {
        this.rue = rue;
    }

    public int getDerniereAnneePaye() {
        return derniereAnneePaye;
    }

    public void setDerniereAnneePaye(int derniereAnneePaye) {
        this.derniereAnneePaye = derniereAnneePaye;
    }

    public int getDernierTrimestrePaye() {
        return dernierTrimestrePaye;
    }

    public void setDernierTrimestrePaye(int dernierTrimestrePaye) {
        this.dernierTrimestrePaye = dernierTrimestrePaye;
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
}
