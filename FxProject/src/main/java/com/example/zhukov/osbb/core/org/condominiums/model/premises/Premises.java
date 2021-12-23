package com.example.zhukov.osbb.core.org.condominiums.model.premises;

// абстрактний клас приміщення
public abstract class Premises {
    protected long id;
    protected int floorNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
