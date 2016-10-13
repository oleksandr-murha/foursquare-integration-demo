package uk.co.whitbread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import uk.co.whitbread.model.RecommendedLocation;
import uk.co.whitbread.model.foursquare.Category;
import uk.co.whitbread.model.foursquare.Item;
import uk.co.whitbread.model.foursquare.Venue;
import uk.co.whitbread.model.foursquare.VenuesExploreResponse;
import uk.co.whitbread.utils.UrlBuilder;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Controller
public class VenuesExploreController {

    private static final String TYPE_LOCATION = "Please type location into search box";
    private static final String RECOMENDED_PLACES = "Recommended locations around %s!";
    @Autowired
    private UrlBuilder urlBuilder;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/explore.html")
    public String exploreVenue(@RequestParam(required = false) String location, Model model) throws Exception {
        model.addAttribute("caption", TYPE_LOCATION);
        if (StringUtils.hasLength(location)) {
            VenuesExploreResponse venuesExploreResponse = restTemplate.getForObject(urlBuilder.buildUrl(location), VenuesExploreResponse.class);
            List<RecommendedLocation> recommendedLocations = venuesExploreResponse.getResponse().getGroups().stream().flatMap(group -> group.getItems().stream()).map(Item::getVenue).map(this::convert).collect(toList());
            model.addAttribute("recommendedLocations", recommendedLocations);
            model.addAttribute("caption", String.format(RECOMENDED_PLACES, venuesExploreResponse.getResponse().getHeaderFullLocation()));
        }
        return "explore";
    }

    private RecommendedLocation convert(Venue venue){
        return new RecommendedLocation(venue.getName(), venue.getCategories().stream().findFirst().orElse(new Category()).getName());
    }
}
