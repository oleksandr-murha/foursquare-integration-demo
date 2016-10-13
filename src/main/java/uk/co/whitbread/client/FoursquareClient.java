package uk.co.whitbread.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.whitbread.model.RecommendedLocation;
import uk.co.whitbread.model.foursquare.Category;
import uk.co.whitbread.model.foursquare.Item;
import uk.co.whitbread.model.foursquare.Venue;
import uk.co.whitbread.model.foursquare.VenuesExploreResponse;
import uk.co.whitbread.utils.UrlBuilder;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

@Component
public class FoursquareClient {

    private Logger LOG = Logger.getLogger(FoursquareClient.class.getName());

    private RestTemplate restTemplate;
    private UrlBuilder urlBuilder;

    @Autowired
    FoursquareClient(UrlBuilder urlBuilder, RestTemplate restTemplate) {
        this.urlBuilder = urlBuilder;
        this.restTemplate = restTemplate;
    }

    public List<RecommendedLocation> getRecommendedLocationFor(String location){
        try {
            VenuesExploreResponse venuesExploreResponse = restTemplate.getForObject(urlBuilder.buildUrl(location),
                    VenuesExploreResponse.class);
            return venuesExploreResponse.getResponse().getGroups().stream()
                    .flatMap(group -> group.getItems()
                            .stream()).map(Item::getVenue).map(this::convert).collect(toList());
        }catch (Exception ex){
            LOG.log(Level.WARNING, "Error getting response from Foursquare", ex);
            return Collections.emptyList();
        }
    }

    private RecommendedLocation convert(Venue venue){
        return new RecommendedLocation(venue.getName(), venue.getCategories()
                .stream().findFirst().orElse(new Category()).getName());
    }
}
