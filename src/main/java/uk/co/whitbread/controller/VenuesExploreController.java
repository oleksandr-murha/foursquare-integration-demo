package uk.co.whitbread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.whitbread.model.VenuesExploreResponse;
import uk.co.whitbread.properties.FoursquareProperties;

@RestController
public class VenuesExploreController {

    String url = "https://api.foursquare.com/v2/venues/explore?client_id=01SQBD4NF1YIWMEBJHB2VQG1HFKICH5XKT5WXQIMUQ012X3P&client_secret=PELK3BQ3DVRC4A24SPZSP5DUHPGIC5SEUORUAABNDFOI54GV&near=London&v=20140806&m=foursquare";

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/explore")
    public VenuesExploreResponse exploreVenue(String location) throws Exception {
        return restTemplate.getForObject(url, VenuesExploreResponse.class);
    }
}
