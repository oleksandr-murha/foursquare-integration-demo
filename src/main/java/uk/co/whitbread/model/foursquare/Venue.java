package uk.co.whitbread.model.foursquare;

import java.util.List;

public class Venue {
    private String name;
    private Location location;
    private List<Category> categories;

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
