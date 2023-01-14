package license.findBooking.controller;

import license.findBooking.domain.dto.BookingDto;
import license.findBooking.service.BookingService;
import license.findBooking.translator.BookingTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    private final BookingTranslator bookingTranslator;
    @PostMapping("")
    public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto) {

        if(bookingService.addNewBooking(bookingDto).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return bookingService.addNewBooking(bookingDto)
                    .map(bookingTranslator::generateBookingDto)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
        }
    }
}
