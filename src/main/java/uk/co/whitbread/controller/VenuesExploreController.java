package uk.co.whitbread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.whitbread.model.VenuesExploreResponse;
import uk.co.whitbread.utils.UrlBuilder;

@RestController
public class VenuesExploreController {

    @Autowired
    private UrlBuilder urlBuilder;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/exploreVenue")
    public VenuesExploreResponse exploreVenue(@RequestParam String location) throws Exception {
        return restTemplate.getForObject(urlBuilder.buildUrl(location), VenuesExploreResponse.class);
    }
}
