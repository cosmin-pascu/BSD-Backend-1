package license.findBooking.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import license.findBooking.domain.Country;
import license.findBooking.domain.dto.CountryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CountryFactoryTest {

    @InjectMocks
    private CountryFactory countryFactory;

    @Mock
    private CountryDto countryDto;

    @Test
    public void testToEntity() {
        Long countryId = 1L;
        String name = "USA";

        when(countryDto.getCountryId()).thenReturn(countryId);
        when(countryDto.getName()).thenReturn(name);

        Country country = countryFactory.toEntity(countryDto);

        assertEquals(countryId, country.getCountryId());
        assertEquals(name, country.getName());
    }
}