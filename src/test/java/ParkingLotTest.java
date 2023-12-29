import com.bridgelabz.entity.Car;
import com.bridgelabz.services.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;

    @BeforeEach
    void init(){
        parkingLot = new ParkingLot();
    }

    @Test
    void givenCarId_carShouldBeParkedSuccessfully(){
        Car car1 = new Car("CR-ID-001", "Blue");
        parkingLot.parkCar(car1);
        assertTrue(parkingLot.check_parked("CR-ID-001"));
    }
}