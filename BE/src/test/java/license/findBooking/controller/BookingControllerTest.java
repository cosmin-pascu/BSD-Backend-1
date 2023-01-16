package license.findBooking.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import license.findBooking.domain.Booking;
import license.findBooking.domain.dto.BookingDto;
import license.findBooking.service.BookingService;
import license.findBooking.translator.BookingTranslator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
    @Mock
    private BookingService bookingService;

    @Mock
    private BookingTranslator bookingTranslator;

    @InjectMocks
    private BookingController bookingController;

    @Test
    public void testAddBooking_Success() {
        BookingDto bookingDto = new BookingDto();
        when(bookingService.addNewBooking(any(BookingDto.class))).thenReturn(Optional.of(new Booking()));
        when(bookingTranslator.generateBookingDto(any(Booking.class))).thenReturn(new BookingDto());

        ResponseEntity<BookingDto> result = bookingController.addBooking(bookingDto);

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
