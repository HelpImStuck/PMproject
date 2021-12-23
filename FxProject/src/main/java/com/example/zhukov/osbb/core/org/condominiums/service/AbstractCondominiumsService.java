package com.example.zhukov.osbb.core.org.condominiums.service;


import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;

import java.util.List;

//абстрактний сервіс
public interface AbstractCondominiumsService {
    List<Inhabitant> getListInhabitant();
    List<Inhabitant> getListByFloor(int floor);
    List<Inhabitant> getListByAge(int age);
    List<Inhabitant> getListRegistration();
    List<Inhabitant> getListDebtors();
}
