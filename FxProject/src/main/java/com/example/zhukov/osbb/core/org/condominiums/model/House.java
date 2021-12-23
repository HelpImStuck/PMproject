package com.example.zhukov.osbb.core.org.condominiums.model;


import com.example.zhukov.osbb.core.org.condominiums.exceptions.HouseIsFullException;
import com.example.zhukov.osbb.core.org.condominiums.model.premises.Flat;
import com.example.zhukov.osbb.core.org.condominiums.model.premises.LivingPremises;

import java.util.*;
import java.util.stream.Collectors;

//Основний клас, реалізація будинку
public class House {
    private static final int MAX_FLOOR = 5; //кількість поверхів
    private Map<Integer, List<LivingPremises>> house = new LinkedHashMap<>();//будинок це MAP де номер поверху це ключ а список квартир що відповідають цьому поверху це значення
    private int currentFloor = 1;//потрібний для додавання нового мешканця
    private int countFullFlat;//рахує кількість заповнених квартир на поверсі
    int countInhabitant;//рахує загальну кількість заповнених квартир

    public House() {
        buildHouse();
    }

    //створює 5 поверховий будинок на кожному поверсі 5 квартир
    private void buildHouse() {
        long idPremises = 0; //генератор id для квартир
        int floor = 1;
        for (int k = 0; k < MAX_FLOOR; k++) {
            List<LivingPremises> flats = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Flat flat = new Flat();
                flat.setFloorNumber(floor);
                flat.setId(++idPremises);
                flats.add(flat);
            }
            house.put(floor++, flats);
        }
    }

    //додає нового мешканця
    public void addInhabitant(Inhabitant inhabitant) {
        if(countInhabitant==25){throw new HouseIsFullException();} // якщо будинок повний тобто кількість мешканців  25 кидає exceptions
        if (countFullFlat == 5) {
            ++currentFloor;
            countFullFlat = 0;
        }
        house.get(currentFloor).get(countFullFlat++).setInhabitant(inhabitant);
        ++countInhabitant;
    }

    //додає нового мешканця по id квартири
    public void addInhabitant(Inhabitant inhabitant, long idFlat) {
        Objects.checkIndex((int) idFlat, 26);
        findFlatById(idFlat).setInhabitant(inhabitant);
    }
    //видаляє мещканця по id квартири
    public void deleteInhabitant(long idFlat) {
        findFlatById(idFlat).setInhabitant(null);
    }
    //повертає квартиру по id
    private LivingPremises findFlatById(long idFlat) {
        return house.values().stream().flatMap(fl -> fl.stream()).filter(lv -> lv.getId() == idFlat).findFirst().get();
    }
    //повертає список всіх квартир
    public List<LivingPremises> getFlats() {
        return house.values().stream().flatMap(fl -> fl.stream()).collect(Collectors.toList());
    }

    //повертає список квартир по номеру поверха
    public List<LivingPremises> getFlatsByFloor(int floor){
        return house.get(floor);
    }


    //повертає рядок у якому міститься інформація про будинок
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("House");
        for (int i = 1; i < MAX_FLOOR + 1; i++) {
            str.append("\nFloor " + "№:" + i);
            for (LivingPremises lv : house.get(i)) {
                str.append("\n Flat № " + lv.getId() + " ");
                if (lv.getInhabitant() == null) {
                    str.append(" Empty");
                } else {
                    str.append(" " + lv.getInhabitant().getFirstName());
                }
            }
        }
        return str.toString();
    }

}
