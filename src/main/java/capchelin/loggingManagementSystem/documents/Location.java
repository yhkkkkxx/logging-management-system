package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("altitude")
    private double altitude;

    // Getters and setters for the above fields
}
