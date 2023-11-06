package capchelin.loggingManagementSystem.documents;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;
import java.util.List;

@Data
@Document(indexName = "mqtt_data")
public class SearchData {

    String message;

    // Getter 및 Setter 메서드 추가
    @Getter
    @Id
    private String applicationID;
    @Getter
    private String applicationName;
    @Getter
    private String deviceName;
    @Getter
    private String devEUI;
    @Getter
    private List<RxInfo> rxInfo;
    @Getter
    private TxInfo txInfo;
    @Getter
    private boolean adr;
    private int fCnt;
    private int fPort;
    @Getter
    private String data;

//    @Id
//    private String dataId;
//    private Long dataLatitude;
//    private Long dataLongitude;
//    private Long dataAngleX;
//    private Long dataAngleY;
//    private Byte status;
//    private Long battery;
    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant createdDate;
    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant lastModifiedDate;

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDevEUI(String devEUI) {
        this.devEUI = devEUI;
    }

    public void setRxInfo(List<RxInfo> rxInfo) {
        this.rxInfo = rxInfo;
    }

    public void setTxInfo(TxInfo txInfo) {
        this.txInfo = txInfo;
    }

    public void setAdr(boolean adr) {
        this.adr = adr;
    }

    public int getFCnt() {
        return fCnt;
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
