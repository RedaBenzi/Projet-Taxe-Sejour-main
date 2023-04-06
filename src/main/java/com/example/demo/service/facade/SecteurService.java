package com.example.demo.service.facade;

import com.example.demo.bean.Secteur;

import java.util.List;

public interface SecteurService {
    List<Secteur> findAll();

    Secteur findByCode(Double code);

    int deleteByCode(Double code);

    int save(Secteur secteur);
}
