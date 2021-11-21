package taxis;

import models.PassengerTaxiType;

import java.util.Objects;

public class PassengerTaxi extends Taxi {
    private final PassengerTaxiType type;

    public PassengerTaxi(String model, float fuelConsumption, int maxSpeed, float cost, float maxPassengerCapacity, PassengerTaxiType type) {
        super(model, fuelConsumption, maxSpeed, cost, maxPassengerCapacity);
        this.type = type;
    }

    public PassengerTaxiType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", type= " + type + '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerTaxi that = (PassengerTaxi) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
