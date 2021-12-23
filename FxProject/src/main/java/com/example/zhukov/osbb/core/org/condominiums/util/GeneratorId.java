package com.example.zhukov.osbb.core.org.condominiums.util;

//клас генерації id для мешканців
public class GeneratorId {
    private static long id;
    public static long next(){
        return ++id;
    }
}
