package license.findBooking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotoTest {

    private Photo photo;

    @BeforeEach
    public void setUp() {
        photo = new Photo();
        photo.setPhotoId(1L);
        photo.setPhoto(new byte[]{1, 2, 3});
    }

    @Test
    public void getPhotoId() {
        assertEquals(1L, photo.getPhotoId());
    }

    @Test
    public void getPhoto() {
        assertArrayEquals(new byte[]{1, 2, 3}, photo.getPhoto());
    }
}