package com.example.demo.bean;


import javax.persistence.*;

@Entity
public class NotificationLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int numero;
    private int trimestre;
    private Double mantantEstimation;
    @ManyToOne
    private Locale locale;
    @ManyToOne
    private Redevable redevable;




    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public Double getMantantEstimation() {
        return mantantEstimation;
    }

    public void setMantantEstimation(Double mantantEstimation) {
        this.mantantEstimation = mantantEstimation;
    }
}
