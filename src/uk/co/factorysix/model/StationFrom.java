package uk.co.factorysix.model;

import org.simpleframework.xml.Attribute;

public class StationFrom {
    @Attribute(name = "ID")
    private int id;

    @Attribute(name = "Name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
