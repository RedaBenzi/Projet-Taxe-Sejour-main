package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.dao.CategorieLocaleDao;
import com.example.demo.service.facade.CategorieLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieLocaleServiceImpl implements CategorieLocaleService {
    @Autowired
    private CategorieLocaleDao categorieLocaleDao;

    public int save(CategorieLocale categorieLocale) {
        if (findByCode(categorieLocale.getCode()) != null) {
            return -1;
        } else {
            categorieLocaleDao.save(categorieLocale);
            return 1;
        }
    }

    @Override
    public List<CategorieLocale> findAll() {
        return categorieLocaleDao.findAll();
    }

    @Override
    public CategorieLocale findByLibelle(String libelle) {
        return categorieLocaleDao.findByLibelle(libelle);
    }

    public CategorieLocale findByCode(String code) {
        return categorieLocaleDao.findByCode(code);
    }

    public CategorieLocale findOrSave(CategorieLocale categorieLocale) {
        if (categorieLocale == null || categorieLocale.getCode() == null) {
            return null;
        } else {
            CategorieLocale byCode = categorieLocaleDao.findByCode(categorieLocale.getCode());
            if (byCode != null) {
                return byCode;
            } else {
                return categorieLocaleDao.save(categorieLocale);
            }
        }
    }

    public int deleteByCode(String code) {
        return categorieLocaleDao.deleteByCode(code);
    }
}
