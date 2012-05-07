package uk.co.factorysix.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class ArrayOfLineStatus {

    @ElementList(inline = true, entry = "LineStatus")
    private List<LineStatus> lineStatuses;

    public List<LineStatus> lineStatuses() {
        return lineStatuses;
    }
}