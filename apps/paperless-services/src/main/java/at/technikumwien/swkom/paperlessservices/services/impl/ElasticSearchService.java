package at.technikumwien.swkom.paperlessservices.services.impl;


import at.technikumwien.swkom.paperlessservices.config.ElasticSearchConfig;
import at.technikumwien.swkom.paperlessservices.services.ISearchIndexService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ElasticSearchService implements ISearchIndexService {

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

    /*
    @Override
    public Result indexDocument() throws IOException {
        // do indexing with ElasticSearch
        IndexResponse response = esClient.index(i -> i
                .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                .id(document.getId().toString())
                .document(document)
        );
        String logMsg = "Indexed document " + document.getId() + ": result=" + response.result() + ", index=" + response.index();
        if (response.result() != Result.Created && response.result() != Result.Updated)
            System.out.println("Failed to " + logMsg);
        else
            System.out.println(logMsg);
        return response.result();
    }
     */

    /*
    @Override
    public Optional<Document> getDocumentById(int id) {
        try {
            GetResponse<Document> response = esClient.get(g -> g
                            .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                            .id(String.valueOf(id)),
                    Document.class
            );
            return (response.found() && response.source() != null) ? Optional.of(response.source()) : Optional.empty();
        } catch (IOException e) {
            log.error("Failed to get document id=" + id + " from elasticsearch: " + e);
            return Optional.empty();
        }
    }
     */

    @Override
    public boolean deleteDocumentById(int id) {
        DeleteResponse result = null;
        try {
            result = esClient.delete(d -> d.index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME).id(String.valueOf(id)));
        } catch (IOException e) {
            System.out.println("Failed to delete document id=" + id + " from elasticsearch: " + e);
        }
        if (result == null)
            return false;
        if (result.result() != Result.Deleted)
            System.out.println(result.toString());
        return result.result() == Result.Deleted;
    }

}
