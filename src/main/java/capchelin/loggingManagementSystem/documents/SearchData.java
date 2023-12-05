package capchelin.loggingManagementSystem.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "lora_data")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchData {
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;
//    @Id
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

    @Field(type = FieldType.Date)
    private long curTime;

    @Override
    public String toString() {
        return "SearchData{" +
                "applicationID='" + applicationID + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", devEUI='" + devEUI + '\'' +
                ", rxInfo=" + rxInfo +
                ", txInfo=" + txInfo +
                ", adr=" + adr +
                ", fCnt=" + fCnt +
                ", fPort=" + fPort +
                ", data='" + data + '\'' +
                ", objectData=" + objectData +
                ", curTime=" + curTime +
                '}';
    }
}


