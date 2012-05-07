package uk.co.factorysix.model;

import org.simpleframework.xml.Attribute;

public class StatusType {

    @Attribute(name = "ID")
    private int id;

    @Attribute(name = "Description")
    private String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
