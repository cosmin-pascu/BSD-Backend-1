package license.findBooking.factory;

import license.findBooking.domain.Booking;
import license.findBooking.domain.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingFactory {

    private final AccommodationFactory accommodationFactory;

    public Booking toEntity(BookingDto bookingDto) {
        Booking booking = new Booking();

        booking.setBookingId(bookingDto.getBookingId());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setRooms(bookingDto.getRooms());
        booking.setNumberOfPeople(bookingDto.getNumberOfPeople());
        booking.setOtherDetails(bookingDto.getOtherDetails());
        booking.setAccommodation(accommodationFactory.toEntity(bookingDto.getAccommodationDto()));

        return booking;
    }
}
