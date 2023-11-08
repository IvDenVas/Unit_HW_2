package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Company", "Model1",2021);
        motorcycle = new Motorcycle("CompanyMotorcycle", "Model1", 2019);
    }

    @AfterEach
    void tearDown() {
        car = null;
        motorcycle = null;
    }

    @Test
    @DisplayName("Тест на проверку, что экземпляр объекта Car также является экземпляром Vehicle")
    void testInstanceOf() {
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    @DisplayName("Тест на проверку, что объект Car создается с 4-мя колесами")
    void testCarWithFourWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("Тест на проверку, что объект Motorcycle создается с 2-мя колесами")
    void testMotorcycleFourWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    @DisplayName("Тест на проверку, что объект Car развивает скорость 60 в режиме тестового вождения")
    void testCarMaxSpeedInTestDriving() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("Тест на проверку, что объект Motorcycle развивает скорость 75 в режиме тестового вождения")
    void testMotorcycleMaxSpeedInTestDriving() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("Тест на проверку, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения" +
            " транспорта) машина останавливается")
    void testCarParking() {
        car.testDrive();
        car.park();
        assertEquals(0,car.getSpeed());
    }

    @Test
    @DisplayName("Тест на проверку, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения" +
            " транспорта) мотоцикл останавливается")
    void testMotocycleParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}