package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class RxInfo {
    @JsonProperty("gatewayID")
    private String gatewayID;
    @JsonProperty("uplinkID")
    private String uplinkID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rssi")
    private int rssi;
    @JsonProperty("loRaSNR")
    private double loRaSNR;
    @JsonProperty("location")
    private Location location;
}

