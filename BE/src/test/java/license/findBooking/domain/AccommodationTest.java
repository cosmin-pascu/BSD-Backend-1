package license.findBooking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccommodationTest {

    @Mock
    private Photo mockPhoto;

    @Mock
    private City mockCity;

    private Accommodation accommodationMock;

    private Accommodation accommodation;

    @BeforeEach
    void setUp() {
        accommodation = new Accommodation();
        accommodation.setAccommodationId(1L);
        accommodation.setName("Test Accommodation");
        accommodation.setDescription("Test Description");
        accommodation.setPhone("1234567890");
        accommodation.setNumberOfBookedSlots(0L);
        accommodation.setTotalNumberOfSlots(10L);
        accommodation.setPhoto(mockPhoto);
        accommodation.setCity(mockCity);
        accommodation.setAddress("Test Address");

        accommodationMock = new Accommodation();
        accommodationMock.setAccommodationId(1L);
        accommodationMock.setName("Test Accommodation2");
        accommodationMock.setDescription("Test Description2");
        accommodationMock.setPhone("12345678902");
        accommodationMock.setNumberOfBookedSlots(1L);
        accommodationMock.setTotalNumberOfSlots(11L);
        accommodationMock.setPhoto(mockPhoto);
        accommodationMock.setCity(mockCity);
        accommodationMock.setAddress("Test Address2");
    }

    @Test
    public void testGetters() {
        assertEquals(1L, accommodation.getAccommodationId());
        assertEquals("Test Accommodation", accommodation.getName());
        assertEquals("Test Description", accommodation.getDescription());
        assertEquals("1234567890", accommodation.getPhone());
        assertEquals(0L, accommodation.getNumberOfBookedSlots());
        assertEquals(10L, accommodation.getTotalNumberOfSlots());
        assertEquals(mockPhoto, accommodation.getPhoto());
        assertEquals(mockCity, accommodation.getCity());
        assertEquals("Test Address", accommodation.getAddress());
    }

    @Test
    public void testUpdateFields() {
        assertEquals(accommodationMock, accommodation.updateFields(accommodationMock));
    }
}