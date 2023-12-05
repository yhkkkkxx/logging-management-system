package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectData {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonProperty("abnormal_detection")
    private String abnormal_detection;

    @JsonProperty("angleX")
    private int angleX;
    @JsonProperty("angleY")
    private int angleY;
    @JsonProperty("battery")
    private int battery;
    @JsonProperty("drive_status")
    private String drive_status;

    @JsonProperty("falldown")
    private String falldown;

    @JsonProperty("latitude")
    private int latitude;

    @JsonProperty("longitude")
    private int longitude;

    @JsonProperty("sensor_error")
    private String sensor_error;

    @JsonProperty("status")
    private int status;

}
