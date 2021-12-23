package com.example.zhukov.osbb.core.org.condominiums.model.premises;


import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;

//клас квартира(Flat) унаслідується від житлового приміщення(Living Premises)
public class Flat extends LivingPremises {
    public Flat() {
    }
    public Flat(Inhabitant inhabitant) {
        super(inhabitant);
    }
}
