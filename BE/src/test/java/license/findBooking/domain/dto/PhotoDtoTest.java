package license.findBooking.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotoDtoTest {
    private PhotoDto photoDto;
    private byte[] testPhoto = {1,2,3,4};

    @BeforeEach
    void setUp() {
        photoDto = new PhotoDto();
        photoDto.setPhotoId(1L);
        photoDto.setPhoto(testPhoto);
    }

    @Test
    void testGetPhotoId() {
        assertEquals(1L, photoDto.getPhotoId());
    }

    @Test
    void testGetPhoto() {
        assertArrayEquals(testPhoto, photoDto.getPhoto());
    }
}