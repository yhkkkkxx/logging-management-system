package capchelin.loggingManagementSystem.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@EnableElasticsearchAuditing
@EnableElasticsearchRepositories
@Configuration
public class ElasticConfiguration extends ElasticsearchConfiguration {
    @Value("${spring.elastic.url}")
    private String elasticUrl;

    @Value("${spring.elastic.user}")
    private String user;
    @Value("${spring.elastic.password}")
    private String password;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticUrl)
                .withBasicAuth(user, password)
                .build();
    }

}
