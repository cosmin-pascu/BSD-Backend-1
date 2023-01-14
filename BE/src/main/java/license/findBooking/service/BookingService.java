package license.findBooking.service;

import license.findBooking.domain.Accommodation;
import license.findBooking.domain.Booking;
import license.findBooking.domain.dto.AccommodationDto;
import license.findBooking.domain.dto.BookingDto;
import license.findBooking.factory.BookingFactory;
import license.findBooking.repository.AccommodationRepository;
import license.findBooking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingFactory bookingFactory;

    private final AccommodationRepository accommodationRepository;

    private final BookingRepository bookingRepository;

    public Optional<Booking> addNewBooking(BookingDto bookingDto) {
        Booking bookingToSave = bookingFactory.toEntity(bookingDto);
        Accommodation accommodationToBook = accommodationRepository.findByAccommodationId(bookingToSave.getAccommodation().getAccommodationId()).get();
        bookingToSave.setAccommodation(accommodationRepository.findByAccommodationId(bookingToSave.getAccommodation().getAccommodationId()).get());

        if(accommodationToBook.getNumberOfBookedSlots() + bookingToSave.getRooms() <= accommodationToBook.getTotalNumberOfSlots()) {
            accommodationToBook.setNumberOfBookedSlots(accommodationToBook.getNumberOfBookedSlots() + bookingToSave.getRooms());
            return Optional.of(bookingRepository.save(bookingToSave));
        }

        return Optional.empty();
    }
}
