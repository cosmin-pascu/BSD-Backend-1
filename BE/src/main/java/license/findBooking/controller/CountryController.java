package license.findBooking.controller;

import license.findBooking.domain.dto.CountryDto;
import license.findBooking.repository.CountryRepository;
import license.findBooking.translator.CountryTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryTranslator countryTranslator;

    private final CountryRepository countryRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.ok(countryTranslator.generateCountryDtoList(countryRepository.findAll()));
    }
}
