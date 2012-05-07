package uk.co.factorysix;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import uk.co.factorysix.model.ArrayOfLineStatus;
import uk.co.factorysix.model.BranchDisruption;
import uk.co.factorysix.model.LineStatus;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.System.out;

public class Demo {

    private final static Logger LOG = Logger.getLogger(Demo.class.getName());
    private final static String LINE_STATUS_URL = "http://cloud.tfl.gov.uk/TrackerNet/LineStatus";

    public static void main(String[] args) {
        Demo parserCore = new Demo();

        try {
            URL localFileUrl = new URL(LINE_STATUS_URL);
            LOG.info("Using URL: [ " + localFileUrl.toString() + " ]");
            parserCore.parseLineStatus(localFileUrl);
        }
        catch (MalformedURLException e) {
            LOG.log(Level.INFO, "Malformed URL", e);
        }
    }

    private void parseLineStatus(URL fileLocation) {
        Serializer lineStatusSerializer = new Persister();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(fileLocation.openStream()));

            StringBuilder xmlFile = new StringBuilder();
            String xmlLine = in.readLine();
            String cleanXMLLine = "";
            while(xmlLine != null) {
                cleanXMLLine = xmlLine.trim().replaceFirst("^([\\W]+)<","<");
                xmlFile.append(cleanXMLLine);
                xmlLine = in.readLine();
            }

            ArrayOfLineStatus lineStatusesArray = lineStatusSerializer.read(ArrayOfLineStatus.class, xmlFile.toString());
            List<LineStatus> lineStatusList = lineStatusesArray.lineStatuses();

            for(LineStatus lineStatus : lineStatusList) {
                out.println(lineStatus.getLine().getName() + ": " + lineStatus.getStatus().getDescription());
                out.println(lineStatus.getStatusDetails());
                for(BranchDisruption branchDisruption : lineStatus.getBranchDisruptions()) {
                	out.println("Branch Disruption:");
                	if(branchDisruption.getStationFrom() != null) 
                	{	out.println("From: " + branchDisruption.getStationFrom().getName());	}
                	if(branchDisruption.getStationTo() != null)
                	{	out.println("To: " + branchDisruption.getStationTo().getName());	}
                	if(branchDisruption.getStationVia() != null) 
                	{	out.println("Via: " + branchDisruption.getStationVia().getName());	}
                	
                }
                out.println();
            }
        }
        catch (Exception e) {
            LOG.log(Level.INFO, "Problem encountered while parsing", e);
        }

    }
}
