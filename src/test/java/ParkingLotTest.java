import com.bridgelabz.entity.Attendant;
import com.bridgelabz.entity.Car;
import com.bridgelabz.services.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;

    @BeforeEach
    void init(){
        parkingLot = new ParkingLot(2);
    }

    //UC1
    @Test
    void givenCarId_carShouldBeParkedSuccessfully(){
        Car car1 = new Car("CR-ID-001", "Blue");
        parkingLot.parkCar(car1);
        assertTrue(parkingLot.check_parked("CR-ID-001"));
    }

    //UC2
    @Test
    void givenCarId_carShouldBeUnParkedSuccessfully(){
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
        parkingLot.unpark("CR-ID-001");
        assertFalse(parkingLot.check_parked("CR-ID-001"));
    }

    //UC4
    @Test
    void ifParkingLotFull_notifiesAirportSecurity(){
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
        parkingLot.parkCar(new Car("CR-ID-002", "Grey"));
        assertEquals("Please redirect Security staffs", parkingLot.check_parking_status());
    }

    //UC5
    @Test
    void ifParkingLotHasSpace_notifyOwnerTORemoveFullSign(){
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
        parkingLot.parkCar(new Car("CR-ID-002", "Grey"));
        assertEquals("Please redirect Security staffs", parkingLot.check_parking_status());

        parkingLot.unpark("CR-ID-002");
        assertEquals("Slots are available in the Parking lot.", parkingLot.check_parking_status());
    }

    //UC6
    @Test
    void givenCarIdAndAttendant_carShouldBeParkedSuccessfully(){
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"), new Attendant("Att-001"));
        assertTrue(parkingLot.parkCar(new Car("CR-ID-001", "Blue"),new Attendant("Att-001")));
    }

    //UC7
    @Test
    void givenCarId_ifExists_shouldReturnTrue(){
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
        assertTrue(parkingLot.check_parked("CR-ID-001"));
    }
}