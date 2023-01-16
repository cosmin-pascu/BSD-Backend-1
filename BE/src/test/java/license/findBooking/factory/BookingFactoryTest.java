package license.findBooking.factory;


import license.findBooking.domain.Accommodation;
import license.findBooking.domain.Booking;
import license.findBooking.domain.dto.AccommodationDto;
import license.findBooking.domain.dto.BookingDto;
import license.findBooking.repository.AccommodationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookingFactoryTest {

    @Mock
    private AccommodationFactory accommodationFactory;
    @Mock
    private AccommodationRepository accommodationRepository;

    private BookingFactory bookingFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookingFactory = new BookingFactory(accommodationFactory, accommodationRepository);
    }

    @Test
    public void testToEntity() {
        AccommodationDto accommodationDto = new AccommodationDto();
        accommodationDto.setAccommodationId(1L);
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(1L);
        bookingDto.setCheckInDate(new Date(1609459200000L));
        bookingDto.setCheckOutDate(new Date(1609545600000L));
        bookingDto.setRooms(2L);
        bookingDto.setNumberOfPeople(4L);
        bookingDto.setOtherDetails("test details");
        bookingDto.setAccommodationDto(accommodationDto);

        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(1L);
        when(accommodationRepository.findByAccommodationId(1L)).thenReturn(Optional.of(accommodation));

        Booking booking = bookingFactory.toEntity(bookingDto);

        assertEquals(booking.getBookingId(), bookingDto.getBookingId());
        assertEquals(booking.getCheckInDate(), bookingDto.getCheckInDate());
        assertEquals(booking.getCheckOutDate(), bookingDto.getCheckOutDate());
        assertEquals(booking.getRooms(), bookingDto.getRooms());
        assertEquals(booking.getNumberOfPeople(), bookingDto.getNumberOfPeople());
        assertEquals(booking.getOtherDetails(), bookingDto.getOtherDetails());
        assertEquals(booking.getAccommodation().getAccommodationId(), accommodationDto.getAccommodationId());
    }
}