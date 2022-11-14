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

    private final String VALID_DRIVING_LICENSE = "ABCDE";

    public Driver(String fullName, int experienceYears, T transport) throws IllegalAccessException {
        this.fullName = fullName;
        this.experienceYears = experienceYears;
        this.transport = transport;
        if (Car.class.equals(transport.getClass())) {
            this.setCategoryDrivingLicense("B");
        } else if (Truck.class.equals(transport.getClass())) {
            this.setCategoryDrivingLicense("C");
        } else if (Bus.class.equals(transport.getClass())) {
            this.setCategoryDrivingLicense("D");
        } else {
            this.setCategoryDrivingLicense("?");
        }

    }

    public String getName() {
        return fullName;
    }

    public String getDrivingLicense() {
        return categoryDrivingLicense;
    }

    public void setCategoryDrivingLicense(String categoryDrivingLicense) throws IllegalAccessException {
        if (categoryDrivingLicense == null) {
            throw new IllegalAccessException("Необходимо указать категорию прав!");
        } else {
            for (int i = 0; i < categoryDrivingLicense.length(); i++) {
                if (!VALID_DRIVING_LICENSE.contains(String.valueOf(categoryDrivingLicense.charAt(i)))) {
                    throw new IllegalAccessException("Указанна не верная категория прав!");
                }
            }
        }
        this.categoryDrivingLicense = categoryDrivingLicense;
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
