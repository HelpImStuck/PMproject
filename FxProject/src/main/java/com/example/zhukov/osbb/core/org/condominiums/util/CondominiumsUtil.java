package com.example.zhukov.osbb.core.org.condominiums.util;



import com.example.zhukov.osbb.core.org.condominiums.model.House;
import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//домопіжний клас
public class CondominiumsUtil {
    private CondominiumsUtil() {}
    private static final String[] FIRSTNAMES = {"Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander", "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Olivia", "Ema", "Mia"};
    private static final String[] LASTNAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};
    private static String getRandomFirstName() {
        return FIRSTNAMES[new Random().nextInt(FIRSTNAMES.length)];
    }
    private static String getRandomLastName() {
        return LASTNAMES[new Random().nextInt(LASTNAMES.length)];
    }
    private static int getRandomAge() {
        return new Random().nextInt(30) + 18;
    }
    private static boolean getRandomRegistration() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    //створює рандом жильця
    public static Inhabitant createInhabitant() {
        Inhabitant inhabitant = new Inhabitant();
        inhabitant.setId(GeneratorId.next());
        inhabitant.setFirstName(getRandomFirstName());
        inhabitant.setLastName(getRandomLastName());
        inhabitant.setRegistration(getRandomRegistration());
        inhabitant.setAge(getRandomAge());
        inhabitant.setBalance(ThreadLocalRandom.current().nextBoolean() ? 0 : -100);
        return inhabitant;
    }
    //заселяє туди жильців
    public static void fillHouse(House house, int number){
        for (int i = 0; i < number; i++) {
            house.addInhabitant(createInhabitant());
        }
    }
}
