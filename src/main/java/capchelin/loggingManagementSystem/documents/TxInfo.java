package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TxInfo {
    @JsonProperty("frequency")
    private Long frequency;
    private Integer dr;

    // Getters and setters for the above fields
}
