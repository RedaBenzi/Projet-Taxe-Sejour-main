package com.example.demo.service.facade;

import com.example.demo.bean.Locale;
import com.example.demo.bean.NotificationLocale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationLocaleSevice {
    @Query( "select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    List<Locale> findAllLocal(@Param("annee") int annee, @Param("trimestre") int trimestre);

    int save(NotificationLocale notificationLocale);
    List<NotificationLocale> findByRedevableCin(String cin);

    List<NotificationLocale> findByLocaleRef(String ref);
    List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye);

    List<NotificationLocale> findAll();
    int deleteById(int id);



}
