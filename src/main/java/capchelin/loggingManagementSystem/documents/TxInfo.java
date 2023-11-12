package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TxInfo {
    private Long frequency;
    private Integer dr;

    // Getters and setters for the above fields
}
