package capchelin.loggingManagementSystem.service;

import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.repository.SearchDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService {
    private final SearchDataRepository searchDataRepository;
    private int counter = 0;

//    public SearchData create(SearchData searchData) { // 여기서 텍스트를 넘기면 레포로 세이브 되는 걸로
////        counter ++;
//        //searchData.setDataName("hi" + counter);
//
//        //data parsing and decoding

    public SearchData create(@NotNull Message message) { // 여기서 텍스트를 넘기면 레포로 세이브 되는 걸로

        System.out.println("Data Service: " + message);
        Object obj = message.getPayload();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SearchData searchData = objectMapper.readValue(message.getPayload().toString(), SearchData.class);
            System.out.println("data: "+searchData.getData());
            System.out.println("appID: "+searchData.getApplicationID());

            System.out.println("SearchData successfully processed and saved to Elasticsearch.");
            return searchDataRepository.save(searchData);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to process the MQTT message", e);
        }
    }


    public List<SearchData> find() {
        return StreamSupport.stream(searchDataRepository.findAll().spliterator(), false)
                .toList();
    }

   public void deleteById(@PathVariable String id) { searchDataRepository.deleteById(id); }

    public void delete() { searchDataRepository.deleteAll(); }
}
