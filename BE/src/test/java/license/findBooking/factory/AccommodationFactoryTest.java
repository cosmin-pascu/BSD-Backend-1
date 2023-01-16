package license.findBooking.factory;

import license.findBooking.domain.Accommodation;
import license.findBooking.domain.City;
import license.findBooking.domain.Photo;
import license.findBooking.domain.dto.AccommodationDto;
import license.findBooking.domain.dto.CityDto;
import license.findBooking.domain.dto.PhotoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccommodationFactoryTest {
    private AccommodationFactory accommodationFactory;

    private Accommodation accommodation;

    private AccommodationDto accommodationDto;

    @Mock
    private PhotoDto mockPhotoDto;

    @Mock
    private CityDto mockCityDto;

    @Mock
    private Photo mockPhoto;

    @Mock
    private City mockCity;

    @BeforeEach
    public void setUp() {
        CityFactory cityFactory = Mockito.mock(CityFactory.class);
        PhotoFactory photoFactory = Mockito.mock(PhotoFactory.class);
        accommodationFactory = new AccommodationFactory(cityFactory, photoFactory);

        accommodationDto = new AccommodationDto();
        accommodationDto.setAccommodationId(1L);
        accommodationDto.setName("Test Accommodation");
        accommodationDto.setDescription("Test Description");
        accommodationDto.setPhone("1234567890");
        accommodationDto.setNumberOfBookedSlots(0L);
        accommodationDto.setTotalNumberOfSlots(10L);
        accommodationDto.setPhoto(mockPhotoDto);
        accommodationDto.setCityDto(mockCityDto);
        accommodationDto.setAddress("Test Address");

        accommodation = new Accommodation();
        accommodation.setAccommodationId(1L);
        accommodation.setName("Test Accommodation");
        accommodation.setDescription("Test Description");
        accommodation.setPhone("1234567890");
        accommodation.setNumberOfBookedSlots(0L);
        accommodation.setTotalNumberOfSlots(10L);
        accommodation.setPhoto(mockPhoto);
        accommodation.setCity(mockCity);
        accommodation.setAddress("Test Address");
    }

    @Test
    public void testToEntity() {
        assertEquals(accommodation, accommodationFactory.toEntity(accommodationDto));
    }
}