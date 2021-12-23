package com.example.zhukov.osbb.core.org.condominiums.model.premises;


import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;

//абстрактний клас житлового приміщення (унаслідується від приміщення(Premises)
//відрізняєтья від приміщення(Premises) тим що має 1 мешканця(inhabitant)
public abstract class LivingPremises extends Premises {

    private Inhabitant inhabitant;
    public LivingPremises(){}

    public LivingPremises(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public void setInhabitant(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
    }
}
