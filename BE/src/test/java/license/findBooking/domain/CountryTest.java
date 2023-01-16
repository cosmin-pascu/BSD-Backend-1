package license.findBooking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CountryTest {

    private Country country;

    @BeforeEach
    public void setUp() {
        country = new Country();
        country.setCountryId(1L);
        country.setName("countryName");
    }

    @Test
    public void getCountryId() {
        assertEquals(1L, country.getCountryId());
    }

    @Test
    public void getName() {
        assertEquals("countryName", country.getName());
    }
}