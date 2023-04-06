package com.example.demo.service.facade;

import com.example.demo.bean.TaxeAnuelle;

import java.util.List;

public interface TaxeAnuelleService {
    List<TaxeAnuelle> findByRedevableCin(Long cin);

    List<TaxeAnuelle> findByLocaleRef(Long ref);


    TaxeAnuelle findByAnnee(int annee);

    int deleteByAnnee(int annee);
     int save(TaxeAnuelle taxeAnuelle);
}
