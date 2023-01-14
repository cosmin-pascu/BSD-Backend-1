package license.findBooking.controller;

import license.findBooking.domain.dto.AccommodationDto;
import license.findBooking.domain.dto.FilterAccommodationDto;
import license.findBooking.repository.AccommodationRepository;
import license.findBooking.service.AccommodationService;
import license.findBooking.translator.AccommodationTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("accommodations")
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationRepository accommodationRepository;

    private final AccommodationTranslator accommodationTranslator;

    private final AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<AccommodationDto>> getAllAccommodations() {
        return ResponseEntity.ok(accommodationTranslator.generateAccommodationDtoList(accommodationRepository.findAll()));
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<AccommodationDto>> getAccommodationsFiltered(FilterAccommodationDto filterAccommodationDto) {
        return ResponseEntity.ok(accommodationTranslator.generateAccommodationDtoList(accommodationService.getAccommodationsFiltered(filterAccommodationDto)));
    }

    @GetMapping("/{accommodationId}")
    public ResponseEntity<AccommodationDto> getAccommodation(@PathVariable("accommodationId") Long accommodationId) {
        return accommodationService.findAccommodation(accommodationId)
                .map(accommodationTranslator::generateAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping("")
    public ResponseEntity<AccommodationDto> addAccommodation(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.addNewAccommodation(accommodationDto)
                .map(accommodationTranslator::generateAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping(value = "/{accommodationId}/upload-photo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadPhoto(@PathVariable("accommodationId") Long accommodationId, @RequestPart MultipartFile photo) {
        if (accommodationService.uploadPhoto(accommodationId, photo)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @PutMapping("/{accommodationId}")
    public ResponseEntity<AccommodationDto> editAccommodation(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.editAccommodation(accommodationDto)
                .map(accommodationTranslator::generateAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
