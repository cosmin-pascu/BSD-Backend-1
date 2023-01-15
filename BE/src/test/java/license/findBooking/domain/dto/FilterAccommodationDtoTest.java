package license.findBooking.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterAccommodationDtoTest {
    private FilterAccommodationDto filterAccommodationDto;

    @BeforeEach
    void setUp() {
        filterAccommodationDto = new FilterAccommodationDto();
        filterAccommodationDto.setCountryName("Test Country");
        filterAccommodationDto.setCityName("Test City");
    }

    @Test
    void testGetCountryName() {
        assertEquals("Test Country", filterAccommodationDto.getCountryName());
    }

    @Test
    void testGetCityName() {
        assertEquals("Test City", filterAccommodationDto.getCityName());
    }
}