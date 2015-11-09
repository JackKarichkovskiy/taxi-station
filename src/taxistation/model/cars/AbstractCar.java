/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model.cars;

import java.util.Objects;
import taxistation.model.cars.interfaces.Car;
import taxistation.model.cars.interfaces.Goods;
import taxistation.utils.TaxiStationUtils;

/**
 * Abstract class that represents the structure of car entity.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public abstract class AbstractCar implements Car, Goods {

    /**
     * The name of car model.
     */
    protected String model;
    
    /**
     * The horse power of car.
     */
    protected int hp;
    
    /**
     * The fuel consumption of car in liters per 100 km.
     */
    protected int fuelConsumption;
    
    /**
     * The cost of car in taxi station.
     */
    protected int cost;
    
    /**
     * The max speed that the car can achieve.
     */
    protected int maxSpeed;

    /**
     * The type of car engine.
     */
    protected final EngineType engineType;
    
    /**
     * Enumeration of engine types in the car.
     */
    public enum EngineType{
        PETROL, GAS, ELECTRICITY
    }
    
    public AbstractCar() {
        engineType = EngineType.PETROL;
    }

    public AbstractCar(String model, int hp, int fuelConsumption, int price, int maxSpeed, EngineType engineType) {
        this.model = TaxiStationUtils.checkNotNull(model);
        this.hp = TaxiStationUtils.checkNotNegative(hp);
        this.fuelConsumption = TaxiStationUtils.checkNotNegative(fuelConsumption);
        this.cost = TaxiStationUtils.checkNotNegative(price);
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }

    @Override
    public String name() {
        return model;
    }

    @Override
    public int hp() {
        return hp;
    }

    @Override
    public int cost() {
        return cost;
    }

    @Override
    public int maxSpeed() {
        return maxSpeed;
    }

    @Override
    public int fuelConsumption() {
        return fuelConsumption;
    }

    public void setModel(String model) {
        this.model = TaxiStationUtils.checkNotNull(model);
    }

    public void setHp(int hp) {
        this.hp = TaxiStationUtils.checkNotNegative(hp);
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = TaxiStationUtils.checkNotNegative(fuelConsumption);
    }

    public void setPrice(int price) {
        this.cost = TaxiStationUtils.checkNotNegative(price);
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = TaxiStationUtils.checkNotNegative(maxSpeed);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.model);
        hash = 37 * hash + this.hp;
        hash = 37 * hash + this.fuelConsumption;
        hash = 37 * hash + this.cost;
        hash = 37 * hash + this.maxSpeed;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractCar other = (AbstractCar) obj;
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (this.hp != other.hp) {
            return false;
        }
        if (this.fuelConsumption != other.fuelConsumption) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        if (this.maxSpeed != other.maxSpeed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AbstractCar{" + "model=" + model + ", hp=" + hp + ", fuelConsumption=" + fuelConsumption + ", cost=" + cost + ", maxSpeed=" + maxSpeed + '}';
    }
}
