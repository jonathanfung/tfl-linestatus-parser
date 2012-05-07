package uk.co.factorysix.model;

import org.simpleframework.xml.Element;

public class BranchDisruption {

    @Element(name = "StationTo", required = false)
    private StationTo stationTo;

    @Element(name = "StationFrom", required = false)
    private StationFrom stationFrom;

    @Element(name = "StationVia", required = false)
    private StationVia stationVia;
    
    public StationTo getStationTo() {
        return stationTo;
    }

    public StationFrom getStationFrom() {
        return stationFrom;
    }

	public StationVia getStationVia() {
		return stationVia;
	}
    
}
