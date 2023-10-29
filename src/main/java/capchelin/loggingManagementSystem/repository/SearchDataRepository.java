package capchelin.loggingManagementSystem.repository;

import capchelin.loggingManagementSystem.documents.SearchData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchDataRepository extends ElasticsearchRepository<SearchData, String> {

}
