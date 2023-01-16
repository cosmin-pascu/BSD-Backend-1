package license.findBooking.translator;


import license.findBooking.domain.Accommodation;
import license.findBooking.domain.City;
import license.findBooking.domain.Photo;
import license.findBooking.domain.dto.AccommodationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccommodationTranslatorTest {

    @InjectMocks
    private AccommodationTranslator accommodationTranslator;

    @Mock
    private CityTranslator cityTranslator;

    @Mock
    private PhotoTranslator photoTranslator;

    @Mock
    private Photo photo;

    @Mock
    private City city;

    @Mock
    private Accommodation accommodation;

    @Test
    public void testGenerateAccommodationDto() {
        AccommodationDto accommodationDto = new AccommodationDto();
        accommodationDto.setAccommodationId(1L);
        accommodationDto.setName("name");
        accommodationDto.setDescription("description");
        accommodationDto.setPhone("0123456789");
        accommodationDto.setNumberOfBookedSlots(2L);
        accommodationDto.setTotalNumberOfSlots(3L);
        accommodationDto.setPhoto(photoTranslator.generatePhotoDto(photo));
        accommodationDto.setCityDto(cityTranslator.generateCityDto(city));


        when(accommodation.getAccommodationId()).thenReturn(1L);
        when(accommodation.getName()).thenReturn("name");
        when(accommodation.getDescription()).thenReturn("description");
        when(accommodation.getPhone()).thenReturn("0123456789");
        when(accommodation.getNumberOfBookedSlots()).thenReturn(2L);
        when(accommodation.getTotalNumberOfSlots()).thenReturn(3L);
        when(accommodation.getPhoto()).thenReturn(photo);
        when(accommodation.getCity()).thenReturn(city);

        assertEquals(accommodationDto, accommodationTranslator.generateAccommodationDto(accommodation));
    }

    @Test
    public void testGenerateAccommodationDdtoList() {
        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(1L);
        accommodation.setName("name");
        accommodation.setDescription("description");
        accommodation.setPhone("0123456789");
        accommodation.setNumberOfBookedSlots(2L);
        accommodation.setTotalNumberOfSlots(3L);
        accommodation.setPhoto(photo);
        accommodation.setCity(city);

        AccommodationDto accommodationDto = new AccommodationDto();
        accommodationDto.setAccommodationId(1L);
        accommodationDto.setName("name");
        accommodationDto.setDescription("description");
        accommodationDto.setPhone("0123456789");
        accommodationDto.setNumberOfBookedSlots(2L);
        accommodationDto.setTotalNumberOfSlots(3L);
        accommodationDto.setPhoto(photoTranslator.generatePhotoDto(photo));
        accommodationDto.setCityDto(cityTranslator.generateCityDto(city));

        List<Accommodation> accommodationList = new ArrayList<>();
        List<AccommodationDto> accommodationDtoList = new ArrayList<>();
        accommodationList.add(accommodation);
        accommodationDtoList.add(accommodationDto);

        assertEquals(accommodationDtoList, accommodationTranslator.generateAccommodationDtoList(accommodationList));
    }
}