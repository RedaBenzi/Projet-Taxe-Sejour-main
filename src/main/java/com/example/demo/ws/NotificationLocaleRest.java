package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.bean.NotificationLocale;
import com.example.demo.service.impl.NotificationLocaleSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-locale")
public class NotificationLocaleRest {
    @Autowired
    private NotificationLocaleSeviceImpl notificationLocaleSevice;

    @GetMapping("/Redevable/cin/{cin}")
    public List<NotificationLocale> findByRedevableCin(String cin) {
        return notificationLocaleSevice.findByRedevableCin(cin);
    }

    @GetMapping("/Locale/ref/{ref}")
    public List<NotificationLocale> findByLocaleRef(String ref) {
        return notificationLocaleSevice.findByLocaleRef(ref);
    }

    @GetMapping("/")
    public List<NotificationLocale> findAll() {
        return notificationLocaleSevice.findAll();
    }
    @GetMapping("/locale/{annee}/{trimestre}")
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationLocaleSevice.findAllLocal(annee, trimestre);
    }
    @GetMapping("/local/{DerniereAnneePaye}/{DernierTrimestrePaye}")
    public List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye) {
        return notificationLocaleSevice.findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(DerniereAnneePaye, DernierTrimestrePaye);
    }
    @PostMapping("/")
    public int save(@RequestBody NotificationLocale notificationLocale) {
      return   notificationLocaleSevice.save(notificationLocale);
    }
   @Transactional
   @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return notificationLocaleSevice.deleteById(id);
    }
    @PutMapping("/")
    public int update(@RequestBody NotificationLocale notificationLocale) {
        return notificationLocaleSevice.update(notificationLocale);
    }
    @GetMapping("/{id}")
    public NotificationLocale findById(@PathVariable Long id) {
        return notificationLocaleSevice.findById(id);
    }
}
