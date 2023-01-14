package license.findBooking.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import license.findBooking.domain.Accommodation;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties
public class BookingDto {

    private Long bookingId;

    private Date checkInDate;

    private Date checkOutDate;

    private Long rooms;

    private Long numberOfPeople;

    private String otherDetails;

    @JsonProperty("accommodation")
    public AccommodationDto accommodationDto;
}
