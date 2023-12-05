package capchelin.loggingManagementSystem.service;

import capchelin.loggingManagementSystem.documents.Payload;
import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.repository.PayloadRepository;
import capchelin.loggingManagementSystem.repository.SearchDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService {
    private final SearchDataRepository searchDataRepository;
    private final PayloadRepository payloadRepository;

    public SearchData createApp(Message message) {
        System.out.println("this is application");
//        if (Objects.isNull(message)) {
//
//        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SearchData searchData = objectMapper.readValue(message.getPayload().toString(), SearchData.class);
            System.out.println("data: " + searchData.getData());
            System.out.println("SearchData successfully processed and saved to Elasticsearch.");

//            Long time = System.currentTimeMillis();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//            String str = timeFormat.format(new Date(time));
//            searchData.setCurTime(Long.parseLong(str));
            searchData.setCurTime(System.currentTimeMillis());

            System.out.println("search data: " + searchData);
//
//            System.out.println("ID: "+searchData.getApplicationID());
//            System.out.println("Name: "+searchData.getApplicationName());
//            System.out.println("deviceName: "+searchData.getDeviceName());
//            System.out.println("devEUI: "+searchData.getDevEUI());
//            System.out.println("Rx: "+searchData.getRxInfo());
//            System.out.println("Tx: "+searchData.getTxInfo());
//            System.out.println("FCnt: "+searchData.getFCnt());
//            System.out.println("FPort: "+searchData.getFPort());
//            System.out.println("Data: "+searchData.getData());
//            System.out.println("ObjectData: "+searchData.getObjectData());
//            System.out.println("curTime: "+searchData.getCurTime());


            return searchDataRepository.save(searchData);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to process the MQTT message", e);
        }

    }

    public Payload createGateway(@NotNull Message message) {

        System.out.println("this is gateway");

        Object obj = message.getPayload();
        ObjectMapper objectMapper = new ObjectMapper();
        String hi = obj.toString();
        System.out.println(hi);

        String payloadJson = "{ \"payload\" : \"";
        payloadJson += obj.toString();
        payloadJson += "\" }";
        System.out.println(payloadJson);

        //System.currentTimeMillis()
        MessageHeaders headers = message.getHeaders();

        //System.out.println(headers);

        //Long id = (Long)headers.get("timestamp");
        Long id = System.currentTimeMillis();
        Payload payload = new Payload(id, headers, message.getPayload().toString());
//        long curTime = System.currentTimeMillis();
//        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String str = timeFormat.format(new Date(curTime));
        //payload.setId(System.currentTimeMillis());
        //System.out.println(id);
//        System.out.println("paylod heaers :"+payload.getHeaders());
//        System.out.println(payload.getPayload());
//        System.out.println(payload.getId());

        return payloadRepository.save(payload);
    }

    public List<SearchData> find() {
        return StreamSupport.stream(searchDataRepository.findAll().spliterator(), false)
                .toList();
    }

   public void deleteById(@PathVariable String id) { searchDataRepository.deleteById(id); }

    public void delete() { searchDataRepository.deleteAll(); }

}
