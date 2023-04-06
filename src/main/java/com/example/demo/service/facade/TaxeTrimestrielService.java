package com.example.demo.service.facade;

import com.example.demo.bean.TaxeTrimestriel;

import java.time.LocalDateTime;
import java.util.List;

public interface TaxeTrimestrielService {
    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);
    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre,int annee);

    TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee);


    int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);
    int save(int trimest,int annee, String refLocale,String cin,double nombreDeNuite, LocalDateTime datePresentation,String tauxReference);



    List<TaxeTrimestriel> findAll();


}
