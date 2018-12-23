package co.gojohnny.OsmService;

import co.gojohnny.OsmDto.OsmPlace;
import com.vividsolutions.jts.geom.Coordinate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@Component
public class OsmParser {

    public List<OsmPlace> getAll(File xmlFile) {
        List<OsmPlace> places = new ArrayList<>();
        List<Element> elements = getAllElementsFromsXML(xmlFile).get();

        for (Element element : elements) {
            places.add(mapToDto(element));
        }
        return places;
    }

    public OsmPlace mapToDto(Element element) {
        OsmPlace osmPlace = new OsmPlace();
        Coordinate coordinate = new Coordinate(Double.parseDouble(element.getElementsByAttribute("lat").val()),
                Double.parseDouble(element.getElementsByAttribute("lon").val()));

        osmPlace.setLocation(coordinate);
        osmPlace.setName(element.getElementsByAttribute("name").val());
        osmPlace.setAltitude(BigDecimal.valueOf(Long.parseLong(element.getElementsByAttribute("ele").val())));
        osmPlace.setOsmId(Long.parseLong(element.id()));
        return osmPlace;
    }

    private Optional<List<Element>> getAllElementsFromsXML(File xmlFile) {

        List<Element> notEmptyElements = new ArrayList<>();
        try {
            Document document = Jsoup.parse(
                    xmlFile,
                    "UTF-8",
                    xmlFile.getAbsolutePath());
            Elements elements = Optional.of(document.body().getAllElements()).get();

            notEmptyElements = elements.stream().filter(element -> !element.children().isEmpty()).collect(toList());
            return Optional.of(notEmptyElements);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
