package co.gojohnny.repository;

import co.gojohnny.exceptions.RepositoryException;
import co.gojohnny.model.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("testing")
public class PhotoRepositoryTest {

    @Autowired
    private PhotoRepository photoRepository;

    @Test
    public void testSaveNewPhoto() {
        Photo photo = createTestPhoto();

        photoRepository.save(photo);

        assertNotNull(photo.getId());
    }

    private Photo createTestPhoto() {
        Photo photo = new Photo();
        photo.setUrl("http://testsite.com/path_to_photo");
        return photo;
    }

    @Test
    public void testUpdatePhotoUrl() {
        Photo photo = createTestPhoto();
        photoRepository.save(photo);

        Photo updatePhoto = photoRepository.findById(photo.getId()).get();
        updatePhoto.setUrl("http://anothersite.com/path_to_photo");

        assertTrue(updatePhoto.getUrl().contains("another"));
    }

    @Test(expected = RepositoryException.class)
    public void testRemovePhoto() {
        Photo photo = createTestPhoto();
        photoRepository.save(photo);

        photoRepository.delete(photo);

        photoRepository.findById(photo.getId()).orElseThrow(() -> {
            throw new RepositoryException("No such photo");
        });
    }

    @Test
    public void testGetPhoto() {
        Photo photo = createTestPhoto();
        photoRepository.save(photo);

        Photo photoFromRepository = photoRepository.getOne(photo.getId());

        assertThat(photo.getUrl(), is(photoFromRepository.getUrl()));
    }

    @Test(expected = RepositoryException.class)
    public void testGetNonExistingPhoto() {
        photoRepository.findById(10L).orElseThrow(() -> {
            throw new RepositoryException("No such photo");
        });
    }
}