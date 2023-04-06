package com.example.demo.service.facade;

import com.example.demo.bean.Redevable;

public interface RedevableService {
    Redevable findByCin(String cin);


    int deleteByCin(String cin);
    int save(Redevable redevable);
    int update(Redevable redevable);
    Redevable findByCinAndNom(String cin,String nom);

}
