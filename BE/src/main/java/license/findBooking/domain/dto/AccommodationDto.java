package license.findBooking.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class AccommodationDto {

    public Long accommodationId;

    public String name;

    public String description;

    public String phone;

    public Long numberOfBookedSlots;

    public Long totalNumberOfSlots;

    public PhotoDto photo;

    @JsonProperty("city")
    public CityDto cityDto;

    public String address;
}
