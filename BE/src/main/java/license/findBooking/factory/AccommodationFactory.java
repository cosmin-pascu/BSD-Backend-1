package license.findBooking.factory;

import license.findBooking.domain.Accommodation;
import license.findBooking.domain.dto.AccommodationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccommodationFactory {

    private final CityFactory cityFactory;

    private final PhotoFactory photoFactory;

    public Accommodation toEntity(AccommodationDto accommodationDto) {
        Accommodation accommodation = new Accommodation();

        accommodation.setAccommodationId(accommodationDto.getAccommodationId());
        accommodation.setName(accommodationDto.getName());
        accommodation.setDescription(accommodationDto.getDescription());
        accommodation.setPhone(accommodationDto.getPhone());
        accommodation.setNumberOfBookedSlots(accommodationDto.getNumberOfBookedSlots());
        accommodation.setTotalNumberOfSlots(accommodationDto.getTotalNumberOfSlots());
        accommodation.setPhoto(photoFactory.toEntity(accommodationDto.getPhoto()));
        accommodation.setCity(cityFactory.toEntity(accommodationDto.getCityDto()));
        accommodation.setAddress(accommodationDto.getAddress());


        return accommodation;
    }

}
