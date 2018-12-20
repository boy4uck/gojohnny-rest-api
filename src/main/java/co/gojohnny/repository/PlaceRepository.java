package co.gojohnny.repository;

import co.gojohnny.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface PlaceRepository extends JpaRepository<Place, Long> {
    @RestResource(path = "/name")
    @Query("select p from Place p where p.name like concat('%', :query, '%')")
    List<Place> searchByName(@Param("query") String query);

    @RestResource(path = "/bounds")
    @Query("select p from Place p where st_y(p.location) >= :minLat and st_y(p.location) <= :maxLat and st_x(p.location) >= :minLng and st_x(p.location) <= :maxLng")
    List<Place> searchByBounds(@Param("minLat") double minLat, @Param("minLng") double minLng,
                               @Param("maxLat") double maxLat, @Param("maxLng") double maxLng);
}


