package Driver;

import Transports.Bus;
import Transports.Car;
import Transports.Transport;
import Transports.Truck;

public class Driver<T extends Transport>{

    private String fullName;

    private String categoryDrivingLicense;

    private int experienceYears;

    private T transport;

    public Driver(String fullName, int experienceYears, T transport) {
        this.fullName = fullName;
        this.experienceYears = experienceYears;
        this.transport = transport;
        if (Car.class.equals(transport.getClass())) {
            this.categoryDrivingLicense = "B";
        } else if (Truck.class.equals(transport.getClass())) {
            this.categoryDrivingLicense = "С";
        } else if (Bus.class.equals(transport.getClass())) {
            this.categoryDrivingLicense = "D";
        } else {
            this.categoryDrivingLicense = "?";
        }

    }

    public String getName() {
        return fullName;
    }

    public String getDrivingLicense() {
        return categoryDrivingLicense;
    }

    public int getExperience() {
        return experienceYears;
    }

    public void setExperience(int experience) {
        this.experienceYears = experience;
    }

    public T getTransport() {
        return transport;
    }

    @Override
    public String toString() {
        return "Водитель " + getName() +
                " категории *" + getDrivingLicense() + "* " +
                " управляет автомобилем " +
                getTransport().toString() +
                " и будет участвовать в заезде";
    }
}
