package uk.co.whitbread.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.whitbread.properties.FoursquareProperties;

@Component
public class UrlBuilder {

    private FoursquareProperties properties;

    @Autowired
    UrlBuilder(FoursquareProperties properties) {
        this.properties = properties;
    }

    public String buildUrl(String location) {
        return String.format(properties.getBaseUrl(),
                properties.getClientId(),
                properties.getClientSecret(),
                location,
                properties.getVersion(),
                properties.getMode());
    }
}
