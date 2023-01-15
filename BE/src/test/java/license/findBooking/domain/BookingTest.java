package license.findBooking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookingTest {

    @Mock
    Accommodation accommodation;

    private Booking booking;

    private Booking booking2;
    
    @BeforeEach
    void setUp() {
        booking = new Booking();
        booking.setBookingId(1L);
        booking.setAccommodation(accommodation);
        booking.setCheckInDate(Date.valueOf(LocalDate.now()));
        booking.setCheckOutDate(Date.valueOf(LocalDate.now()));
        booking.setRooms(2L);
        booking.setNumberOfPeople(3L);
        booking.setOtherDetails("otherDetails");

        booking2 = new Booking();
        booking2.setBookingId(1L);
        booking2.setAccommodation(accommodation);
        booking2.setCheckInDate(Date.valueOf(LocalDate.now()));
        booking2.setCheckOutDate(Date.valueOf(LocalDate.now()));
        booking2.setRooms(3L);
        booking2.setNumberOfPeople(4L);
        booking2.setOtherDetails("otherDetails2");
    }
    
    @Test
    public void updateFields() {
        assertEquals(booking2, booking.updateFields(booking2));
    }

    @Test
    public void getBookingId() {
        assertEquals(1L, booking.getBookingId());
    }

    @Test
    public void getCheckInDate() {
        assertEquals(Date.valueOf(LocalDate.now()), booking.getCheckInDate());
    }

    @Test
    public void getCheckOutDate() {
        assertEquals(Date.valueOf(LocalDate.now()), booking.getCheckOutDate());
    }

    @Test
    public void getRooms() {
        assertEquals(2L, booking.getRooms());
    }

    @Test
    public void getNumberOfPeople() {
        assertEquals(3L, booking.getNumberOfPeople());
    }

    @Test
    void getOtherDetails() {
        assertEquals("otherDetails", booking.getOtherDetails());
    }
}