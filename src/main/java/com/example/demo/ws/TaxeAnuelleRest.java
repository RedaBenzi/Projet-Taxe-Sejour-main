package com.example.demo.ws;

import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.service.impl.TaxeAnuelleServiceIpml;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taxe-anuelle")
public class TaxeAnuelleRest {
    @Autowired
    private TaxeAnuelleServiceIpml taxeAnuelleService;


    @GetMapping("/code/{code}")
    public TaxeAnuelle findByAnnee(@PathVariable int annee) {
        return taxeAnuelleService.findByAnnee(annee);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByAnnee(@PathVariable int annee) {
        return taxeAnuelleService.deleteByAnnee(annee);
    }

    @GetMapping("/redevable/cin/{cin}")
    public List<TaxeAnuelle> findByRedevableCin(@PathVariable Long cin) {
        return taxeAnuelleService.findByRedevableCin(cin);
    }

    @GetMapping("/locale/ref/{ref}")
    public List<TaxeAnuelle> findByLocaleRef(@PathVariable Long ref) {
        return taxeAnuelleService.findByLocaleRef(ref);
    }

    @PostMapping("/{cin}/{ref}/{annee}/{datePresentation}")
    public int save(@PathVariable String cin,@PathVariable  String ref,@PathVariable int annee,@PathVariable LocalDateTime datePresentation ,@PathVariable String reference) {
        return taxeAnuelleService.save(cin, ref,  annee, datePresentation,reference);
    }
}
