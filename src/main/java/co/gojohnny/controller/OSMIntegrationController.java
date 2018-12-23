package co.gojohnny.controller;

import co.gojohnny.OsmDto.OsmPlace;
import co.gojohnny.OsmService.OsmParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class OSMIntegrationController {

    private final OsmParser osmParser;

    public OSMIntegrationController(OsmParser osmParser) {

        this.osmParser = osmParser;
    }

    @GetMapping("/test")
    public void getElements(HttpServletResponse response) throws IOException{
        response.sendRedirect("https://www.openstreetmap.org/api/0.6/map?bbox=24.1734,48.2410,24.3732,48.3845");
    }

//    @GetMapping(value = "/test", produces = MediaType.APPLICATION_XML_VALUE)
//    public List<OsmPlace> getPlacesBySquare(HttpServletResponse response) throws IOException {
//
//
//    }
}
