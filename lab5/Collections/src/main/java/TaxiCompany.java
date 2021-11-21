import taxis.Taxi;

import java.util.Comparator;
import java.util.List;

public class TaxiCompany {
    private final List<Taxi> taxis;

    public TaxiCompany(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public double getTotalCostOfTaxiCompany(){
        return taxis.stream().mapToDouble(Taxi::getCost).sum();
    }

    public void sortByFuelConsumption(){
        taxis.sort(Comparator.comparingDouble(Taxi::getFuelConsumption));
    }

    public void printTaxisWithSpeedInRange(int minSpeed, int maxSpeed){
        taxis.stream().filter(taxi -> taxi.getMaxSpeed() >= minSpeed && taxi.getMaxSpeed() <= maxSpeed)
                .forEach(System.out::println);
    }

    public List<Taxi> getTaxis(){
        return taxis;
    }

}
