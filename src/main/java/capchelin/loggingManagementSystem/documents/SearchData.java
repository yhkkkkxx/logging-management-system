package capchelin.loggingManagementSystem.documents;

import lombok.*;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

@Data
@Document(indexName = "mqtt_data")
@RequiredArgsConstructor
public class SearchData {

    String message;

    @Id
    private String applicationID;
    private String applicationName;
    private String deviceName;

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

    public SearchData(String message) {
        this.message = message;
    }

    public SearchData(String applicationID, String applicationName, String deviceName) {
        this.applicationID = applicationID;
        this.applicationName = applicationName;
        this.deviceName = deviceName;
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
