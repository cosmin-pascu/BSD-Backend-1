package license.findBooking.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_id_seq_name")
    @SequenceGenerator(name = "bookings_id_seq_name", sequenceName = "bookings_id_seq", allocationSize = 1)
    private Long bookingId;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", foreignKey = @ForeignKey(name = "FK_booking_accommodation"))
    private Accommodation accommodation;

    @NotNull
    @Column(name = "check_in_date")
    private Date checkInDate;

    @NotNull
    @Column(name = "check_out_date")
    private Date checkOutDate;

    @NotNull
    @Column(name = "rooms")
    private Long rooms;

    @NotNull
    @Column(name = "number_of_people")
    private Long numberOfPeople;

    @Column(name = "other_details")
    private String otherDetails;

    public Booking updateFields(Booking booking) {
        this.checkInDate = booking.getCheckInDate();
        this.checkOutDate = booking.getCheckOutDate();
        this.rooms = booking.getRooms();
        this.numberOfPeople = booking.getNumberOfPeople();
        this.otherDetails = booking.getOtherDetails();

        return this;
    }

}
