package com.example.demo.service.facade;

import com.example.demo.bean.Quartiere;

import java.util.List;

public interface QuartierService {
    List<Quartiere> findAll();

    Quartiere findByCode(Double code);

    int deleteByCode(Double code);
    public int save(Quartiere quartiere);
}

