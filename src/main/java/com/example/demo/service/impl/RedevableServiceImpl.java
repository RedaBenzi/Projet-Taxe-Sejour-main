package com.example.demo.service.impl;

import com.example.demo.bean.Redevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.service.facade.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RedevableServiceImpl implements RedevableService {

    public int save(Redevable redevable) {
        if (findByCin(redevable.getCin()) != null) {
            return -1;
        } else {
            redevableDao.save(redevable);
            return 1;
        }

    }
    public int update(Redevable redevable){
        if (redevableDao.findById(redevable.getId()) != null) {
            return -1;

        } else {
           Redevable red = redevableDao.findByCin(redevable.getCin());
            red.setCin(redevable.getCin());
            red.setId(redevable.getId());
            red.setNom(redevable.getNom());
            red.setPrenom(redevable.getPrenom());
            redevableDao.save(red);
            return 1;
        }

    }

    @Autowired
    private RedevableDao redevableDao;

    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }

    @Override
    public Redevable findByCinAndNom(String cin, String nom) {
        return redevableDao.findByCinAndNom(cin, nom);
    }

    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }
}


/*public class RedevableService {
    public Redevable findById(String id,ArrayList<Redevable> redevables){
        for (Redevable redevable : redevables) {
            if (redevable.getId().equals(id)) {
                return redevable;
            }
        }return null;
    }*/

// public int save(Redevable redevable,ArrayList<Redevable> redevables){
//         Redevable loadedRedevable = findById(redevable.getId(),redevables);
//          if(loadedRedevable!=null){
//              return -1;
//          }else{
//          loadedRedevable.setId(redevable.getId());
//          redevables.add(loadedRedevable);
//          return 1;
//}
//          public int supprimer(Redevable redevable,ArrayList<Redevable> redevables){
//              Redevable supprRedevable = findById(redevable.getId(),redevables);
//              if(supprRedevable==null){
//              return -1;
//              }else{
//
//              }
//          }


