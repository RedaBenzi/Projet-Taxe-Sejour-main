package com.example.demo.service.impl;


import com.example.demo.bean.Quartiere;
import com.example.demo.dao.QuartierDao;
import com.example.demo.service.facade.QuartierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuartierServiceImpl implements QuartierService {
    @Autowired
    private QuartierDao quarteirDao;


    public Quartiere findByCode(Double code) {
        return quarteirDao.findByCode(code);
    }

    public List<Quartiere> findAll() {
        return quarteirDao.findAll();
    }

    public int save(Quartiere quartiere) {
        if (findByCode(quartiere.getCode()) != null) {
            return -1;
        } else {
            quarteirDao.save(quartiere);
            return 1;
        }

    }

    @Transactional
    public int deleteByCode(Double code) {
        return quarteirDao.deleteByCode(code);

    }
}
