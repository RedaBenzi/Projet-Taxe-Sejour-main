package com.example.demo.service.facade;

import com.example.demo.bean.Locale;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);
    Locale findById(Long id);

    int deleteByRef(String ref);
    int update(Locale locale );

    List<Locale> findByDerniereAnneePaye(int derniereAnneePaye);
    List<Locale> findByDernierTrimestrePaye(int DernierTrimestrePaye);
    int deleteById(int id);

    List<Locale> findAll();
     int save(Locale locale);
}
