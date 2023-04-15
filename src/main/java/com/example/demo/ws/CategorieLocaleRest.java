package com.example.demo.ws;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.service.impl.CategorieLocaleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoriel-locale-sejour")
public class CategorieLocaleRest {
    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    @PostMapping("/")
    public int save(@RequestBody CategorieLocale categorieLocale) {
        return categorieLocaleService.save(categorieLocale);
    }
    @GetMapping("/")
    public List<CategorieLocale> findAll() {
        return categorieLocaleService.findAll();
    }

    @GetMapping("/code/{code}")
    public CategorieLocale findByCode(@PathVariable String code) {
        return categorieLocaleService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieLocaleService.deleteByCode(code);
    }
}
