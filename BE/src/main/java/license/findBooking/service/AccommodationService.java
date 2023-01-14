package license.findBooking.service;

import license.findBooking.domain.Accommodation;
import license.findBooking.domain.Photo;
import license.findBooking.domain.dto.FilterAccommodationDto;
import license.findBooking.domain.dto.AccommodationDto;
import license.findBooking.factory.AccommodationFactory;
import license.findBooking.repository.CityRepository;
import license.findBooking.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    private final PhotoService photoService;

    private final AccommodationFactory accommodationFactory;

    private final CityRepository cityRepository;

    public boolean uploadPhoto(Long accommodationId, MultipartFile photo) {
        Optional<Accommodation> existingAccommodation = accommodationRepository.findById(accommodationId);
        Optional<Photo> savedPhoto = photoService.savePhoto(photo);

        if (existingAccommodation.isEmpty() || savedPhoto.isEmpty()) {
            return false;
        }

        existingAccommodation.ifPresent(accommodation -> {
            accommodation.setPhoto(savedPhoto.get());
            saveOrUpdate(accommodation);
        });

        return true;
    }

    public Optional<Accommodation> addNewAccommodation(AccommodationDto accommodationDto) {
        Accommodation accommodationToSave = accommodationFactory.toEntity(accommodationDto);

        accommodationToSave.setCity(cityRepository.findByCityId(accommodationToSave.getCity().getCityId()).get());

        return Optional.of(accommodationRepository.save(accommodationToSave));
    }

    public Accommodation saveOrUpdate(Accommodation accommodation) {
        return accommodationRepository.save(
                accommodationRepository.findByAccommodationId(accommodation.getAccommodationId())
                        .map(existingAccommodation -> existingAccommodation.updateFields(accommodation))
                        .orElseGet(() -> accommodation)
        );
    }

    public Optional<Accommodation> editAccommodation(AccommodationDto accommodationDto) {
        Accommodation updatedAccommodation = accommodationFactory.toEntity(accommodationDto);

        return accommodationRepository.findByAccommodationId(accommodationDto.accommodationId)
                .map(existingAccommodation -> {
                    existingAccommodation.updateFields(updatedAccommodation);
                    return accommodationRepository.save(updatedAccommodation);
                });
    }

    public Optional<Accommodation> findAccommodation(Long accommodationId) {
        return accommodationRepository.findAll().stream().filter(accommodation -> accommodation.getAccommodationId().equals(accommodationId)).findFirst();
    }

    public List<Accommodation> getAccommodationsFiltered(FilterAccommodationDto filterAccommodationDto) {
        return accommodationRepository.findAll().stream().filter(accommodation -> doesAccommodationMatchAllFilters(accommodation, filterAccommodationDto)).collect(Collectors.toList());
    }

    public boolean doesAccommodationMatchAllFilters(Accommodation accommodation, FilterAccommodationDto filterAccommodationDto) {
        if (!Objects.isNull(filterAccommodationDto.getCountryName()) && !accommodation.getCity().getCountry().getName().equals(filterAccommodationDto.getCountryName())) {
            return false;
        }

        if (!Objects.isNull(filterAccommodationDto.getCityName()) && !accommodation.getCity().getName().equals(filterAccommodationDto.getCityName())) {
            return false;
        }

        return true;
    }
}
