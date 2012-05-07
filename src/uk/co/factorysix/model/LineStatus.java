package uk.co.factorysix.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class LineStatus {

    @Attribute(name = "ID")
    private int id;

    @Attribute(name = "StatusDetails")
    private String statusDetails;

    @ElementList(name = "BranchDisruptions")
    private List<BranchDisruption> branchDisruptions;

    @Element(name = "Line")
    private Line line;
    
    @Element(name = "Status")
    private Status status;

    public int getId() {
        return id;
    }

    public String getStatusDetails() {
        return statusDetails;
    }

    public List<BranchDisruption> getBranchDisruptions() {
        return branchDisruptions;
    }

    public Line getLine() {
        return line;
    }

    public Status getStatus() {
        return status;
    }
}
