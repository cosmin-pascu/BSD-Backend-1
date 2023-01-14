package license.findBooking.factory;

import license.findBooking.domain.City;
import license.findBooking.domain.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityFactory {

    private final CountryFactory countryFactory;

    public City toEntity(CityDto cityDto) {
        City city = new City();

        city.setCityId(cityDto.getCityId());
        city.setName(cityDto.getName());
        city.setCountry(countryFactory.toEntity(cityDto.countryDto));

        return city;
    }
}
