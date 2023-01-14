package license.findBooking.factory;

import license.findBooking.domain.Photo;
import license.findBooking.domain.dto.PhotoDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhotoFactory {

    public Photo toEntity(PhotoDto photoDto) {
        if (Objects.isNull(photoDto)) {
            return null;
        }

        Photo photo = new Photo();

        photo.setPhotoId(photoDto.getPhotoId());
        photo.setPhoto(photoDto.getPhoto());

        return photo;
    }
}
