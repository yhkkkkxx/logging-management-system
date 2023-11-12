package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class RxInfo {
    private String gatewayID;
    private String uplinkID;
    private String name;
    private int rssi;
    private double loRaSNR;
    private Location location;
}

