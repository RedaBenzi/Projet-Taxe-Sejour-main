package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeAnuelle;
import com.example.demo.service.impl.TauxTaxeAnuelleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/taux-taxe-anuelle")
public class TauxTaxeAnuelleRest {

    @Autowired
    private TauxTaxeAnuelleServiceImpl tauxTaxeAnuelleService;

    @PostMapping("/")
    public int save(@RequestBody TauxTaxeAnuelle tauxTaxeAnuelle) {
        return tauxTaxeAnuelleService.save(tauxTaxeAnuelle);
    }

    @GetMapping("/CategorieLocale/{code}/{reference}")
    public TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(@PathVariable String code, @PathVariable String reference) {
        return tauxTaxeAnuelleService.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @GetMapping("/code/{code}")
    public TauxTaxeAnuelle findByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeAnuelleService.findByCategorieLocaleCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeAnuelleService.deleteByCategorieLocaleCode(code);
    }
}
