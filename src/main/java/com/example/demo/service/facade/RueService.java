package com.example.demo.service.facade;

import com.example.demo.bean.Rue;

import java.util.List;

public interface RueService {
    List<Rue> findAll();

    Rue findByQuartierCode(Double code);

    Rue findByCode(Double code);

    int deleteByCode(Double code);

    Rue findByLibelle(String libelle);

    int save(Rue rue);



}
