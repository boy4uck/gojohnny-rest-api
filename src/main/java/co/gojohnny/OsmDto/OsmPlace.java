package co.gojohnny.OsmDto;

import com.vividsolutions.jts.geom.Coordinate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class OsmPlace {

    private String name;

    private BigDecimal altitude;

    private Coordinate location;

    private Long osmId;

}
