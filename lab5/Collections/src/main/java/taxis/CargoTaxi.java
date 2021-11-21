package taxis;

import java.util.Objects;

public class CargoTaxi extends Taxi{
    private final int cargoCapacity;

    public CargoTaxi(String model, float fuelConsumption, int maxSpeed, float cost, float maxPassengerCapacity, int cargoCapacity) {
        super(model, fuelConsumption, maxSpeed, cost, maxPassengerCapacity);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", cargoCapacity=" + cargoCapacity + " kg }");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoTaxi cargoTaxi = (CargoTaxi) o;
        return cargoCapacity == cargoTaxi.cargoCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity);
    }
}
