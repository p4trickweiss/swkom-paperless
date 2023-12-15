package at.technikumwien.swkom.paperlessservices.services;

import co.elastic.clients.elasticsearch._types.Result;

import java.io.IOException;
import java.util.Optional;

public interface ISearchIndexService {
    //Result indexDocument() throws IOException;

    //Optional<Document> getDocumentById(int id);

    boolean deleteDocumentById(int id);
}
