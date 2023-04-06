package com.example.demo.service.impl;

import com.example.demo.bean.Rue;
import com.example.demo.dao.RueDao;
import com.example.demo.service.facade.RueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RueServiceImpl implements RueService {
    @Autowired
    private RueDao rueDao;


    public List<Rue> findAll() {

        return rueDao.findAll();
    }

    @Override
    public Rue findByLibelle(String libelle) {
        return rueDao.findByLibelle(libelle);
    }

    public Rue findByCode(Double code) {
        return rueDao.findByCode(code);
    }

    public Rue findByQuartierCode(Double code) {
        return rueDao.findByQuartierCode(code);
    }

    public int save(Rue rue) {
        if (findByCode(rue.getCode()) != null) {
            return -1;
        } else {
            rueDao.save(rue);
            return 1;
        }
    }

    @Transactional
    public int deleteByCode(Double code) {
        return rueDao.deleteByCode(code);
    }


}
