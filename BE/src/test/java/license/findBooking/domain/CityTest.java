package license.findBooking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CityTest {

    @Mock
    private Country country;

    private City city;

    @BeforeEach
    public void setUp() {
        city = new City();
        city.setCityId(1L);
        city.setName("cityName");
        city.setCountry(country);
    }

    @Test
    public void getCityId() {
        assertEquals(1L, city.getCityId());
    }

    @Test
    public void getName() {
        assertEquals("cityName", city.getName());
    }

    @Test
    public void getCountry() {
        assertEquals(country, city.getCountry());
    }
}