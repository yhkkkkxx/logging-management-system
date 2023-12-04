package capchelin.loggingManagementSystem.repository;

import capchelin.loggingManagementSystem.documents.Payload;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends ElasticsearchRepository<Payload, String> {

}