package com.example.demo.ws;


import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.service.impl.TaxeTrimestrielServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taxeSejourTrimestrie")
public class TaxeTrimestrielRest {


    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielService;

    @GetMapping("/trimestre/{trimestre}")
    public TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(@PathVariable String ref, @PathVariable int trimestre, int annee) {
        return taxeTrimestrielService.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre, annee);
    }

    @GetMapping("/Redevable/cin/{cin}/Locale/ref/{ref}/trimestre/{trimestre}")
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(@PathVariable String cin, @PathVariable String ref, @PathVariable int trimestre) {
        return taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }


    @DeleteMapping("/Redevable/cin/{cin}/Locale/ref/{ref}/trimestre/{trimestre}")
    public int deleteByRedevableCinAndLocaleRefAndTrimestre(@PathVariable String cin, @PathVariable String ref, @PathVariable int trimestre) {
        return taxeTrimestrielService.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }




    @GetMapping("/")
    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielService.findAll();
    }
    @PostMapping ("/{trimest}/{annee}/{refLocale}/{cin}/{nombreDeNuite}/{datePresentation}/{tauxReference}")
    public int save( @PathVariable int trimest,@PathVariable int annee, @PathVariable String refLocale, @PathVariable String cin,@PathVariable double nombreDeNuite,@PathVariable LocalDateTime datePresentation,@PathVariable String tauxReference){
        return taxeTrimestrielService.save( trimest, annee, refLocale,cin, nombreDeNuite,  datePresentation, tauxReference);
    }
}
