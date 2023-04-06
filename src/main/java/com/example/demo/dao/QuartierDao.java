package com.example.demo.dao;


import com.example.demo.bean.Quartiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierDao extends JpaRepository<Quartiere, Long> {
    List<Quartiere> findAll();

    Quartiere findByCode(Double code);

    int deleteByCode(Double code);
}
