package com.example.demo.service.impl;

import com.example.demo.bean.*;
import com.example.demo.dao.TaxeAnuelleDao;
import com.example.demo.service.facade.TaxeAnuelleService;
import com.example.demo.service.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxeAnuelleServiceIpml implements TaxeAnuelleService {
    @Autowired
    private TaxeAnuelleDao taxeAnuelleDao;
    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielService;

    @Autowired
    TauxTaxeAnuelleServiceImpl tauxTaxeAnuelleService;


    public List<TaxeAnuelle> findByRedevableCin(Long cin) {
        return taxeAnuelleDao.findByRedevableCin(cin);
    }

    public List<TaxeAnuelle> findByLocaleRef(Long ref) {
        return taxeAnuelleDao.findByLocaleRef(ref);
    }

    public TaxeAnuelle findByAnnee(int annee) {
        return taxeAnuelleDao.findByAnnee(annee);
    }

    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeAnuelleDao.deleteByAnnee(annee);
    }

    @Override
    public int save(TaxeAnuelle taxeAnuelle) {
        return 0;
    }


    @Autowired
    TauxTaxeTrimestrielServiceImpl tauxTaxeTrimestrielService;
    @Autowired
    LocaleServiceImpl localeService;


    public int save(String cin, String ref, int annee, LocalDateTime datePresentation, String reference) {
        TaxeAnuelle taxeAnuelle = new TaxeAnuelle();
        TaxeTrimestriel taxeTrimestriel = taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, 1);
        Locale locale = localeService.findByRef(ref);
        CategorieLocale categorieLocale = locale.getCategorieLocale();
        TauxTaxeAnuelle tauxTaxeAnuelle = tauxTaxeAnuelleService.findByCategorieLocaleCodeAndReference(categorieLocale.getCode(), reference);
        TauxTaxeTrimestriel tauxTaxeTrimestriel = tauxTaxeTrimestrielService.findByCategorieLocaleCode(categorieLocale.getCode());


        TaxeTrimestriel taxeTrimestriel1 = taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 1, annee);
        TaxeTrimestriel taxeTrimestriel2 = taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 2, annee);
        TaxeTrimestriel taxeTrimestriel3 = taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 3, annee);
        TaxeTrimestriel taxeTrimestriel4 = taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 4, annee);
        double montantMajorationAnuelle = 0;
        double montantRetardAnuelle = 0;
        double montantBaseAnuelle = 0;
        int nombreDeMoisRetard = 0;
        if (taxeTrimestriel1 == null) {
            taxeTrimestrielService.save(1, annee, taxeTrimestriel1.getLocale().getRef(), cin, taxeTrimestriel1.getNombreDeNuite(), datePresentation, ref);
            ;
        } else if (taxeTrimestriel2 == null) {
            taxeTrimestrielService.save(2, annee, taxeTrimestriel2.getLocale().getRef(), cin, taxeTrimestriel2.getNombreDeNuite(), datePresentation, ref);

            ;
        } else if (taxeTrimestriel3 == null) {
            taxeTrimestrielService.save(3, annee, taxeTrimestriel3.getLocale().getRef(), cin, taxeTrimestriel3.getNombreDeNuite(), datePresentation, ref);
            ;
        } else if (taxeTrimestriel4 == null) {
            taxeTrimestrielService.save(4, annee, taxeTrimestriel4.getLocale().getRef(), cin, taxeTrimestriel4.getNombreDeNuite(), datePresentation, ref);

            ;
        } else {


            montantBaseAnuelle = taxeTrimestriel1.getMontantBase() + taxeTrimestriel2.getMontantBase() + taxeTrimestriel3.getMontantBase() + taxeTrimestriel4.getMontantBase();
            taxeAnuelle.setMontantBaseAnuelle(montantBaseAnuelle);

            nombreDeMoisRetard = DateUtil.calculateNbrMoisRetard(4, annee, datePresentation);
            if (nombreDeMoisRetard >= 3) {
                montantRetardAnuelle = montantBaseAnuelle * tauxTaxeAnuelle.getPourcentageRetardAnnuelle();
                montantMajorationAnuelle = (nombreDeMoisRetard - 3) * montantBaseAnuelle * tauxTaxeAnuelle.getPourcentageMajorationAnnuelle();

                ;

            }
        }
        double montantTotalAnuelle = montantBaseAnuelle + montantRetardAnuelle + montantMajorationAnuelle;
       // taxeAnuelle.setTauxTaxeAnuelle(taxeAnuelle);
        taxeAnuelle.setMontantMajorationAnuelle(montantMajorationAnuelle);
        taxeAnuelle.setMontantRetardAnuelle(montantRetardAnuelle);
        taxeAnuelle.setMontantBaseAnuelle(montantBaseAnuelle);
        taxeAnuelle.setMontantTotalAnuelle(montantTotalAnuelle);
        taxeAnuelle.setAnnee(annee);
        taxeTrimestriel.setLocale(locale);
        taxeTrimestriel.setNombreDeMoisRetard(nombreDeMoisRetard);
        tauxTaxeTrimestriel.setCategorieLocale(categorieLocale);

        locale.setDerniereAnneePaye(annee);


        taxeAnuelleDao.save(taxeAnuelle);
        return 1;


    }
}
