package uk.co.whitbread.model;

import java.util.List;

public class Group {
    private String type;
    private String name;
    private List<Item> items;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
