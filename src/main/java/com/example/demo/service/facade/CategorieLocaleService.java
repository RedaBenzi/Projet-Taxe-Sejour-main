package com.example.demo.service.facade;

import com.example.demo.bean.CategorieLocale;

import java.util.List;

public interface CategorieLocaleService  {
    CategorieLocale findByCode(String code);

    CategorieLocale findByLibelle(String libelle);

    int deleteByCode(String code);
    List<CategorieLocale> findAll();
    int save(CategorieLocale categorieLocale);
}
