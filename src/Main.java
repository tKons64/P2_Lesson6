import Driver.Driver;
import Transports.Bus;
import Transports.Car;
import Transports.Transport;
import Transports.Truck;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException, IllegalAccessException {

        Car car1 = new Car("LADA", "2105", 0);
        Car car2 = new Car("LADA", "2105", 0);
        Car car3 = new Car("LADA", "2105", 0);
        Car car4 = new Car("LADA", "2105", 0);

        Truck truck1 = new Truck("КАМАЗ", "2105", 0);
        Truck truck2 = new Truck("КАМАЗ", "2105", 0);
        Truck truck3 = new Truck("КАМАЗ", "2105", 0);
        Truck truck4 = new Truck("КАМАЗ", "2105", 0);

        Bus bus1 = new Bus("ЛИАЗ", "2105", 0);
        Bus bus2 = new Bus("ЛИАЗ", "2105", 0);
        Bus bus3 = new Bus("ЛИАЗ", "2105", 0);
        Bus bus4 = new Bus("ЛИАЗ", "2105", 0);

        car1.pitStop();
        System.out.println(car2.bestLapTime());
        System.out.println(car3.maxSpeed());

        truck1.pitStop();
        System.out.println(truck2.bestLapTime());
        System.out.println(truck3.maxSpeed());

        bus1.pitStop();
        System.out.println(bus2.bestLapTime());
        System.out.println(bus3.maxSpeed());

        Driver<Car> DriverCar = new Driver<>("DriverCar", 10, car1);
        Driver<Truck> DriverTruck = new Driver<>("DriverTruck", 2, truck1);
        Driver<Bus> DriverBus = new Driver<>("DriverBus", 7, bus1);
        System.out.println(DriverCar);
        System.out.println(DriverTruck);
        System.out.println(DriverBus);

        // Урок 5. Домашние задания
//        System.out.println("");
//        bus1.setType(Bus.Capacity.MEDIUM);
//        System.out.println("Автобус - " + bus1.getBrand() +
//                " " + bus1.getModel() +
//                ", вместимость пассажиров - " + bus1.printType());
//        truck1.setType(Truck.LoadCapacity.N2);
//        System.out.println("Грузовик - " + truck1.getBrand() +
//                " " + truck1.getModel() +
//                ", грузопадъемность - " + truck1.printType());
//        System.out.println("Грузовик - " + truck2.getBrand() +
//                " " + truck2.getModel() +
//                ", грузопадъемность - " + truck2.printType());

        // Урок 6. Домашние задания
        // Домашнее задание №1
        System.out.println("");
        System.out.println("Домашнее задание №1. Урок 6");
        String login = "123123qweq_";
        try {
            Data.loginPasswordCheck(login,
                    "233",
                    "23");
        } catch (WrongLoginException|WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

        // Домашнее задание №2
        System.out.println("");
        System.out.println("Домашнее задание №2. Урок 6");
        car2.setDiagnosticsPassed(true);
        car4.setDiagnosticsPassed(true);
        truck1.setDiagnosticsPassed(true);
        truck3.setDiagnosticsPassed(true);

        checkTransportMaintenance(
                car1, car2, car3, car4,
                truck1, truck2, truck3, truck4,
                bus1, bus2, bus3, bus4
        );
    }

    public static void checkTransportMaintenance(Transport...transports) {
        int count = 0;
        for (Transport transport: transports) {
            if (!transport.checkDiagnostics()) {
                try {
                    throw new RuntimeException("Автомомбиль " + transport.getBrand() + " " + transport.getModel() + " не прошел диагностику!");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                count++;
            }
        }
        System.out.println("Диагностику прошли " + count + " из " + transports.length + " автомобилей");
    }
}