package com.example.demo.service.facade;

import com.example.demo.bean.TauxTaxeAnuelle;

public interface TauxTaxeAnuelleService {
    TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeAnuelle findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);

    int save(TauxTaxeAnuelle tauxTaxeAnuelle);
    
}
