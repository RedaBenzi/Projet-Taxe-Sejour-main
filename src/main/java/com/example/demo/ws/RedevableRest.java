package com.example.demo.ws;

import com.example.demo.bean.Redevable;
import com.example.demo.service.impl.RedevableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redevable")
public class RedevableRest {
    @Autowired
    private RedevableServiceImpl redevableService;
    @GetMapping("/cin/{cin}/nom/{nom}")
    public Redevable findByCinAndNom(String cin, String nom) {
        return redevableService.findByCinAndNom(cin, nom);
    }

    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }

    @GetMapping("/cin/{cin}")
    public Redevable findByCin(@PathVariable String cin) {
        return redevableService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return redevableService.deleteByCin(cin);
    }

    @GetMapping("/")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }
    @PutMapping("/")
    public int update(@RequestBody Redevable redevable) {
        return redevableService.update(redevable);
    }
}
