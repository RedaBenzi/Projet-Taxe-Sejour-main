package com.example.demo.ws;

import com.example.demo.bean.Secteur;
import com.example.demo.service.impl.SecteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Secteur")
public class SecteurRest {
    @Autowired
    private SecteurServiceImpl secteurService;

    @GetMapping("/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }

    @GetMapping("/code/{code}")
    public Secteur findByCode(@PathVariable Double code) {
        return secteurService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Secteur secteur) {
        return secteurService.save(secteur);
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable Double code) {
        return secteurService.deleteByCode(code);
    }


}
