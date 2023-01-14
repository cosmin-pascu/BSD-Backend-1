package license.findBooking.repository;

import license.findBooking.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    Optional<Accommodation> findByAccommodationId(Long accommodationId);

    List<Accommodation> findAll();
}