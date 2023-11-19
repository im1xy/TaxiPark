package main.Cars;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    // Main Information
    private String brand;
    private String name;
    private String type;
    private String carClass;
    private Integer price;
    private Boolean availability;

    // Characteristics
    private Integer productionYear;
    private Integer yearsInUse;
    private Integer weight;
    private Integer wheelDiameter;
    private Integer maximumSpeed;
    private Integer fuelCapacity;
    private Integer fuelUsePer100km;

    public Car(String brand, String name, String type, String carClass, Integer price, Boolean availability,
               Integer productionYear, Integer yearsInUse, Integer weight, Integer wheelDiameter,
               Integer maximumSpeed, Integer fuelCapacity, Integer fuelUsePer100km) {
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.carClass = carClass;
        this.price = price;
        this.availability = availability;
        this.productionYear = productionYear;
        this.yearsInUse = yearsInUse;
        this.weight = weight;
        this.wheelDiameter = wheelDiameter;
        this.maximumSpeed = maximumSpeed;
        this.fuelCapacity = fuelCapacity;
        this.fuelUsePer100km = fuelUsePer100km;
    }

    @Override
    public String toString() {
        return  "brand='" + brand + "'" +
                "\nname='" + name + "'" +
                "\ntype='" + type + "'" +
                "\ncarClass='" + carClass + "'" +
                "\nprice=" + price +
                "\nisAvailable=" + availability +
                "\nproductionYear=" + productionYear +
                "\nyearsInUse=" + yearsInUse +
                "\nweight=" + weight +
                "\nwheelDiameter=" + wheelDiameter +
                "\nmaximumSpeed=" + maximumSpeed +
                "\nfuelCapacity=" + fuelCapacity +
                "\nfuelUsePer100km=" + fuelUsePer100km +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(name, car.name) && Objects.equals(type, car.type) && Objects.equals(carClass, car.carClass) && Objects.equals(price, car.price) && Objects.equals(availability, car.availability) && Objects.equals(productionYear, car.productionYear) && Objects.equals(yearsInUse, car.yearsInUse) && Objects.equals(weight, car.weight) && Objects.equals(wheelDiameter, car.wheelDiameter) && Objects.equals(maximumSpeed, car.maximumSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, name, type, carClass, price, availability, productionYear, yearsInUse, weight, wheelDiameter, maximumSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYearsInUse() {
        return yearsInUse;
    }

    public void setYearsInUse(Integer yearsInUse) {
        this.yearsInUse = yearsInUse;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(Integer wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public Boolean isAvailable() {
        return availability;
    }

    public void setAvailable(Boolean available) {
        availability = available;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Integer getFuelUsePer100km() {
        return fuelUsePer100km;
    }

    public void  setFuelUsagePer100km(Integer fuelUsePer100km) {
        this.fuelUsePer100km = fuelUsePer100km;
    }
}
