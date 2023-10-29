package capchelin.loggingManagementSystem.documents;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@ToString
//@Setting(settingPath = "/system_data/setting.json")
//@Mapping(mappingPath = "/system_data/mapping.json")
@Data
@Document(indexName = "mqtt_data"/*Indices.DATA_INDEX*/)
public class SearchData {

    @Id
    private Long dataId;
    private String dataName;
    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant createdDate;
    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant lastModifiedDate;


//    @Field(name = "data_latitude", type = FieldType.Long)
//    private Long dataLatitude;
//
//    @Field(name = "data_longitude", type = FieldType.Long)
//    private Long dataLongitude;
//
//    @Field(name = "data_angle_x", type = FieldType.Long)
//    private Long dataAngleX;
//
//    @Field(name = "data_angle_y", type = FieldType.Long)
//    private Long dataAngleY;
//
//    @Field(name = "status", type = FieldType.Byte)
//    private Byte status;
//
//    @Field(name = "battery", type = FieldType.Long)
//    private Long battery;

}
