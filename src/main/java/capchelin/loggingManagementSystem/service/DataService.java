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

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService {
    private final SearchDataRepository searchDataRepository;
    private final PayloadRepository payloadRepository;

    public SearchData createApp(@NotNull Message message) {
        System.out.println("this is application");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SearchData searchData = objectMapper.readValue(message.getPayload().toString(), SearchData.class);
            System.out.println("data: " + searchData.getData());
            System.out.println("SearchData successfully processed and saved to Elasticsearch.");
            searchData.setCurTime(System.currentTimeMillis());
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
        Long id = (Long)headers.get("timestamp");
        Payload payload = new Payload(id, headers, message.getPayload().toString());
        payload.setId(System.currentTimeMillis());

        return payloadRepository.save(payload);
    }

    public List<SearchData> find() {
        return StreamSupport.stream(searchDataRepository.findAll().spliterator(), false)
                .toList();
    }

   public void deleteById(@PathVariable String id) { searchDataRepository.deleteById(id); }

    public void delete() { searchDataRepository.deleteAll(); }

}
