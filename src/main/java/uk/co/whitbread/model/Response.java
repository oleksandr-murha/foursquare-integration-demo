package uk.co.whitbread.model;

import java.util.List;

public class Response {
    private String headerLocation;
    private String headerFullLocation;
    private String headerLocationGranularity;

    private List<Group> groups;

    public String getHeaderLocation() {
        return headerLocation;
    }

    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
