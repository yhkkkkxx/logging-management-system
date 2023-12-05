package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Timespan;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;

@Data
@Document(indexName = "mqtt_data")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchData {


    @Id
    @JsonProperty("applicationID")
    private String applicationID;

    private String applicationName;

    private String deviceName;

    private String devEUI;

    private List<RxInfo> rxInfo;

    private TxInfo txInfo;

    private boolean adr;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonProperty("fCnt")
    private int fCnt;
    @JsonProperty("fPort")
    private int fPort;

    private String data;
    @JsonProperty("object")
    private ObjectData objectData;

    @Field(name = "@timestamp", type = FieldType.Date)
    private long curTime;

}


