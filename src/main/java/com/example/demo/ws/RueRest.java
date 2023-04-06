package com.example.demo.ws;

import com.example.demo.bean.Rue;
import com.example.demo.service.impl.RueServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rue")
public class RueRest {
    @Autowired
    private RueServiceImpl rueServiceImpl;

    @GetMapping("/")
    public List<Rue> findAll() {
        return rueServiceImpl.findAll();
    }

    @GetMapping("/code/{code}")
    public Rue findByCode(@PathVariable Double code) {
        return rueServiceImpl.findByCode(code);
    }

    @GetMapping("/Quartiere/code/{code}")
    public Rue findByQuartierCode(Double code) {
        return rueServiceImpl.findByQuartierCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Rue rue) {
        return rueServiceImpl.save(rue);
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable Double code) {
        return rueServiceImpl.deleteByCode(code);
    }


}
