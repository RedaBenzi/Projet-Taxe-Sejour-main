package com.example.demo.service.impl;

import com.example.demo.bean.Secteur;
import com.example.demo.dao.SecteurDao;
import com.example.demo.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SecteurServiceImpl implements SecteurService {
    @Autowired
    private SecteurDao secteurDao;

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    public Secteur findByCode(Double code) {
        return secteurDao.findByCode(code);
    }

    public int save(Secteur secteur) {
        if (findByCode(secteur.getCode()) != null) {
            return -1;
        } else {
            secteurDao.save(secteur);
            return 1;
        }
    }

    @Transactional
    public int deleteByCode(Double code) {
        return secteurDao.deleteByCode(code);
    }
}
