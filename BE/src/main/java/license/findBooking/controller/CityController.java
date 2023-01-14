package license.findBooking.controller;

import license.findBooking.domain.dto.CityDto;
import license.findBooking.repository.CityRepository;
import license.findBooking.translator.CityTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityController {

    private final CityTranslator cityTranslator;

    private final CityRepository cityRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCountries() {
        return ResponseEntity.ok(cityTranslator.generateCityDtoList(cityRepository.findAll()));
    }

}
