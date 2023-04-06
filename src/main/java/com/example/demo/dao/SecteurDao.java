package com.example.demo.dao;

import com.example.demo.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Long> {
    List<Secteur> findAll();

    Secteur findByCode(Double code);

    int deleteByCode(Double code);

}
