package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import com.example.demo.service.facade.TauxTaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TauxTaxeTrimestrielServiceImpl implements TauxTaxeTrimestrielService {

    @Autowired

    private TauxTaxeTrimestrielDao tauxTaxeTrimestrielDao;

    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    public int save(TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        if (tauxTaxeTrimestriel.getCategorielocale() == null) {
            return -1;
        } else if (tauxTaxeTrimestriel.getCategorielocale() != null) {
            CategorieLocale categorieLocaleServiceByCode = categorieLocaleService.findOrSave(tauxTaxeTrimestriel.getCategorielocale());
            tauxTaxeTrimestriel.setCategorielocale(categorieLocaleServiceByCode);
            tauxTaxeTrimestrielDao.save(tauxTaxeTrimestriel);
            return 1;
        }
        return 2;
    }


    @Override
    public TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code, String reference) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCodeAndReference(code,reference);
    }

    @Override
    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCode(code);
    }


    @Override
    public int deleteByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.deleteByCategorieLocaleCode(code);
    }


}


