package capchelin.loggingManagementSystem.controller;

import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller("/search-data")
public class DataController {
    private final DataService dataService;

    @GetMapping("/create")
    public SearchData create() { return dataService.create(); }

    @GetMapping("/find")
    public List<SearchData> find() { return dataService.find(); }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) { dataService.deleteById(id); }

    @GetMapping("/delete")
    public void delete() { dataService.delete(); }

}
