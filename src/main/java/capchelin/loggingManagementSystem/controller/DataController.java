package capchelin.loggingManagementSystem.controller;

import capchelin.loggingManagementSystem.documents.Payload;
import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search-data")
public class DataController {
    private final DataService dataService;

    @PostMapping("/application")
    public SearchData createApp(Message message) {
        SearchData searchData = new SearchData();
        return dataService.createApp(message);
    }

    @PostMapping("/gateway")
    public Payload createGateway(Message message) {
        return dataService.createGateway(message);
    }

//    @PostMapping("/sample")
//    public String create1(String searchData) {
//        return "sample";
//    }

    @GetMapping
    public List<SearchData> find() { return dataService.find(); }

    @DeleteMapping
    public void delete() { dataService.delete(); }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) { dataService.deleteById(id); }

}
