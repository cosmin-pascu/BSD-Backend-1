package license.findBooking.translator;

import license.findBooking.domain.Booking;
import license.findBooking.domain.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookingTranslator {

    private final AccommodationTranslator accommodationTranslator;

    public BookingDto generateBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();

        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setRooms(booking.getRooms());
        bookingDto.setNumberOfPeople(booking.getNumberOfPeople());
        bookingDto.setOtherDetails(booking.getOtherDetails());
        bookingDto.setAccommodationDto(accommodationTranslator.generateAccommodationDto(booking.getAccommodation()));

        return bookingDto;
    }

    public List<BookingDto> generateBookingDtoList(List<Booking> bookings) {
        return bookings.stream().map(this::generateBookingDto).collect(Collectors.toList());
    }
}
