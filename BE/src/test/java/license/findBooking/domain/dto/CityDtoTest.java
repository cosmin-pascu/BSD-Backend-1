package license.findBooking.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CityDtoTest {

    @Mock
    private CountryDto mockCountryDto;

    private CityDto cityDto;

    @BeforeEach
    void setUp() {
        cityDto = new CityDto();
        cityDto.setCityId(1L);
        cityDto.setName("Test City");
        cityDto.setCountryDto(mockCountryDto);
    }

    @Test
    void testGetCityId() {
        assertEquals(1L, cityDto.getCityId());
    }

    @Test
    void testGetName() {
        assertEquals("Test City", cityDto.getName());
    }

    @Test
    void testGetCountryDto() {
        assertEquals(mockCountryDto, cityDto.getCountryDto());
    }
}