package license.findBooking.factory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import license.findBooking.domain.Photo;
import license.findBooking.domain.dto.PhotoDto;
import org.junit.jupiter.api.Test;

public class PhotoFactoryTest {

    private final PhotoFactory photoFactory = new PhotoFactory();

    @Test
    public void whenPhotoDtoIsNull_thenReturnNull() {
        PhotoDto photoDto = null;

        Photo result = photoFactory.toEntity(photoDto);

        assertNull(result);
    }

    @Test
    public void whenPhotoDtoIsNotNull_thenReturnPhoto() {
        Long photoId = 1L;
        byte[] photo = new byte[]{1, 2, 3};

        PhotoDto photoDto = new PhotoDto();
        photoDto.setPhotoId(photoId);
        photoDto.setPhoto(photo);

        Photo result = photoFactory.toEntity(photoDto);

        assertEquals(photoId, result.getPhotoId());
        assertArrayEquals(photo, result.getPhoto());
    }
}