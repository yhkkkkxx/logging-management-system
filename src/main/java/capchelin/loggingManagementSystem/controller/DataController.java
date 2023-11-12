package capchelin.loggingManagementSystem.controller;

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

//
//    @PostMapping
//    public SearchData create(@RequestBody SearchData searchData) {
//
//        return dataService.create(searchData);
//    }
    @PostMapping
    public SearchData create(Message message) {

        return dataService.create(message);
    }

    @PostMapping("/sample")
    public String create1(String searchData) {
//        return dataService.create(searchData);
        return "sample";
    }


    @GetMapping
    public List<SearchData> find() { return dataService.find(); }

    @DeleteMapping
    public void delete() { dataService.delete(); }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) { dataService.deleteById(id); }

}
