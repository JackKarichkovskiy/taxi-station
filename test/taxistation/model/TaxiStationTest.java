/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import taxistation.model.cars.AbstractCar;
import taxistation.model.cars.concrete.PassengerCar;

/**
 * The Class that tests the taxi station functionality.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class TaxiStationTest {

    private static TaxiStation station;

    public TaxiStationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        station = new TaxiStation();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        station.addCar(new PassengerCar(5, "Audi", 200, 40, 30500, 240, AbstractCar.EngineType.Petrol));
        station.addCar(new PassengerCar(6, "Honda", 180, 35, 30100, 200, AbstractCar.EngineType.Petrol));
        station.addCar(new PassengerCar(4, "BMW", 220, 60, 40000, 260, AbstractCar.EngineType.Petrol));
    }

    @After
    public void tearDown() {
        station.clear();
    }

    /**
     * Test of addCar method, of class TaxiStation.
     */
    @Test
    public void testCarCreation() {
        System.out.println("carCreation");
        AbstractCar newCar = new PassengerCar(7, "Jeep", 250, 50, 50000, 100, AbstractCar.EngineType.Petrol);
    }

    /**
     * Test of addCar method, of class TaxiStation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCarCreationWithNullParameter() {
        System.out.println("сarCreationWithNullParameter");
        AbstractCar newCar = new PassengerCar(7, null, 250, 50, 50000, 100, AbstractCar.EngineType.Petrol);
    }

    /**
     * Test of addCar method, of class TaxiStation.
     */
    @Test
    public void testAddCar() {
        System.out.println("addCar");
        AbstractCar newCar = new PassengerCar(7, "Jeep", 250, 50, 50000, 100, AbstractCar.EngineType.Petrol);
        station.addCar(newCar);
        Assert.assertEquals(4, station.getCarCount());
    }

    /**
     * Test of addCar method, of class TaxiStation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCar() {
        System.out.println("addNullCar");
        AbstractCar newCar = null;
        station.addCar(newCar);
    }

    /**
     * Test of removeCar method, of class TaxiStation.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("removeCar");
        AbstractCar car = new PassengerCar(6, "Honda", 180, 35, 30100, 200, AbstractCar.EngineType.Petrol);
        boolean expResult = true;
        boolean result = station.removeCar(car);
        assertEquals(2, station.getCarCount());
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCar method, of class TaxiStation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullCar() {
        System.out.println("removeNullCar");
        AbstractCar car = null;
        station.removeCar(car);
    }
    
    /**
     * Test of getTaxiStationCost method, of class TaxiStation.
     */
    @Test
    public void testGetTaxiStationCost() {
        System.out.println("getTaxiStationCost");
        int expResult = 100600;
        int result = station.getTaxiStationCost();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getTaxiStationCost method, of class TaxiStation.
     */
    @Test
    public void testGetClearedTaxiStationCost() {
        System.out.println("getClearedTaxiStationCost");
        station.clear();
        int expResult = 0;
        int result = station.getTaxiStationCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of sortCarsByFuelConsumption method, of class TaxiStation.
     */
    @Test
    public void testSortCarsByFuelConsumption() {
        System.out.println("sortCarsByFuelConsumption");
        station.sortCarsByFuelConsumption();
        List<AbstractCar> expResult = new ArrayList<>();
        expResult.add(new PassengerCar(6, "Honda", 180, 35, 30100, 200, AbstractCar.EngineType.Petrol));
        expResult.add(new PassengerCar(5, "Audi", 200, 40, 30500, 240, AbstractCar.EngineType.Petrol));
        expResult.add(new PassengerCar(4, "BMW", 220, 60, 40000, 260, AbstractCar.EngineType.Petrol));
        assertArrayEquals(expResult.toArray(), station.getCars().toArray());
    }

    /**
     * Test of findCarWithSpeedInRangeOf method, of class TaxiStation.
     */
    @Test
    public void testFindCarWithSpeedInRangeOf() {
        System.out.println("findCarWithSpeedInRangeOf");
        int speedMin = 220;
        int speedMax = 250;
        AbstractCar expResult = new PassengerCar(5, "Audi", 200, 40, 30500, 240, AbstractCar.EngineType.Petrol);
        AbstractCar result = station.findCarWithSpeedInRangeOf(speedMin, speedMax);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findCarWithSpeedInRangeOf method, of class TaxiStation.
     */
    @Test
    public void testFindCarWithSpeedInInverseRangeOf() {
        System.out.println("findCarWithSpeedInInverseRangeOf");
        int speedMin = 250;
        int speedMax = 220;
        AbstractCar result = station.findCarWithSpeedInRangeOf(speedMin, speedMax);
        assertNull(result);
    }
    
    /**
     * Test of findCarWithSpeedInRangeOf method, of class TaxiStation.
     */
    @Test
    public void testFindCarWithSpeed() {
        System.out.println("findCarWithSpeed");
        int speedMin = 200;
        int speedMax = 200;
        AbstractCar expResult = new PassengerCar(6, "Honda", 180, 35, 30100, 200, AbstractCar.EngineType.Petrol);
        AbstractCar result = station.findCarWithSpeedInRangeOf(speedMin, speedMax);
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class TaxiStation.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        station.clear();
        assertEquals(station.getCarCount(), 0);
    }

}
