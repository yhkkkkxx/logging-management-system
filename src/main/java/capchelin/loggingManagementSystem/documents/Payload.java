package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.messaging.MessageHeaders;

import java.util.List;
@Document(indexName = "payloads")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class Payload {
    @Id
    private Long id;

    private MessageHeaders headers;
    @JsonProperty("payload")
    private String payload;

    @Field(name = "@timestamp", type = FieldType.Date)
    private long curTime;
}
