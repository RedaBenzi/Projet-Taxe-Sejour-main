package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.TauxTaxeAnuelle;
import com.example.demo.dao.TauxTaxeAnuelleDao;
import com.example.demo.service.facade.TauxTaxeAnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TauxTaxeAnuelleServiceImpl implements TauxTaxeAnuelleService {

    @Autowired
    private TauxTaxeAnuelleDao tauxTaxeAnuelleDao;

    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    public int save(TauxTaxeAnuelle tauxTaxeAnuelle) {
        if (tauxTaxeAnuelle.getCategorieLocale() != null) {
            return -1;
        } else if (tauxTaxeAnuelle.getCategorieLocale() == null) {
            CategorieLocale categorieLocaleServiceByCode = categorieLocaleService.findOrSave(tauxTaxeAnuelle.getCategorieLocale());
            tauxTaxeAnuelle.setCategorieLocale(categorieLocaleServiceByCode);
            tauxTaxeAnuelleDao.save(tauxTaxeAnuelle);
            return 1;
        }
        return 2;
    }

    @Override
    public TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code, String reference) {
        return tauxTaxeAnuelleDao.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @Override
    public TauxTaxeAnuelle findByCategorieLocaleCode(String code) {
        return tauxTaxeAnuelleDao.findByCategorieLocaleCode(code);
    }

    @Override
    public int deleteByCategorieLocaleCode(String code) {
        return tauxTaxeAnuelleDao.deleteByCategorieLocaleCode(code);
    }

}
