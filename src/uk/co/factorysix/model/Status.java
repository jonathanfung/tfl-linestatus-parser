/**
 * factorysix.co.uk
 * @author Jonathan Fung
 */
package uk.co.factorysix.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Status {

    @Attribute(name = "ID")
    private String id;

    @Attribute(name = "CssClass")
    private String cssClass;

    @Attribute(name = "Description")
    private String description;

    @Attribute(name = "IsActive")
    private Boolean isActive;

    @Element(name = "StatusType")
    private StatusType statusType;

    public String getId() {
        return id;
    }

    public String getCssClass() {
        return cssClass;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public StatusType getStatusType() {
        return statusType;
    }
}
