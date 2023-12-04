package capchelin.loggingManagementSystem.documents;

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


    // Getter 및 Setter 메서드 추가
    @Getter
    @Id
    private String applicationID;

    private String applicationName;

    private String deviceName;

    private String devEUI;

    private List<RxInfo> rxInfo;

    private TxInfo txInfo;

    private boolean adr;

    private int fCnt;

    private int fPort;

    private String data;

    private long curTime = System.currentTimeMillis();

}

    public void setFCnt(int fCnt) {
        this.fCnt = fCnt;
    }

    public int getFPort() {
        return fPort;
    }

    public void setFPort(int fPort) {
        this.fPort = fPort;
    }

    public void setData(String data) {
        this.data = data;
    }
//    public SearchData(String dataId, Long dataLatitude, Long dataLongitude, Long dataAngleX, Long dataAngleY, Byte status, Long battery) {
//        this.dataId = dataId;
//        this.dataLatitude = dataLatitude;
//        this.dataLongitude = dataLongitude;
//        this.dataAngleX = dataAngleX;
//        this.dataAngleY = dataAngleY;
//        this.status = status;
//        this.battery = battery;
//    }

}
