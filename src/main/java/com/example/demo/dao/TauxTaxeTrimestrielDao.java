package com.example.demo.dao;

import com.example.demo.bean.TauxTaxeTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TauxTaxeTrimestrielDao extends JpaRepository<TauxTaxeTrimestriel, Long> {

    TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);


}
