package license.findBooking.domain.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccommodationDtoTest {

    @Mock
    private PhotoDto mockPhotoDto;

    @Mock
    private CityDto mockCityDto;

    private AccommodationDto accommodationDto;

    @BeforeEach
    void setUp() {
        accommodationDto = new AccommodationDto();
        accommodationDto.setAccommodationId(1L);
        accommodationDto.setName("Test Accommodation");
        accommodationDto.setDescription("This is a test accommodation.");
        accommodationDto.setPhone("555-555-5555");
        accommodationDto.setNumberOfBookedSlots(5L);
        accommodationDto.setTotalNumberOfSlots(10L);
        accommodationDto.setPhoto(mockPhotoDto);
        accommodationDto.setCityDto(mockCityDto);
        accommodationDto.setAddress("123 Main St");
    }

    @Test
    void testGetAccommodationId() {
        assertEquals(1L, accommodationDto.getAccommodationId());
    }

    @Test
    void testGetName() {
        assertEquals("Test Accommodation", accommodationDto.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("This is a test accommodation.", accommodationDto.getDescription());
    }

    @Test
    void testGetPhone() {
        assertEquals("555-555-5555", accommodationDto.getPhone());
    }

    @Test
    void testGetNumberOfBookedSlots() {
        assertEquals(5L, accommodationDto.getNumberOfBookedSlots());
    }

    @Test
    void testGetTotalNumberOfSlots() {
        assertEquals(10L, accommodationDto.getTotalNumberOfSlots());
    }

    @Test
    void testGetPhoto() {
        assertEquals(mockPhotoDto, accommodationDto.getPhoto());
    }

    @Test
    void testGetCityDto() {
        assertEquals(mockCityDto, accommodationDto.getCityDto());
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Main St", accommodationDto.getAddress());
    }
}