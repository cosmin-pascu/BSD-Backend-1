package license.findBooking.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class FilterAccommodationDto {
    public String countryName;

    public String cityName;
}
