package license.findBooking.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookingDtoTest {

    @Mock
    private AccommodationDto mockAccommodationDto;

    private BookingDto bookingDto;

    @BeforeEach
    void setUp() {
        bookingDto = new BookingDto();
        bookingDto.setBookingId(1L);
        bookingDto.setCheckInDate(new Date(1609459200000L));
        bookingDto.setCheckOutDate(new Date(1609545600000L));
        bookingDto.setRooms(2L);
        bookingDto.setNumberOfPeople(4L);
        bookingDto.setOtherDetails("Other details");
        bookingDto.setAccommodationDto(mockAccommodationDto);
    }

    @Test
    void testGetBookingId() {
        assertEquals(1L, bookingDto.getBookingId());
    }

    @Test
    void testGetCheckInDate() {
        assertEquals(new Date(1609459200000L), bookingDto.getCheckInDate());
    }

    @Test
    void testGetCheckOutDate() {
        assertEquals(new Date(1609545600000L), bookingDto.getCheckOutDate());
    }

    @Test
    void testGetRooms() {
        assertEquals(2L, bookingDto.getRooms());
    }

    @Test
    void testGetNumberOfPeople() {
        assertEquals(4L, bookingDto.getNumberOfPeople());
    }

    @Test
    void testGetOtherDetails() {
        assertEquals("Other details", bookingDto.getOtherDetails());
    }

    @Test
    void testGetAccommodationDto() {
        assertEquals(mockAccommodationDto, bookingDto.getAccommodationDto());
    }
}