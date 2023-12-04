package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Header {

    private boolean mqttReceivedRetained;
    private int mqttId;
    private boolean mqttDuplicate;
    private String id;
    private String mqttReceivedTopic;
    private int mqttReceivedQos;
    private long timestamp;

}
