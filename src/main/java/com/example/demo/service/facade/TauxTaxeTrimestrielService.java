package com.example.demo.service.facade;

import com.example.demo.bean.TauxTaxeTrimestriel;

import java.time.LocalDateTime;

public interface TauxTaxeTrimestrielService {
    TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);
      int save (TauxTaxeTrimestriel tauxTaxeTrimestriel );



}
