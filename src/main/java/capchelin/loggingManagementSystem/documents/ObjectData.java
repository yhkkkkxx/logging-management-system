package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

import java.util.List;

public class ObjectData {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String abnormal_detection;

    private int angleX;

    private int angleY;

    private int battery;

    private String drive_status;

    private String falldown;

    private int latitude;

    private int longitude;

    private String sensor_error;

    private int status;

}
