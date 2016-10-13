package uk.co.whitbread.model.foursquare;

import java.util.List;

public class Venue {
    private String name;
    private List<Category> categories;

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
