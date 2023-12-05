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
    private String applicationID;

    private String applicationName;

    private String deviceName;

    private String devEUI;

    private List<RxInfo> rxInfo;

    private TxInfo txInfo;

    private boolean adr;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private int fCnt;

    private int fPort;

    private String data;

    private ObjectData objectData;

    @Field(name = "@timestamp", type = FieldType.Date)
    private long curTime;

}


