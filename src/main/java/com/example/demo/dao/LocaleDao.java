package com.example.demo.dao;

import com.example.demo.bean.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocaleDao extends JpaRepository<Locale, Long> {
    Locale findByRef(String ref);
    int deleteByRef(String ref);

    List<Locale> findByDerniereAnneePaye(int derniereAnneePaye);
    List<Locale> findByDernierTrimestrePaye(int DernierTrimestrePaye);

    int deleteById(int id);
    List<Locale> findAll();
}
