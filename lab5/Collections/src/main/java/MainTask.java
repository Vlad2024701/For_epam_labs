import models.PassengerTaxiType;
import taxis.CargoTaxi;
import taxis.PassengerTaxi;
import taxis.Taxi;

import java.util.Arrays;
import java.util.List;

public class MainTask {
    static List<Taxi> taxis = Arrays.asList(
            new PassengerTaxi("Mercedes", 5.0f, 220, 10000, 4, PassengerTaxiType.PASSENGER_TAXI),
            new PassengerTaxi("Volkswagen", 5.5f, 220, 8000, 4, PassengerTaxiType.PASSENGER_TAXI),
            new PassengerTaxi("Kia-rio", 5.75f, 210, 5000, 4, PassengerTaxiType.PASSENGER_TAXI),
            new PassengerTaxi("Lada", 6.25f, 190, 2000, 4, PassengerTaxiType.PASSENGER_TAXI),
            new PassengerTaxi("Mercedes", 6, 180, 35000, 14, PassengerTaxiType.MINIBUS),
            new PassengerTaxi("Volkswagen", 6.5f, 170, 32000, 14, PassengerTaxiType.MINIBUS),
            new CargoTaxi("Volvo", 6.0f, 160, 30000, 0, 3500),
            new CargoTaxi("Volkswagen", 6.25f, 170, 33000, 0, 2500),
            new CargoTaxi("Citroen", 6.5f, 170, 35000, 0, 5000),
            new CargoTaxi("Daf", 6.75f, 140, 30000, 0, 12000)
    );
    public static void main(String[] args) {
        TaxiCompany taxiCompany = new TaxiCompany(taxis);
        System.out.println("Общая стоимость автопарка: " + taxiCompany.getTotalCostOfTaxiCompany());
        System.out.println("\nСортировка автомобилей автопарка по расходу топлива:");
        taxiCompany.sortByFuelConsumption();
        taxiCompany.getTaxis().forEach(System.out::println);
        System.out.println("\nПоиск автомобилей в таксопарке, с диапазаном максимальной скорости 180 - 220");
        taxiCompany.printTaxisWithSpeedInRange(180, 220);
    }
}
