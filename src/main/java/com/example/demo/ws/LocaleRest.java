package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.service.impl.LocaleServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/local")
public class LocaleRest {
    @Autowired
    private LocaleServiceImpl localeService;
    @GetMapping("/{id}")
    public Locale findById(@PathVariable Long id) {
        return localeService.findById(id);
    }

    @GetMapping("/ref/{ref}")
    public Locale findByRef(@PathVariable String ref) {
        return localeService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localeService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Locale> findAll() {
        return localeService.findAll();
    }
    @PutMapping("/")
    public int update(@RequestBody Locale locale) {
        return localeService.update(locale);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return localeService.deleteById(id);

    }

    @PostMapping("/")
    public int save(@RequestBody Locale locale) {return localeService.save(locale);}

    @GetMapping("/derniereAnneePaye/{derniereAnneePaye}")
    public   List<Locale> findByDerniereAnneePaye(@PathVariable int derniereAnneePaye) {
        return localeService.findByDerniereAnneePaye(derniereAnneePaye);
    }
    @GetMapping("/DernierTrimestrePaye/{DernierTrimestrePaye}")
    public List<Locale> findByDernierTrimestrePaye(int DernierTrimestrePaye) {
        return localeService.findByDernierTrimestrePaye(DernierTrimestrePaye);
    }

}


