package uk.co.whitbread.model;

public class ResultLocation {
    private String name;
    private String category;

    public ResultLocation(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
