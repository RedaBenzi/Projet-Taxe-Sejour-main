package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.service.impl.TauxTaxeTrimestrielServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/taux-taxe-trimestriel")
public class TauxTaxeTrimestrielRest {
    @Autowired
    private TauxTaxeTrimestrielServiceImpl tauxTaxeTrimestrielService;

    @GetMapping("/code/{code}")
    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielService.findByCategorieLocaleCode(code);
    }

    @GetMapping("/CategorieLocale/{code}/{reference}")
    public TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference( @PathVariable  String code,@PathVariable String reference) {
        return tauxTaxeTrimestrielService.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeTrimestrielService.deleteByCategorieLocaleCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        return tauxTaxeTrimestrielService.save(tauxTaxeTrimestriel);
    }
}
