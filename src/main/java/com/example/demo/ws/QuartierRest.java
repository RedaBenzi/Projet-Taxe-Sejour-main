package com.example.demo.ws;

import com.example.demo.bean.Quartiere;
import com.example.demo.service.impl.QuartierServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quartier")
public class QuartierRest {
    @Autowired
    private QuartierServiceImpl quartierService;

    @GetMapping("/code/{code}")

    public Quartiere findByCode(@PathVariable Double code) {
        return quartierService.findByCode(code);
    }

    @GetMapping("/")

    public List<Quartiere> findAll() {
        return quartierService.findAll();
    }

    @PostMapping("/")

    public int save(@RequestBody Quartiere quartiere) {
        return quartierService.save(quartiere);
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable Double code) {
        return quartierService.deleteByCode(code);
    }
}
