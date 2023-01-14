package license.findBooking.factory;

import license.findBooking.domain.Country;
import license.findBooking.domain.dto.CountryDto;
import org.springframework.stereotype.Component;

@Component
public class CountryFactory {

    public Country toEntity(CountryDto countryDto) {
        Country country = new Country();

        country.setCountryId(countryDto.getCountryId());
        country.setName(countryDto.getName());

        return country;
    }
}
