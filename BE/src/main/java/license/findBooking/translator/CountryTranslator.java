package license.findBooking.translator;

import license.findBooking.domain.Country;
import license.findBooking.domain.dto.CountryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryTranslator {

    public CountryDto generateCountryDto(Country country) {
        CountryDto countryDto = new CountryDto();

        countryDto.setCountryId(country.getCountryId());
        countryDto.setName(country.getName());

        return countryDto;
    }

    public List<CountryDto> generateCountryDtoList(List<Country> countries) {
        return countries.stream().map(this::generateCountryDto).collect(Collectors.toList());
    }
}
