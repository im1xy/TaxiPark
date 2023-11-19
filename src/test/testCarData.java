package test;

import main.Cars.Car;
abstract public class testCarData {
    public static Car testNullCar = new Car(null, null, null,null, null, false,
            null, null, null, null, null, null, null);
    public static Car testAudiPetrolCar = new Car("Audi", "R8", "Petrol Car","Full-size luxury car", 10000, false,
            2023, 1, 8, null, 234, 633, 6);
    public static Car testTeslaElectricCar = new Car("Tesla", "V4", "Electric Car","Mid-size luxury car", 12000, true,
            2022,null,7,12,355,1,14);
    public static Car testOpelGasCar = new Car("Opel", "A5", "Gas Car","Compact car", 15000, false,
            2021,3,1,5,null,531,63);
    public static Car testBugattiPetrolCar = new Car("Bugatti", "Veyron", "Petrol Car", "Supercar", 20000, true,
            2018, 0, 500, 40, 400,null,null);
    public static Car testPorscheElectricCar = new Car("Porsche", "911", "Electric Car", "Sports car", 20000, true,
            2019, 20, 1000, null, 200, 500, 20);
    public static Car testAlfaRomeoGasCar = new Car("Alfa Romeo", "159", "Gas Car", "Entry-level luxury car", 1000, false,
            null, null, 50, 10, 20, 40, 5);
}
