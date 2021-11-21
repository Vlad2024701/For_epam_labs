package taxis;

import java.util.Objects;

public class Taxi {

    private final String model;
    private final float fuelConsumption;
    private final int maxSpeed;
    private final float cost;
    private final float maxPassengerCapacity;

    public Taxi(String model, float fuelConsumption, int maxSpeed, float cost, float maxPassengerCapacity) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.cost = cost;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public float getCost() {
        return cost;
    }

    public float getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption + " per 100km" +
                ", maxSpeed=" + maxSpeed +
                ", cost=" + cost + " $" +
                ", passengarCapacity=" + maxPassengerCapacity +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Taxi taxi = (Taxi) other;
        return Float.compare(taxi.fuelConsumption, fuelConsumption) == 0 &&
                maxSpeed == taxi.maxSpeed &&
                Float.compare(taxi.cost, cost) == 0 &&
                Float.compare(taxi.maxPassengerCapacity, maxPassengerCapacity) == 0 &&
                Objects.equals(model, taxi.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, fuelConsumption, maxSpeed, cost, maxPassengerCapacity);
    }
}
