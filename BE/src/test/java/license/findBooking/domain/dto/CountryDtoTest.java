package license.findBooking.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDtoTest {

    private CountryDto countryDto;

    @BeforeEach
    void setUp() {
        countryDto = new CountryDto();
        countryDto.setCountryId(1L);
        countryDto.setName("Test Country");
    }

    @Test
    void testGetCountryId() {
        assertEquals(1L, countryDto.getCountryId());
    }

    @Test
    void testGetName() {
        assertEquals("Test Country", countryDto.getName());
    }
}