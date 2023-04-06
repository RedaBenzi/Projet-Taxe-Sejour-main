package com.example.demo.dao;


import com.example.demo.bean.TauxTaxeAnuelle;
import com.example.demo.bean.TauxTaxeTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTaxeAnuelleDao extends JpaRepository<TauxTaxeAnuelle,Long> {



    TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeAnuelle findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);
}

