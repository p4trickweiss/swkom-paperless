package at.technikumwien.swkom.paperlessrest.services.impl;


import at.technikumwien.swkom.paperlessrest.config.ElasticSearchConfig;
import at.technikumwien.swkom.paperlessrest.data.elasticsearch.ElasticSearchDocument;
import at.technikumwien.swkom.paperlessrest.services.ISearchService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticSearchService implements ISearchService {

    private final ElasticsearchClient esClient;

    @Autowired
    public ElasticSearchService(ElasticsearchClient esClient) throws IOException {
        this.esClient = esClient;

        if (!esClient.indices().exists(
                i -> i.index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
        ).value()) {
            esClient.indices().create(c -> c
                    .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
            );
        }
    }

    @Override
    public List<Integer> getDocumentByTitleContent(String text) {
        List<String> fields_names = new ArrayList<String>();
        fields_names.add("content");
        fields_names.add("filename");
        try {
            SearchResponse<ElasticSearchDocument> response = esClient.search(s -> s
                .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                .query(q -> q
                    .multiMatch(t -> t
                        .fields(fields_names)
                        .query(text)
                    )
                ),
                ElasticSearchDocument.class
            );

            List<Hit<ElasticSearchDocument>> hits = response.hits().hits();
            System.out.printf("HITS: " + hits.size());
            List<Integer> ids = new ArrayList<Integer>();

            for (Hit<ElasticSearchDocument> hit: hits) {
                ElasticSearchDocument doc = hit.source();
                ids.add(Integer.valueOf(doc.getId()));
            }

            return ids;

        } catch (Exception e) {
            System.out.printf(e.getMessage());
            return null;
        }
    }

}
