package license.findBooking.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import license.findBooking.domain.City;
import license.findBooking.domain.Country;
import license.findBooking.domain.dto.CityDto;
import license.findBooking.domain.dto.CountryDto;
import license.findBooking.factory.CityFactory;
import license.findBooking.factory.CountryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CityFactoryTest {
    @Mock
    private CountryFactory countryFactory;

    private CityFactory cityFactory;

    @BeforeEach
    public void setUp() {
        cityFactory = new CityFactory(countryFactory);
    }

    @Test
    public void testToEntity() {
        CityDto cityDto = new CityDto();
        cityDto.setCityId(1L);
        cityDto.setName("Test City");
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(1L);
        countryDto.setName("Test Country");
        cityDto.setCountryDto(countryDto);

        Country country = new Country();
        country.setCountryId(1L);
        country.setName("Test Country");
        when(countryFactory.toEntity(countryDto)).thenReturn(country);

        City city = cityFactory.toEntity(cityDto);

        assertEquals(1L, city.getCityId());
        assertEquals("Test City", city.getName());
        assertEquals(country, city.getCountry());
    }
}