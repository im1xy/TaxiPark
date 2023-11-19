package main.Cars;

public interface AvailableCars {
    static String[] getCarTypes() {
        return new String[]{"", "Petrol Car", "Electric Car", "Gas Car"};
    }

    static String[] getCarClasses() {
        return new String[] {"", "Microcar", "Subcompact car", "Compact car", "Mid-size car", "Entry-level luxury car",
                "Full-size car", "Mid-size luxury car", "Full-size luxury car", "Sports car", "Grand tourer", "Supercar",
                "Convertible", "Roadster", "Compact minivan", "Minivan", "Mini SUV", "Compact SUV", "Mid-size SUV",
                "Full-size SUV", "Mini pickup truck", "Mid-size pickup truck", "Pickup truck"};
    }
}
