package capchelin.loggingManagementSystem.service;

import capchelin.loggingManagementSystem.documents.SearchData;
import capchelin.loggingManagementSystem.repository.SearchDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService {
    private final SearchDataRepository searchDataRepository;
    private int counter = 0;

    public SearchData create() {
        counter ++;
        SearchData searchData = new SearchData();
        searchData.setDataName("hi" + counter);
        return searchDataRepository.save(searchData);
    }

    public List<SearchData> find() {
        return StreamSupport.stream(searchDataRepository.findAll().spliterator(), false)
                .toList();
    }

   public void deleteById(@PathVariable String id) { searchDataRepository.deleteById(id); }

    public void delete() { searchDataRepository.deleteAll(); }
}