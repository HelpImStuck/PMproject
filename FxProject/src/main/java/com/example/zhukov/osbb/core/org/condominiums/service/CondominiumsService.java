package com.example.zhukov.osbb.core.org.condominiums.service;


import com.example.zhukov.osbb.core.org.condominiums.model.House;
import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;

import java.util.List;
import java.util.stream.Collectors;

//Сервіс зі всією інформаціює про будинок та його мешканців
public class CondominiumsService implements AbstractCondominiumsService {
    private House house; //

    public CondominiumsService(House house) {
        this.house = house;
    }

    public void addInhabitant(Inhabitant inhabitant) {
        house.addInhabitant(inhabitant);
    }

    public void addInhabitant(Inhabitant inhabitant,long idFlat) {
        house.addInhabitant(inhabitant,idFlat);
    }

    public void deleteInhabitant(long idFlat) {
        house.deleteInhabitant(idFlat);
    }

    //повертає список всіх мешканців
    @Override
    public List<Inhabitant> getListInhabitant() {
        return house.getFlats().stream().map(lp->lp.getInhabitant()).filter(i->i!=null).collect(Collectors.toList());
    }

    //повертає список всіх мешканців по номеру поверха
    @Override
    public List<Inhabitant> getListByFloor(int floor) {
        return house.getFlatsByFloor(floor).stream().map(lp->lp.getInhabitant()).filter(i->i!=null).collect(Collectors.toList());
    }

    //повертає всіх мешканців по віку
    @Override
    public List<Inhabitant> getListByAge(int age) {
        return  house.getFlats().stream().map(lp->lp.getInhabitant()).filter(inhabitant -> inhabitant!=null).filter(inhabitant -> inhabitant.getAge()==age).collect(Collectors.toList());
    }

    //повертає список всіх зареєстрованих мешканців
    @Override
    public List<Inhabitant> getListRegistration() {
        return  house.getFlats().stream().map(lp->lp.getInhabitant()).filter(i->i!=null).filter(inhabitant -> inhabitant.isRegistration()).collect(Collectors.toList());
    }

    //повертає список всіх боржників(мешканців у яких balance менше 0)
    @Override
    public List<Inhabitant> getListDebtors() {
        return  house.getFlats().stream().map(lp->lp.getInhabitant()).filter(i->i!=null).filter(inhabitant -> inhabitant.getBalance()<0).collect(Collectors.toList());
    }
    //повертає мешканця по id
    public Inhabitant getInhabitantById(long id){
       return getListInhabitant().stream().filter(i->i.getId()==id).findFirst().get();
    }

    public void addBalance(long id,long sum){
        Inhabitant inhabitantById = getInhabitantById(id);
        inhabitantById.setBalance(inhabitantById.getBalance()+sum);
    }
    //повертає рядок у якому міститься інформація про будинок
    public String showHouse(){
        return house.toString();
    }
}
