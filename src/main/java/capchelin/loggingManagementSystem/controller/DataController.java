package capchelin.loggingManagementSystem.controller;

import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller
@RequestMapping("/search-data")
public class DataController {
    private final DataService dataService;


    @PostMapping
    public SearchData create(@RequestParam SearchData text) { return dataService.create(text); }

    @GetMapping
    public List<SearchData> find() { return dataService.find(); }

    @DeleteMapping
    public void delete() { dataService.delete(); }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) { dataService.deleteById(id); }

}
