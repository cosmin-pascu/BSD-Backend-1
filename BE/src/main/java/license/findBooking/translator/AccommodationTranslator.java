package license.findBooking.translator;

import license.findBooking.domain.Accommodation;
import license.findBooking.domain.dto.AccommodationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccommodationTranslator {

    private final CityTranslator cityTranslator;

    private final PhotoTranslator photoTranslator;

    public AccommodationDto generateAccommodationDto(Accommodation accommodation) {
        AccommodationDto accommodationDto = new AccommodationDto();

        accommodationDto.setAccommodationId(accommodation.getAccommodationId());
        accommodationDto.setName(accommodation.getName());
        accommodationDto.setDescription(accommodation.getDescription());
        accommodationDto.setPhone(accommodation.getPhone());
        accommodationDto.setNumberOfBookedSlots(accommodation.getNumberOfBookedSlots());
        accommodationDto.setTotalNumberOfSlots(accommodation.getTotalNumberOfSlots());
        accommodationDto.setPhoto(photoTranslator.generatePhotoDto(accommodation.getPhoto()));
        accommodationDto.setCityDto(cityTranslator.generateCityDto(accommodation.getCity()));

        return accommodationDto;
    }

    public List<AccommodationDto> generateAccommodationDtoList(List<Accommodation> accommodations) {
        return accommodations.stream().map(this::generateAccommodationDto).collect(Collectors.toList());
    }

}
