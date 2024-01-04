package at.technikumwien.swkom.paperlessservices.services;

import at.technikumwien.swkom.paperlessservices.models.ElasticSearchDocument;
import co.elastic.clients.elasticsearch._types.Result;

import java.io.IOException;
import java.util.Optional;

public interface ISearchIndexService {
    Result indexDocument(ElasticSearchDocument document) throws IOException;

    //Optional<Document> getDocumentById(int id);

    boolean deleteDocumentById(int id);
}
