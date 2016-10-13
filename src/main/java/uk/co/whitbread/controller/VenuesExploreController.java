package uk.co.whitbread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.co.whitbread.client.FoursquareClient;

@Controller
public class VenuesExploreController {

    private static final String TYPE_LOCATION = "Please type location into search box";
    private static final String RECOMENDED_PLACES = "Recommended locations around %s!";

    private FoursquareClient foursquareClient;

    @Autowired
    public VenuesExploreController(FoursquareClient foursquareClient) {
        this.foursquareClient = foursquareClient;
    }

    @RequestMapping("/explore.html")
    public String exploreVenue(@RequestParam(required = false) String location, Model model) throws Exception {
        model.addAttribute("caption", TYPE_LOCATION);
        if (StringUtils.hasLength(location)) {
            model.addAttribute("recommendedLocations", foursquareClient.getRecommendedLocationFor(location));
            model.addAttribute("caption", String.format(RECOMENDED_PLACES, location));
        }
        return "explore";
    }
}
